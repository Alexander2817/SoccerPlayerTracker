import java.time.LocalDate;
import java.io.Serializable;

// PlayerPerformance class to represent a player performance for a match
// Uses serialization to save and load player performance data
public class PlayerPerformance implements Serializable {
    private static final long serialVersionUID = 1L;

    private LocalDate matchDate;
    private String opponent;
    private int goals;
    private int assists;
    private double expectedGoals;
    private double expectedAssists;
    private int yellowCards;
    private int redCards;
    private int minutesPlayed;

    public PlayerPerformance(LocalDate matchDate, String opponent, int goals, int assists,
                             double expectedGoals, double expectedAssists, int yellowCards,
                             int redCards, int minutesPlayed) {
        this.matchDate = matchDate;
        this.opponent = opponent;
        this.goals = goals;
        this.assists = assists;
        this.expectedGoals = expectedGoals;
        this.expectedAssists = expectedAssists;
        this.yellowCards = yellowCards;
        this.redCards = redCards;
        this.minutesPlayed = minutesPlayed;
    }

    public LocalDate getMatchDate() {
        return matchDate;
    }
    public String getOpponent() {
        return opponent;
    }
    public int getGoals() { 
        return goals;
    }
    public int getAssists() { 
        return assists;
    }
    public double getExpectedGoals() { 
        return expectedGoals; 
    }
    public double getExpectedAssists() {
        return expectedAssists; 
    }
    public int getYellowCards() { 
        return yellowCards;
    }
    public int getRedCards() {
        return redCards;
    }
    public int getMinutesPlayed() {
        return minutesPlayed;
    }
}
