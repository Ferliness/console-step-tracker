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

    void addNewNumberStepsPerDay() {

        System.out.println("Введите номер месяца");
        int monthNum = scanner.nextInt();
        if (monthNum < 1 || monthNum > 12) {
            System.out.println("Ошибка ввода");
            return;
        }

        System.out.println("Введите день месяца");
        int dayNum = scanner.nextInt();
        if (dayNum < 1 || dayNum > 30) {
            System.out.println("Ошибка ввода");
            return;
        }

        System.out.println("Введите количество шагов");
        int stepNum = scanner.nextInt();
        if (stepNum < 0) {
            System.out.println("Ошибка ввода");
            return;
        }

        monthToData[monthNum - 1].days[dayNum - 1] = stepNum;
    }
    void changeStepGoal(){
        System.out.println("Введите новое целевое значение");
        int newStepGoal = scanner.nextInt();
        if (newStepGoal < 0){
            System.out.println("Ошибка ввода");
            return;
        }
        goalByStepsPerDay = newStepGoal;
    }

    void printStatistic(){
        System.out.println("Введите номер месяца");
        int monthNum = scanner.nextInt();
        if (monthNum < 1 || monthNum > 12) {
            System.out.println("Ошибка ввода");
            return;
        }
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
