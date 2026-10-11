package org.example;

import java.util.Scanner;

public class task_3 {
    static void main() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Введите целое положительное число N: ");
            if (!scanner.hasNextLong()) {
                System.out.println("Нужно ввести целое число.");
                return;
            }

            long number = scanner.nextLong();
            if (number <= 0) {
                System.out.println("Число N должно быть положительным.");
                return;
            }

            int digitCount = 0;
            long digitSum = 0;

            while (number > 0) {
                digitSum += number % 10;
                digitCount++;
                number /= 10;
            }

            System.out.println(digitCount + " " + digitSum);
        }
    }
}
