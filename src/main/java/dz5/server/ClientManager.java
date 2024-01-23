package dz5.server;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class ClientManager implements Runnable {
    public static ArrayList<ClientManager> clients = new ArrayList<>();

    private Socket socket;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;
    private String name;

    public ClientManager(Socket socket) {
        try {
            this.socket = socket;
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            name = bufferedReader.readLine();
            clients.add(this);
            System.out.println(name + " подключился к чату.");
            broadcastMessage("Server: " + name + " подключился к чату.");
        } catch (IOException e) {
            closeEverything(socket, bufferedReader, bufferedWriter);
        }
    }

    private void removeClient() {
        clients.remove(this);
        System.out.println(name + " покинул чат.");
        broadcastMessage("Server: " + name + " покинул чат.");
    }

    @Override
    public void run() {
        String messageFromClient;
        while (socket.isConnected()) {
            try {
                messageFromClient = bufferedReader.readLine();
                if (messageFromClient == null) {
                    closeEverything(socket, bufferedReader, bufferedWriter);
                    break;
                }
                broadcastMessage(messageFromClient);
            } catch (IOException e) {
                closeEverything(socket, bufferedReader, bufferedWriter);
                break;
            }
        }
    }

    private void broadcastMessage(String message) {
        if (message != null) {
            String[] f = message.split(" ");
            if (f[1].startsWith("@")) {
                String userName = f[1].substring(1);
                if (clients.stream().anyMatch(client -> client.name.equals(userName)))
                    clients.forEach(client -> {
                        if (client.name.equals(userName)) {
                            try {
                                client.bufferedWriter.write(message.replace(f[1], "(ЛИЧНОЕ СООБЩЕНИЕ)"));
                                client.bufferedWriter.newLine();
                                client.bufferedWriter.flush();
                            } catch (IOException e) {
                                closeEverything(socket, bufferedReader, bufferedWriter);
                            }
                        }
                    });
                else clients.forEach(client -> {
                    if (client.equals(this))
                        try {
                            client.bufferedWriter.write("Server: Пользователь '" + userName + "' не зарегистрирован в чате. Ваше сообщение не было доставлено");
                            client.bufferedWriter.newLine();
                            client.bufferedWriter.flush();
                        } catch (IOException e) {
                            closeEverything(socket, bufferedReader, bufferedWriter);
                        }
                });
            } else {
                for (ClientManager client : clients) {
                    try {
                        if (!client.name.equals(name)) {
                            client.bufferedWriter.write(message);
                            client.bufferedWriter.newLine();
                            client.bufferedWriter.flush();
                        }
                    } catch (IOException e) {
                        closeEverything(socket, bufferedReader, bufferedWriter);
                    }
                }
            }
        }
    }

    private void closeEverything(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedWriter) {
        removeClient();
        try {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }
            if (socket != null) {
                socket.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
