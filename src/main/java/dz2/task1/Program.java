package dz2.task1;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Program {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {
        Animal[] animals = {
                new Cat("Мурка", 10),
                new Dog("Барбос", 5),
                new Cat("Барсик", 2),
                new Dog("Бобик", 3)
        };

        for (Animal animal : animals) {
            Class<?> animalClass = animal.getClass().getSuperclass();
            Field nameField = animalClass.getDeclaredField("name");
            nameField.setAccessible(true);
            Field ageField = animalClass.getDeclaredField("age");
            ageField.setAccessible(true);
            System.out.println("Объект " + animalClass.getSimpleName() +
                    ", name = " + nameField.get(animal) +
                    ", age = " + ageField.get(animal));
        }

        System.out.println("------------------------------");

        for (Animal animal : animals) {
            Class<?> animalClass = animal.getClass();
            Method[] methods = animalClass.getDeclaredMethods();
            for (Method method : methods) {
                if (method.getName().equals("makeSound")) {
                    System.out.print(animal + " : ");
                    System.out.println(method.invoke(animal));
                }
            }
        }
    }
}