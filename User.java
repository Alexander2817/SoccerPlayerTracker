import java.util.*;
public abstract class User {
    protected String name;
    protected String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // Getters
    public String getName() {
        return name;
    }

    // Abstract method for showing menu
    public abstract void showMenu(Scanner scanner, Tracker tracker);

    // Method to show ranking options
    public void rankingOptions(Scanner scanner, Tracker tracker) {
        System.out.println("Choose a ranking type:");
        System.out.println("1. Goals");
        System.out.println("2. Assists");
        System.out.println("3. Minutes Played");
        System.out.println("4. Matches Played");
        System.out.println("5. Yellow Cards");
        System.out.println("6. Red Cards");
        System.out.print("Enter choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
    
        switch (choice) { // Switch case to generate rankings based on user choice
            case 1 -> tracker.generateRankingsByGoals();
            case 2 -> tracker.generateRankingsByAssists();
            case 3 -> tracker.generateRankingsByMinutesPlayed();
            case 4 -> tracker.generateRankingsByMatchesPlayed();
            case 5 -> tracker.generateRankingsByYellowCards();
            case 6 -> tracker.generateRankingsByRedCards();
            default -> System.out.println("Invalid choice.");
        }
    }
}