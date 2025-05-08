import java.io.*;
import java.util.*;

// Tracker class to manage players and their performances
// Uses serialization to save and load player data
public class Tracker implements Serializable {
    private static final long serialVersionUID = 1L;
    private Map<String, Player> players = new HashMap<>();

    public void addPlayer(Player player) {
        players.put(player.getName().toLowerCase(), player);
    }

    public void deletePlayer(String name) {
        players.remove(name.toLowerCase());
    }

    public Player getPlayer(String name) {
        return players.get(name.toLowerCase());
    }

    public void logPerformance(String playerName, PlayerPerformance perf) {
        Player player = players.get(playerName.toLowerCase());
        if (player != null) {
            player.addPerformance(perf);
        } else {
            System.out.println("Player not found.");
        }
    }

    public Collection<Player> getAllPlayers() {
        return players.values();
    }

    public void generateRankingsByGoals() {
        players.values().stream()
            .sorted((p1, p2) -> Integer.compare(p2.getTotalGoals(), p1.getTotalGoals()))
            .forEach(p -> System.out.println(p.getName() + " - Goals: " + p.getTotalGoals()));
    }

    public void generateRankingsByAssists() {
        players.values().stream()
            .sorted((p1, p2) -> Integer.compare(p2.getTotalAssists(), p1.getTotalAssists()))
            .forEach(p -> System.out.println(p.getName() + " - Assists: " + p.getTotalAssists()));
    }
    public void generateRankingsByMatchesPlayed() {
        players.values().stream()
            .sorted((p1, p2) -> Integer.compare(p2.getMatchesPlayed(), p1.getMatchesPlayed()))
            .forEach(p -> System.out.println(p.getName() + " - Matches Played: " + p.getMatchesPlayed()));
    }
    public void generateRankingsByMinutesPlayed() {
        players.values().stream()
            .sorted((p1, p2) -> Integer.compare(p2.getTotalMinutesPlayed(), p1.getTotalMinutesPlayed()))
            .forEach(p -> System.out.println(p.getName() + " - Minutes Played: " + p.getTotalMinutesPlayed()));
    }
    public void generateRankingsByYellowCards() {
        players.values().stream()
            .sorted((p1, p2) -> Integer.compare(p2.getTotalYellowCards(), p1.getTotalYellowCards()))
            .forEach(p -> System.out.println(p.getName() + " - Yellow Cards: " + p.getTotalYellowCards()));
    }
    public void generateRankingsByRedCards() {
        players.values().stream()
            .sorted((p1, p2) -> Integer.compare(p2.getTotalRedCards(), p1.getTotalRedCards()))
            .forEach(p -> System.out.println(p.getName() + " - Red Cards: " + p.getTotalRedCards()));
    }

    public void saveToFile(String filename) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(this);
            System.out.println("Tracker saved to file: " + filename);
        } catch (IOException e) {
            System.out.println("Error saving tracker to file: " + e.getMessage());
        }
    }

    public static Tracker loadFromFile(String filename) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            return (Tracker) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No saved data found.");
            return new Tracker();
        }
    }
}
