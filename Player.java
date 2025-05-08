import java.util.*;
import java.io.Serializable;
// Player class to represent a player
// Uses serialization to save and load player data
public class Player implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private int age;
    private String position;
    private String team;
    private List<PlayerPerformance> performances = new ArrayList<>();

    public Player(String name, int age, String position, String team) {
        this.name = name;
        this.age = age;
        this.position = position;
        this.team = team;
    }

    public void addPerformance(PlayerPerformance perf) {
        performances.add(perf);
    }

    public List<PlayerPerformance> getPerformances() {
        return performances;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPosition() {
        return position;
    }

    public String getTeam() {
        return team;
    }

    public double getAverageExpectedGoals() {
        if (performances.isEmpty()) return 0.0;
        return performances.stream()
            .mapToDouble(PlayerPerformance::getExpectedGoals)
            .sum() / performances.size();
    }
    
    public double getAverageExpectedAssists() {
        if (performances.isEmpty()) return 0.0;
        return performances.stream()
            .mapToDouble(PlayerPerformance::getExpectedAssists)
            .sum() / performances.size();
    }
    

    // Methods to calculate player statistics based on their performances
    // Does not include expected goals and assists
    // As they are not used in ranking
    public int getTotalGoals() {
        return performances.stream().mapToInt(PlayerPerformance::getGoals).sum();
    }

    public int getTotalAssists() {
        return performances.stream().mapToInt(PlayerPerformance::getAssists).sum();
    }

    public int getTotalYellowCards() {
        return performances.stream().mapToInt(PlayerPerformance::getYellowCards).sum();
    }

    public int getTotalRedCards() {
        return performances.stream().mapToInt(PlayerPerformance::getRedCards).sum();
    }

    public int getMatchesPlayed() {
        return performances.size();
    }
    public int getTotalMinutesPlayed() {
        return performances.stream().mapToInt(PlayerPerformance::getMinutesPlayed).sum();
    }
}
