import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Raffle {

    static ArrayList<String> contestants = new ArrayList<>(); // to store the names of the contestants

    public static void main(String[] args) {
        showMenu();
    }

    public static void showMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Enter contestants");
            System.out.println("2. Choose winner");
            System.out.println("3. Print contestants");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline character

            switch (choice) {
                case 1:
                    enterContestants();
                    break;
                case 2:
                    chooseWinner();
                    break;
                case 3:
                    printContestants();
                    break;
                case 4:
                    return;
            }
        }
    }

    public static void printContestants() {
        if (contestants.size() == 0) {
            System.out.println("No contestants entered!\n");
            return;
        }
        System.out.println("Contestants:");
        for (int i = 0; i < contestants.size(); i++) {
            System.out.println((i+1) + ". " + contestants.get(i));
        }
    }

    public static void enterContestants() {
        Scanner scanner = new Scanner(System.in);
        String firstName, lastName;

        System.out.println("Enter the contestants' names (first and last):");

        while (true) {
            System.out.print("First name: ");
            firstName = scanner.nextLine();
            if (firstName.equals("")) {
                return;
            }
            System.out.print("Last name: ");
            lastName = scanner.nextLine();
            String name = firstName + " " + lastName;
            if (contestants.contains(name)) {
                System.out.println("This name is already in the list of contestants, please enter a different name.");
            } else {
                contestants.add(name);
                System.out.println("");
                showMenu(); // call the showMenu method after the first and last names are accepted
                return;
            }
        }
    }

    public static void chooseWinner() {
        if (contestants.size() == 0) {
            System.out.println("No contestants entered!\n");
            return;
        }

        Random random = new Random();
        int winnerIndex = random.nextInt(contestants.size()); // choose a random index from the list of contestants
        String winner = contestants.get(winnerIndex);

        System.out.println("The winner is: " + winner);
        System.out.println("");
    }
}