public class Converter {
    int stepLength = 75;
    int calPerStep = 50;
    int cCal = 1000;
    int smInKilometer = 100_000;

    int convertToKm(int steps){
        return stepLength * steps / smInKilometer;
    }

    int convertStepsToKilocalories(int steps){
        return steps * calPerStep / cCal;
    }
}
