package dz2.task1;

public abstract class Animal implements ClassnameInterface {
    private final String name;
    private final int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("%s по кличке '%s', возраст %dг.", getClassname(), name, age);
    }
}
