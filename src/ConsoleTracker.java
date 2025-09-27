import java.util.Scanner;

public class ConsoleTracker {
    private final Scanner scanner = new Scanner(System.in);
    private final StepTracker stepTracker = new StepTracker();
    private boolean running = true;

    public void run(){
        while(running){
            printMenu();
            int command = readInt();
            switch (command){
                case 1 -> addNewNumberStepsPerDay();
                case 2 -> changeStepGoal();
                case 3 -> printStatistic();
                case 4 -> exit();
                default -> System.out.println("Такой команды не существует.");
            }
            System.out.println();
        }
    }

    private void printMenu(){
        System.out.println("1 - ввести количество шагов за определённый день");
        System.out.println("2 - изменить цель по количеству шагов в день");
        System.out.println("3 - напечатать статистику за определённый месяц");
        System.out.println("4 - выйти из приложения");
    }

    private void addNewNumberStepsPerDay(){
        int month = askInt("Введите номер месяца (1-12)", 1, 12);
        int day = askInt("Введите день месяца (1-30)", 1, 30);
        int steps = askInt("Введите количество шагов (больше 0)", 0, Integer.MAX_VALUE);
        stepTracker.addNewNumberStepsPerDay(month, day, steps);
    }

    private void changeStepGoal(){
        int newStepGoal = askInt("Введите новое целевое значение (больше 0)", 0, Integer.MAX_VALUE);
        stepTracker.changeStepGoal(newStepGoal);
    }

    private void printStatistic(){
        int month = askInt("Введите номер месяца (1-12)", 1, 12);
        stepTracker.printStatistic(month);
    }

    private int askInt(String message, int min, int max){
        System.out.println(message);
        int value;
        while (true){
            value = readInt();
            if(value >= min && value <= max){
                return value;
            }
            System.out.println("Ошибка ввода. Введите число из диапазона.");
        }
    }

    private void exit(){
        running = false;
        System.out.println("Завершение работы");
    }

    private int readInt(){
        while (!scanner.hasNextInt()){
            System.out.println("Ошибка ввода. Введите число.");
            scanner.next();
        }
        return scanner.nextInt();
    }
}
