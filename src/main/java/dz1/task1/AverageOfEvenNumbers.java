package dz1.task1;

import java.util.List;

public class AverageOfEvenNumbers {
    public static void main(String[] args) {
        List<Integer> integerList = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);

        double averageOfEvens = integerList.stream()
                .filter(num -> num % 2 == 0)
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0);

        System.out.println(averageOfEvens);
    }
}
