package org.example;

import java.util.Scanner;

public class task_4 {
    public static double printParts(double number) {
        double integerPart = number >= 0 ? Math.floor(number) : Math.ceil(number);
        double fractionalPart = number - integerPart;

        System.out.println("Исходное число: " + number);
        System.out.println("Целая часть: " + integerPart);
        System.out.println("Дробная часть: " + fractionalPart);
        return fractionalPart;
    }

    static void main() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Введите вещественное число (можно использовать точку или запятую): ");
            if (!scanner.hasNext()) {
                return;
            }

            double number;
            try {
                number = Double.parseDouble(scanner.next().replace(',', '.'));
            } catch (NumberFormatException exception) {
                System.out.println("Некорректное вещественное число.");
                return;
            }

            if (!Double.isFinite(number)) {
                System.out.println("Число должно быть конечным.");
                return;
            }

            printParts(number);
        }
    }
}
