import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StepTracker stepTracker = new StepTracker();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            int userInput = scanner.nextInt();
            if (userInput == 1) {
                askMonth();
                int userMonthNumber = scanner.nextInt();

                while (userMonthNumber < 0 || userMonthNumber > 11  ) {
                    System.out.println("Неправильный ввод месяца. Повторите ввод еще раз.");
                    userMonthNumber = scanner.nextInt();
                }

                System.out.println("Введите номер дня, начиная с нуля");
                int userDayNumber = scanner.nextInt();
                while (userDayNumber < 0 || userDayNumber > 29  ) {
                    System.out.println("Неправильный ввод дня. Повторите ввод еще раз.");
                    userDayNumber = scanner.nextInt();
                }

                System.out.println("Введите количество пройденных шагов");
                int userStepsCount = scanner.nextInt();
                if (userStepsCount < 0) {
                    System.out.println("Неверное значение!");
                }
                stepTracker.changeStepsPerDay(userMonthNumber, userDayNumber, userStepsCount);
                System.out.println("Значение сохранено");

            } else if (userInput == 2) {
                askMonth();
                int userMonthNumber = scanner.nextInt();
                while (userMonthNumber < 0 || userMonthNumber > 11  ) {
                    System.out.println("Неправильный ввод месяца. Повторите ввод еще раз.");
                    userMonthNumber = scanner.nextInt();
                }
                    int[] userStepsCountOfMonth = stepTracker.getSteps(userMonthNumber);
                    for (int i = 0; i < 30; i++) {
                        System.out.println(i + " день: " + userStepsCountOfMonth[i]);
                    }
                    System.out.println("Общее количество шагов " +
                            stepTracker.getSumOfStepsOfMonth(userMonthNumber));
                    System.out.println("Максимальное количество пройденных шагов " +
                            stepTracker.getMaxStepsOfMonth(userMonthNumber));
                    System.out.println("Среднее количество шагов в месяц " +
                            stepTracker.getAverageStepsOfMonth(userMonthNumber));
                    System.out.println("Общая дистанция - " +
                            stepTracker.getDistanceInKmOfMonth(userMonthNumber)
                            + " км ");
                    System.out.println("Количество сожженных килокалорий - " +
                            stepTracker.getCalories(userMonthNumber));
                    System.out.println("Ваша лучшая серия - выполнить цель по шагам удалось " +
                            stepTracker.theBestSeries(userMonthNumber) + " дней подряд.");

            } else if (userInput == 3) {
                System.out.println("Сейчас Ваша цель - " + stepTracker.stepGoal +
                        ". Введите новую цель ");
                int userStepGoal = scanner.nextInt();
                stepTracker.changeStepGoal(userStepGoal);
                System.out.println("Вы изменили цель! Ваша новая цель - " + userStepGoal + " шагов в месяц.");
            } else if (userInput == 0) {
                System.out.println("Программа завершена");
                break;
            } else {
                System.out.println("Извините, такой команды пока нет.");
            }
        }
    }
    public static void printMenu() {
        System.out.println("Что Вы хотите сделать?");
        System.out.println("1 - Ввести количество шагов за определенный день");
        System.out.println("2 - Показать ститистику за определенный месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("0 - Выйти из приложения");
    }
    public static void askMonth() {
        System.out.println("Введите номер месяца, начиная с нуля: 0-январь, 1-февраль, 2-март и тд.");
    }
}