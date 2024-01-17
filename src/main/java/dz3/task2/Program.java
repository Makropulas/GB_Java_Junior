package dz3.task2;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import dz3.task1.Student;

import java.io.File;
import java.io.IOException;

public class Program {
    static final String FILE_JSON = "dz3_task2.json";
    static final String FILE_XML = "dz3_task2.xml";

    public static void main(String[] args) {
        Student student = new Student("Tsira", 36, 4.98);
        Student downloadedStudentFromJson;
        Student downloadedStudentFromXml;

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);

        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.configure(SerializationFeature.INDENT_OUTPUT, true);

        try {
            objectMapper.writeValue(new File(FILE_JSON), student);
            xmlMapper.writeValue(new File(FILE_XML), student);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            downloadedStudentFromJson = objectMapper.readValue(new File(FILE_JSON), objectMapper.constructType(Student.class));
            downloadedStudentFromXml = xmlMapper.readValue(new File(FILE_XML), xmlMapper.constructType(Student.class));
            System.out.println("Downloaded from JSON: " + downloadedStudentFromJson);
            System.out.println("Downloaded from XML: " + downloadedStudentFromXml);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
