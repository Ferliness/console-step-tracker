public class StepTracker {
    private static final int MONTHS_IN_YEAR = 12;

    private final MonthData[] monthToData = new MonthData[MONTHS_IN_YEAR];
    private final Converter converter = new Converter();
    private int goalByStepsPerDay = 10_000;

    StepTracker(){
        for (int i = 0; i < MONTHS_IN_YEAR; i++) {
          monthToData[i] = new MonthData();
        }
    }

    void addNewNumberStepsPerDay(int month, int day, int steps) {
        monthToData[month - 1].setSteps(steps, day);
    }

    void changeStepGoal(int newStepGoal){
        goalByStepsPerDay = newStepGoal;
    }

    void printStatistic(int monthNum){
        MonthData monthData = monthToData[monthNum - 1];

        System.out.println("Количество пройденных шагов по дням");
        monthData.printDaysAndStepsFromMonth();

        int sumSteps = monthData.sumStepsFromMonth();
        System.out.println("Общее количество шагов за месяц: " + sumSteps);

        System.out.println("Максимальное пройденное количество шагов в месяце: " +
                            monthData.maxSteps());

        System.out.println("Среднее количество шагов: " +
                            monthData.calcAverage(sumSteps));

        System.out.println("Пройденная дистанция (в км): " +
                            converter.convertToKm(sumSteps));

        System.out.println("Количество сожжённых килокалорий: " +
                            converter.convertStepsToKilocalories(sumSteps));

        System.out.printf(
                "Лучшая серия, где несколько дней подряд шагов больше чем %d: %d%n",
                goalByStepsPerDay,
                monthData.bestSeries(goalByStepsPerDay)
        );
    }
}
