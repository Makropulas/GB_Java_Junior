package dz4.models;

import javax.persistence.*;
import java.util.Random;

@Entity
@Table(name = "Courses")
public class Course {
    private static final Random random = new Random();
    private static final String[] titles = new String[]{"Java", "Python", "JavaScript", "Kotlin", "C#", "C++", "PHP", "C", "Swift", "Ruby"};

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private int duration;

    public Course() {

    }

    public Course(String title, int duration) {
        this.title = title;
        this.duration = duration;
    }

    public static Course create(){
        return new Course(titles[random.nextInt(titles.length)], random.nextInt(6, 16));
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void updateTitle(){
        title = titles[random.nextInt(titles.length)];
    }

    public void updateDuration(){
        duration = random.nextInt(6, 16);
    }

    @Override
    public String toString() {
        return String.format("Курс: '%s', длительность обучения: %d, ID: %d.", title, duration, id);
    }
}
