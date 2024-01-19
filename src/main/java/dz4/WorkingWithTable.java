package dz4;

import dz4.models.Course;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class WorkingWithTable {
    private static final SessionFactory sessionFactory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(Course.class)
            .buildSessionFactory();

    public static void main(String[] args) {
        // Создание объекта
        Course course = Course.create();

        // Сохранение объекта в базе данных
        saveObjectInDatabase(course);

        // Чтение объекта из базы данных
        Course retrievedCourse = readingObjectFromDatabase(course);

        // Обновление объекта
        updateObjectInDatabase(retrievedCourse);

        // Удаление объекта
        removeObjectFromDatabase(retrievedCourse);
    }

    public static void saveObjectInDatabase(Course course) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(course);
            session.getTransaction().commit();
            System.out.println("Сохранение объекта Course выполнено успешно!\n");
        }
    }

    public static Course readingObjectFromDatabase(Course course) {
        Course retrievedCourse;
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            retrievedCourse = session.get(Course.class, course.getId());
            session.getTransaction().commit();
            System.out.println("Объект Course успешно получен!");
            System.out.println("Полученный объект Course: " + retrievedCourse + '\n');
        }
        return retrievedCourse;
    }

    public static void updateObjectInDatabase(Course retrievedCourse) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            retrievedCourse.updateTitle();
            retrievedCourse.updateDuration();
            session.update(retrievedCourse);
            session.getTransaction().commit();
            System.out.println("Обновление объекта Course выполнено успешно!!\n");
        }
    }

    public static void removeObjectFromDatabase(Course retrievedCourse) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.delete(retrievedCourse);
            session.getTransaction().commit();
            System.out.println("Удаление объекта Course выполнено успешно!\n");
        }
    }
}
