package org.example;

import java.util.OptionalDouble;
import java.util.Scanner;

public class task_5 {
    private static final String EXIT_COMMAND = "q";

    static void main() {
        try (Scanner scanner = new Scanner(System.in)) {
            runMainMenu(scanner);
        }
    }

    private static void runMainMenu(Scanner scanner) {
        System.out.println("Добро пожаловать в программу расчётов!");
        String command = "";
        while (!command.equals("0")) {
            System.out.println("\nГлавное меню");
            System.out.println("1. Выполнить расчёт");
            System.out.println("2. Информация о программе");
            System.out.println("3. Информация о разработчике");
            System.out.println("0. Выход");
            System.out.println("Выберите пункт:");

            if (!scanner.hasNext()) {
                return;
            }
            command = scanner.next();
            switch (command) {
                case "1" -> runCalculationMenu(scanner);
                case "2" -> printProgramInfo();
                case "3" -> printDeveloperInfo();
                case "0" -> System.out.println("Работа программы завершена.");
                default -> System.out.println("Неизвестная команда. Введите 0, 1, 2 или 3.");
            }
        }
    }

    private static void runCalculationMenu(Scanner scanner) {
        String command = "";
        while (!command.equals("0")) {
            System.out.println("\nРасчёты");
            System.out.println("1. Вычислить sin²(x) - cos(x) + tan(x)");
            System.out.println("2. Найти большее и меньшее из двух чисел");
            System.out.println("3. Найти площадь прямоугольного треугольника");
            System.out.println("0. Вернуться в главное меню");
            System.out.println("Выберите расчёт:");

            if (!scanner.hasNext()) {
                return;
            }
            command = scanner.next();
            switch (command) {
                case "1" -> calculateExpression(scanner);
                case "2" -> compareNumbers(scanner);
                case "3" -> calculateTriangleArea(scanner);
                case "0" -> { }
                default -> System.out.println("Неизвестная команда. Введите 0, 1, 2 или 3.");
            }
        }
    }

    private static void calculateExpression(Scanner scanner) {
        OptionalDouble input = readFiniteDouble(scanner, "Введите x (или q для возврата в меню): ");
        if (input.isEmpty()) {
            return;
        }

        double x = input.getAsDouble();
        double result = Math.pow(Math.sin(x), 2) - Math.cos(x) + Math.tan(x);
        System.out.println("Результат: " + result);
    }

    private static void compareNumbers(Scanner scanner) {
        OptionalDouble firstInput = readFiniteDouble(scanner, "Введите первое число (или q для возврата в меню): ");
        if (firstInput.isEmpty()) {
            return;
        }

        OptionalDouble secondInput = readFiniteDouble(scanner, "Введите второе число (или q для возврата в меню): ");
        if (secondInput.isEmpty()) {
            return;
        }

        double firstNumber = firstInput.getAsDouble();
        double secondNumber = secondInput.getAsDouble();
        System.out.println("Большее число: " + Math.max(firstNumber, secondNumber));
        System.out.println("Меньшее число: " + Math.min(firstNumber, secondNumber));
    }

    private static void calculateTriangleArea(Scanner scanner) {
        OptionalDouble firstInput = readFiniteDouble(scanner, "Введите длину первого катета (или q для возврата в меню): ");
        if (firstInput.isEmpty()) {
            return;
        }

        OptionalDouble secondInput = readFiniteDouble(scanner, "Введите длину второго катета (или q для возврата в меню): ");
        if (secondInput.isEmpty()) {
            return;
        }

        double firstCathetus = firstInput.getAsDouble();
        double secondCathetus = secondInput.getAsDouble();
        if (firstCathetus <= 0 || secondCathetus <= 0) {
            System.out.println("Длины катетов должны быть положительными. Запустите расчёт ещё раз.");
            return;
        }

        System.out.println("Площадь треугольника: " + firstCathetus * secondCathetus / 2);
    }

    private static OptionalDouble readFiniteDouble(Scanner scanner, String prompt) {
        String token = "";
        while (!EXIT_COMMAND.equalsIgnoreCase(token)) {
            System.out.println(prompt);
            if (!scanner.hasNext()) {
                return OptionalDouble.empty();
            }
            token = scanner.next();
            if (EXIT_COMMAND.equalsIgnoreCase(token)) {
                return OptionalDouble.empty();
            }

            try {
                double value = Double.parseDouble(token);
                if (Double.isFinite(value)) {
                    return OptionalDouble.of(value);
                }
            } catch (NumberFormatException ignored) {
            }

            System.out.println("Некорректное число. Повторите ввод или введите q для возврата в меню.");
        }
        return OptionalDouble.empty();
    }

    private static void printProgramInfo() {
        System.out.println("Программа содержит вычисление выражения, сравнение двух чисел и расчёт площади прямоугольного треугольника.");
    }

    private static void printDeveloperInfo() {
        System.out.println("Разработчик: Соколов РИ-250911.");
    }
}
