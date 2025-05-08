import java.util.Scanner;
public class Fan extends User { // Fan class that extends User
    public Fan(String name, String email) {
        super(name, email);
    }

    // Method that uses polymorphism to show fan menu
    @Override
    public void showMenu(Scanner scanner, Tracker tracker) {
        while (true) {
            System.out.println("\n--- Fan Menu ---");
            System.out.println("1. View Player Statistics");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt(); scanner.nextLine();

            switch (choice) {
                case 1 -> Main.viewStats(scanner, tracker);
                case 0 -> {
                    tracker.saveToFile("tracker.dat");
                    System.out.println("Session ended. Logging off.");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }
}
