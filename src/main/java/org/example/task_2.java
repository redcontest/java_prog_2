package org.example;

import java.util.Scanner;

public class task_2 {
    static void main() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Введите X (|X| < 1): ");
            if (!scanner.hasNext()) {
                return;
            }

            double x;
            try {
                x = Double.parseDouble(scanner.next().replace(',', '.'));
            } catch (NumberFormatException exception) {
                System.out.println("Некорректное значение X.");
                return;
            }

            if (!Double.isFinite(x) || Math.abs(x) >= 1.0) {
                System.out.println("X должно быть конечным числом, для которого |X| < 1.");
                return;
            }

            System.out.print("Введите N (N > 0): ");
            if (!scanner.hasNextInt()) {
                System.out.println("N должно быть целым числом.");
                return;
            }
            int n = scanner.nextInt();
            if (n <= 0) {
                System.out.println("N должно быть положительным.");
                return;
            }

            double sum = 0.0;
            double term = x;
            for (int k = 0; k <= n; k++) {
                sum += (k % 2 == 0 ? 1.0 : -1.0) * term;
                double numeratorFactor = x * x * (2.0 * k + 1.0);
                double denominatorFactor = 2.0 * k + 3.0;
                term *= numeratorFactor / denominatorFactor;
            }

            System.out.println(sum);
        }
    }
}
