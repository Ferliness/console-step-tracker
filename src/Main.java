import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        StepTracker stepTracker = new StepTracker(scanner);

        while(running){
            printMenu();
            int command = readInt(scanner);
            switch (command){
                case 1 -> {
                    stepTracker.addNewNumberStepsPerDay();
                }
                case 2 -> {
                    stepTracker.changeStepGoal();
                }
                case 3 -> {
                    stepTracker.printStatistic();
                }
                case 4 -> {
                    running = false;
                }
                default -> System.out.println("Такой команды не существует.");
            }
        }
    }

    static void printMenu(){
        System.out.println("1 - ввести количество шагов за определённый день");
        System.out.println("2 - изменить цель по количеству шагов в день");
        System.out.println("3 - напечатать статистику за определённый месяц");
        System.out.println("4 - выйти из приложения");
    }

    static int readInt(Scanner scan){
        while (!scan.hasNextInt()){
            System.out.println("Ошибка ввода. Введите число.");
            scan.next();
        }
        return scan.nextInt();
    }
}
