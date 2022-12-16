/* Класс конвертации шагов в километры и калории */
public class Converter {
    private final static double lengthSteps = 75d;
    private final static double caloriesSteps = 50d;

    static void convert(int steps) {
        /* конвертации шагов в километры и калории */
        System.out.println("Пройденная дистанция в км: " + steps * (lengthSteps / 1000) + ".");
        System.out.println("Соженно килокалорий: " + steps * (caloriesSteps / 1000) + ".");
    }
}
