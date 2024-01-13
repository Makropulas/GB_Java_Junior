package dz2.task1;

import java.util.ArrayList;

public class Dog extends Animal {
    private final ArrayList<String> commands;

    public Dog(String name, int age) {
        super(name, age);
        commands = new ArrayList<>();
    }

    public void addCommand(String command) {
        commands.add(command);
    }

    public String getCommands() {
        return String.join(", ", commands);
    }

    @Override
    public String getClassname() {
        return "Собака";
    }
}
