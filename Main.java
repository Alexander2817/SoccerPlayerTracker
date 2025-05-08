import java.util.*;
import java.time.LocalDate;

// Main class
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = Tracker.loadFromFile("tracker.dat");

        System.out.println("--- Welcome to Soccer Player Tracker ---");
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();
        System.out.print("Enter role (coach / analyst / fan): ");
        String role = scanner.nextLine().toLowerCase();

        User user;
        switch (role) {
            case "coach" -> user = new Coach(name, email);
            case "analyst" -> user = new Analyst(name, email);
            case "fan" -> user = new Fan(name, email);
            default -> {
                System.out.println("Invalid role. Exiting.");
                return;
            }
        }

        user.showMenu(scanner, tracker);
    }
    // Method to add a player
    public static void addPlayer(Scanner scanner, Tracker tracker) {
        System.out.print("Name: "); String name = scanner.nextLine();
        System.out.print("Age: "); int age = scanner.nextInt(); scanner.nextLine();
        System.out.print("Position: "); String position = scanner.nextLine();
        System.out.print("Team: "); String team = scanner.nextLine();
        tracker.addPlayer(new Player(name, age, position, team));
        System.out.println("Player added.");
    }

    // Method to log a performance
    public static void logPerformance(Scanner Scanner, Tracker tracker) {
        System.out.print("Player name: "); String name = Scanner.nextLine();
        System.out.print("Opponent: "); String opponent = Scanner.nextLine();
        System.out.print("Match date (YYYY-MM-DD): ");
        LocalDate date = LocalDate.parse(Scanner.nextLine());

        System.out.print("Goals: "); int goals = Scanner.nextInt();
        System.out.print("Assists: "); int assists = Scanner.nextInt();
        System.out.print("xG: "); double xg = Scanner.nextDouble();
        System.out.print("xA: "); double xa = Scanner.nextDouble();
        System.out.print("Yellow Cards: "); int yc = Scanner.nextInt();
        System.out.print("Red Cards: "); int rc = Scanner.nextInt();
        System.out.print("Minutes Played: "); int mins = Scanner.nextInt();
        Scanner.nextLine();

        PlayerPerformance perf = new PlayerPerformance(date, opponent, goals, assists, xg, xa, yc, rc, mins);
        tracker.logPerformance(name, perf);
        System.out.println("Performance logged.");
    }

    // Method to view player stats
    public static void viewStats(Scanner scanner, Tracker tracker) {
        System.out.print("Enter player name: ");
        String name = scanner.nextLine();
        Player player = tracker.getPlayer(name);
        if (player == null) { // if player not found
            System.out.println("Player not found.");
            return;
        }

        System.out.println("Player: " + player.getName());
        System.out.println("Total Goals: " + player.getTotalGoals());
        System.out.println("Total Assists: " + player.getTotalAssists());
        System.out.println("Yellow Cards: " + player.getTotalYellowCards());
        System.out.println("Red Cards: " + player.getTotalRedCards());
        System.out.println("Matches Played: " + player.getMatchesPlayed());
        System.out.printf("xG per game: %.2f%n", player.getAverageExpectedGoals());
        System.out.printf("xA per game: %.2f%n", player.getAverageExpectedAssists());
    }

    // Method to delete a player
    public static void deletePlayer(Scanner scanner, Tracker tracker) {
        System.out.print("Enter player name to delete: ");
        String name = scanner.nextLine();
        tracker.deletePlayer(name);
        System.out.println("Player deleted.");
    }
}

