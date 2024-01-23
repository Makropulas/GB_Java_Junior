package dz5;

import dz5.client.Client;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class ClientLauncher {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Введите своё имя: ");
            String name = scanner.nextLine();

            InetAddress address = InetAddress.getLocalHost();

            Socket socket = new Socket(address, 1111);
            Client client = new Client(socket, name);
            InetAddress inetAddress = socket.getInetAddress();
            String remoteIp = inetAddress.getHostAddress();

            System.out.println("InetAddress: " + inetAddress);
            System.out.println("Remote IP: " + remoteIp);
            System.out.println("LocalPort:" + socket.getLocalPort());
            System.out.println("\n*** Для отправки личного сообщения, начните свой текст с @ИмяПользователя (Пример: @User Message text) ***\n");

            client.listenForMessage();
            client.sendMessage();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
