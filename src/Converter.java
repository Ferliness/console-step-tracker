public class Converter {
    private static final int STEP_LENGTH = 75;
    private static final int CAL_PER_STEP = 50;
    private static final int CAL_IN_KCAL = 1000;
    private static final int CM_IN_KILOMETER = 100_000;

    int convertToKm(int steps){
        return steps * STEP_LENGTH / CM_IN_KILOMETER;
    }

    int convertStepsToKilocalories(int steps){
        return steps * CAL_PER_STEP / CAL_IN_KCAL;
    }
}
