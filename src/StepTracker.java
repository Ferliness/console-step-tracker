import java.util.Scanner;

public class StepTracker {
    Scanner scanner;
    MonthData[] monthToData = new MonthData[12];
    int goalByStepsPerDay = 10_000;
    Converter converter = new Converter();

    StepTracker(Scanner scan){
        scanner = scan;
        for (int i = 0; i < monthToData.length; i++) {
          monthToData[i] = new MonthData();
        }
    }

    void addNewNumberStepsPerDay(int monthNum, int dayNum, int stepNum) {
        monthToData[monthNum - 1].days[dayNum - 1] = stepNum;
    }

    void changeStepGoal(int newStepGoal){
        goalByStepsPerDay = newStepGoal;
    }

    void printStatistic(int monthNum){
        MonthData monthData = monthToData[monthNum - 1];

        System.out.println("Количество пройденных шагов по дням");
        monthData.printDaysAndStepsFromMonth();

        int sumSteps = monthData.sumStepsFromMonth();
        System.out.println("Общее количество шагов за месяц:");
        System.out.println(sumSteps);

        System.out.println("Максимальное пройденное количество шагов в месяце:");
        System.out.println(monthData.maxSteps());

        System.out.println("Среднее количество шагов:");
        System.out.println(sumSteps / monthData.days.length);

        System.out.println("Пройденная дистанция (в км):");
        System.out.println(converter.convertToKm(sumSteps));

        System.out.println("Количество сожжённых килокалорий:");
        System.out.println(converter.convertStepsToKilocalories(sumSteps));

        System.out.println(
                "Лучшая серия: максимальное количество подряд идущих дней, "
                + "в течение которых количество шагов за день было равно или выше целевого");
        System.out.println(monthData.bestSeries(goalByStepsPerDay));
    }
}
