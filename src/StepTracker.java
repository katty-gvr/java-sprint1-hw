public class StepTracker {

    MonthData[] monthToData;
    int stepGoal = 10000;
    Converter converter = new Converter();
    public StepTracker() {
        monthToData = new MonthData[12];
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }
    public void changeStepGoal(int userStepGoal) { // изменение цели по шагам
        stepGoal = userStepGoal;
    }
    public void changeStepsPerDay(int userMonthNumber, int userDayNumber, int userStepsCount) { // запись шагов
        MonthData userMonth = monthToData[userMonthNumber];
        userMonth.stepsCountPerDay[userDayNumber] = userStepsCount;
    }
    public int[] getSteps(int userMonthNumber) {
        return monthToData[userMonthNumber].stepsCountPerDay;
    }
    public int getSumOfStepsOfMonth(int userMonthNumber) { // получить сумму шагов в месяц
        int sum = 0;
        int[] steps = getSteps(userMonthNumber);
        for(int i = 0; i < steps.length; i++) {
            sum = sum + steps[i];
        }
        return sum;
    }
    public int getMaxStepsOfMonth(int userMonthNumber) { // получить максимальное кол-во шагов
        int max = 0;
        int[] steps = getSteps(userMonthNumber);
        for (int i = 0; i < steps.length; i++) {
            if(steps[i] >= max) {
                max = steps[i];
            }
        }
        return max;
    }
    public double getAverageStepsOfMonth(int userMonthNumber) { // получить среднее кол-во шагов
        return getSumOfStepsOfMonth(userMonthNumber) / 30.0;
    }
    public double getDistanceInKmOfMonth(int userMonthNumber) { // получить дистанцию в км
        // 1. Посчитать сумму за месяц
        // 2. Перевести эту сумму в километры
        // 3. Вернуть её
        int sumOfMonth = getSumOfStepsOfMonth(userMonthNumber);
        return converter.getDistanceInKm(sumOfMonth);
    }
    public double getCalories(int userMonthNumber) { // получить количество сожженных килокалорий
        int sumOfMonth = getSumOfStepsOfMonth(userMonthNumber);
        return converter.getCalories(sumOfMonth);
    }
    public int theBestSeries(int userMonthNumber) { // поиск лучшей серии - сколько дней подряд была выполнена цель
        int max = 0;
        int k = 0;
        int[]steps = getSteps(userMonthNumber);
        for (int i = 0; i < steps.length; i ++) {
            if (steps[i] >= stepGoal) {
                k = k + 1;
                if (k > max) {
                    max = k;
                }
            } else {
                k = 0;
            }
        }
        return max;
    }
}