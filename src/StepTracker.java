/*
 * Класс по хранению информации о пройденных шагах.
 * Реализована логика по сохранению и изменения кол-во шагов.
 * Расчет статистики.
 */

import java.util.Scanner;

public class StepTracker {
    int goalforToday;
    int[][] monthToData;

    StepTracker() {
        goalforToday = 10000;
        monthToData = new int[12][30];
    }


    public void setStepsToData(int month, int day, int steps) {
        /* установить количество шагов за определенный день. */

        if (steps >= 0) {
            monthToData[month - 1][day - 1] = steps;
            System.out.println(steps + " шагов сохранено в " + day + "-й день в " + month + "-й месяца.");
        } else {
            System.out.println("Введено неверное значение.");
        }
    }

    public int totalNumberOfStepsPerMonth(int month) {
        /* общее количество шагов. */
        int numberOfsteps = 0;
        for (int i = 0; i < monthToData[month - 1].length; i++) {
            numberOfsteps = numberOfsteps + monthToData[month - 1][i];
        }
        System.out.println("Количество пройденных шагов за " + month + "-й месяц.");
        return numberOfsteps;
    }

    public int maximumNumberOfStepsPerMonth(int month) {
        /* максимальное количество шагов */

        int maxOfStepsMonth = 0;
        for (int i = 0; i < monthToData[month - 1].length; i++) {
            if (monthToData[month - 1][i] > maxOfStepsMonth) {
                maxOfStepsMonth = maxOfStepsMonth + monthToData[month - 1][i];
            }
        }
        System.out.println("Максимальное количество: " + maxOfStepsMonth + ".");
        return maxOfStepsMonth;
    }

    public int midNumberOfStepsPerMonth(int month) {
        /* среднее количество шагов */
        int tempAvg = totalNumberOfStepsPerMonth(month);
        int temp = monthToData[month - 1].length;
        int avgSteps = tempAvg / temp;
        System.out.println("Среднее количество шагов в этом месяце: " + avgSteps + ".");
        return avgSteps;
    }

    public int bestSeriesOfTheMonth(int month) {
        /* лучшая серия: максимальное кол-во идущих дней,
        в течение которых количество шагов за день было равно или выше целевого.
        */
        int currentSeries = 0;
        int bestSeries = 0;
        for (int i = 0; i < monthToData[month - 1].length; i++) {
            if (monthToData[month - 1][i] >= goalforToday) {
                currentSeries++;
            } else {
                bestSeries = Math.max(bestSeries, currentSeries);
                currentSeries = 0;
            }
        }
        System.out.println("Лучшая серия: " + bestSeries + ".");
        return bestSeries;
    }

    public void stepDay(int month) {
        /* шаги по дням */
        String output = ""; // создал пустую строку
        for (int i = 0; i < monthToData[month - 1].length; i++) {
            output = output + monthToData[month - 1][i]; // вроде бы конкатенировал, но получилась каша. Можно подсказку плиз).
            System.out.print((i + 1) + " день: " + monthToData[month - 1][i] + ", ");
        }
        System.out.println(monthToData[month - 1].length + " день: " + monthToData[month - 1][monthToData[month - 1].length - 1]);
    }


    public void setNewChange(int goalforToday) {
        /* изменение текущей цели на новую */
        if (goalforToday <= 0) {
            System.out.println("Цель не может быть установленна на данное" +
                    "количество шагов, попробуйте другое значение");
        } else {
            this.goalforToday = goalforToday;
            System.out.println("Ваша новая цель: " + goalforToday + " шагов.");
        }
    }
}
