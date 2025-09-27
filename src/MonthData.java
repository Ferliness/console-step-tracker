public class MonthData {
    private static final int DAYS_IN_MONTH = 30;
    private final int[] days = new int[DAYS_IN_MONTH];

    void printDaysAndStepsFromMonth(){
        for (int i = 0; i < days.length; i++) {
            System.out.println((i + 1) + " день: " + days[i]);
        }
        System.out.println();
    }

    void setSteps(int steps, int day){
        days[day-1] = steps;
    }

    int sumStepsFromMonth(){
        int sumSteps = 0;
        for (int day : days) {
            sumSteps += day;
        }
        return sumSteps;
    }

    int maxSteps(){
        int max = 0;
        for (int day : days) {
            if (max < day) {
                max = day;
            }
        }
        return max;
    }

    int bestSeries(int goalByStepsPerDay) {
        int currentSeries = 0;
        int finalSeries = 0;
        for (int day : days) {
            if (day >= goalByStepsPerDay) {
                currentSeries++;
                if (finalSeries < currentSeries) {
                    finalSeries = currentSeries;
                }
            } else {
                currentSeries = 0;
            }
        }
        return finalSeries;
    }

    int calcAverage(int sumSteps){
        return sumSteps / DAYS_IN_MONTH;
    }
}
