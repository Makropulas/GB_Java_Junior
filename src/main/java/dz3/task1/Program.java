package dz3.task1;

import java.io.*;

public class Program {
    public static void main(String[] args) {
        Student student = new Student("Dmitry", 36, 4.98);
        Student newStudent;

        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("dz3_task1.bin"))) {
            outputStream.writeObject(student);
            System.out.println("Объект успешно сериализован");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("dz3_task1.bin"))) {
            newStudent = (Student) inputStream.readObject();
            System.out.println("Десериализованный объект: " + newStudent);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

// Значение GPA не было сохранено/восстановлено, потому что это поле помечено модификатором transient.
