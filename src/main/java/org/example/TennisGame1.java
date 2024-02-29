package org.example;

public class TennisGame1 implements TennisGame {

    private int playerOneScore = 0;
    private int playerTwoScore = 0;
    private String playerOneName;
    private String playerTwoName;

    public TennisGame1(String playerOneName, String playerTwoName) {
        this.playerOneName = playerOneName;
        this.playerTwoName = playerTwoName;
    }

    public void wonPoint(String playerName) {
        if (playerName == playerOneName)
            playerOneScore += 1;
        else
            playerTwoScore += 1;
    }

    public String getScore() {
        if (playerOneScore == playerTwoScore) {
            return scoreWhenTie();
        } else if (playerOneScore >= 4 || playerTwoScore >= 4) {
            return scoreWhenAdvantage();
        } else {
            return scoreInGame();
        }
    }

    private String scoreInGame() {
        String score = scoreToString(playerOneScore);
        score += "-";

        return score + scoreToString(playerTwoScore);
    }

    private String scoreToString(int tempScore) {
        return switch (tempScore) {
            case 0 -> "Love";
            case 1 -> "Fifteen";
            case 2 -> "Thirty";
            case 3 -> "Forty";
            default -> "WHATEVER";
        };
    }

    private String scoreWhenAdvantage() {
        String score;
        int minusResult = playerOneScore - playerTwoScore;
        if (minusResult == 1) score = "Advantage " + playerOneName;
        else if (minusResult == -1) score = "Advantage " + playerTwoName;
        else if (minusResult >= 2) score = "Win for " + playerOneName;
        else score = "Win for " + playerTwoName;
        return score;
    }

    private String scoreWhenTie() {
        return switch (playerOneScore) {
            case 0 -> "Love-All";
            case 1 -> "Fifteen-All";
            case 2 -> "Thirty-All";
            default -> "Deuce";
        };
    }
}
