import java.util.Scanner;
public class Coach extends User {
    public Coach(String name, String email) {
        super(name, email);
    }

    // method that uses polymorphism to show coach menu
    @Override
    public void showMenu(Scanner scanner, Tracker tracker) {
        while (true) {
            System.out.println("\n--- Coach Menu ---");
            System.out.println("1. Add Player");
            System.out.println("2. Log Match Performance");
            System.out.println("3. View Player Statistics");
            System.out.println("4. Generate Rankings");
            System.out.println("5. Delete Player");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt(); scanner.nextLine();

            switch (choice) {
                case 1 -> Main.addPlayer(scanner, tracker);
                case 2 -> Main.logPerformance(scanner, tracker);
                case 3 -> Main.viewStats(scanner, tracker);
                case 4 -> rankingOptions(scanner, tracker);
                case 5 -> Main.deletePlayer(scanner, tracker);
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
