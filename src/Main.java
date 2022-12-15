/**
 * Финальный проект по первому спринту. В этом классе реализованно основной цикл консольного приложения.
 * Считывание команд и вызов методов из других классов таких как, StepTracker, где реализована основная логика данного приложения.
 * Converter класс служит для конвертации шагов в километры и калории.
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inputUser = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();
        Converter converter = new Converter();

        while (true) {
            printMenu();
            int command = inputUser.nextInt();
            if (command == 1) {
                printSelectMonth();
                int month = inputUser.nextInt();
                System.out.println("Выберите день от 1 до 30.");
                int day = inputUser.nextInt();
                System.out.println("Введите кол-во шагов.");
                int steeps = inputUser.nextInt();
                stepTracker.setStepsToData(month, day, steeps);
            } else if (command == 2) {
                printSelectMonth();
                int month = inputUser.nextInt();
                if (month < 1 || month > 12) {
                    System.out.println("Неверный ввод. Введите от 1 до 12.");
                } else {
                    stepTracker.totalNumberOfStepsPerMonth(month);
                    stepTracker.stepDay(month);
                    stepTracker.maximumNumberOfStepsPerMonth(month);
                    stepTracker.midNumberOfStepsPerMonth(month);
                    stepTracker.bestSeriesOfTheMonth(month);
                    converter.convert(month);
                }
            } else if (command == 3) {
                System.out.println("Введите новое количество шагов\n." +
                        "Для установки новой цели.");
                int goalforToday = inputUser.nextInt();
                stepTracker.setNewChange(goalforToday);
            } else if (command == 4) {
                System.out.println("Выход.");
                break;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Что вы хотите?");
        System.out.println("1. - Ввести количество шагов за определённый день.");
        System.out.println("2. - Показать статистику в определенном месяце.");
        System.out.println("3. - Изменить цель по кол-ву шагов в день.");
        System.out.println("0. - Выход.");
    }

    private static void printSelectMonth() {
        System.out.println("Выберите месяц:");
        System.out.print("1.Январь 2.Февраль 3.Март 4.Апрель 5.Май 6.Июнь" +
                "7.Июль 8.Август 9.Сентябрь 10.Октябрь 11.Ноябрь 12.Декабрь.\n");

    }
}

