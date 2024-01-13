package dz2.task1;

public class Cat extends Animal {
    private final String[] sounds = {"Мяу", "Муррр"};

    public Cat(String name, int age) {
        super(name, age);
    }

    public String makeSound() {
        return sounds[(int) Math.round(Math.random())];
    }

    @Override
    public String getClassname() {
        return "Кошка";
    }
}
