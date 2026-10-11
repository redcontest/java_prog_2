package org.example;

import java.util.Scanner;

public class task_1 {
    static void main() {
        try (Scanner scanner = new Scanner(System.in)) {
            if (!scanner.hasNextInt()) {
                return;
            }

            int n = scanner.nextInt();
            if (n <= 0) {
                return;
            }

            double sum = 0.0;
            for (long i = 1; i <= n; i++) {
                sum += 1.0 / i;
            }

            System.out.println(sum);
        }
    }
}
