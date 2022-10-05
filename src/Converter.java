public class Converter {
    int stepInSm = 75;
    int stepInCal = 50;

    public double getDistanceInKm(int userSteps) {
        return userSteps * stepInSm * 0.00001;
    }
    public double getCalories(int userSteps) {
        return userSteps * stepInCal / 1000.0;
    }
}
