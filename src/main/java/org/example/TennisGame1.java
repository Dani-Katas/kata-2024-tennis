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
        String score = "";
        if (playerOneScore == playerTwoScore) {
            score = scoreWhenTie();
        } else if (playerOneScore >= 4 || playerTwoScore >= 4) {
            score = scoreWhenAdvantage();
        } else {
            score = scoreInGame();
        }
        return score;
    }

    private String scoreInGame() {
        String score = scoreToString(playerOneScore);
        score += "-";

        return score + scoreToString(playerTwoScore);
    }

    private String scoreToString(int tempScore) {
        String score = "";
        switch (tempScore) {
            case 0:
                score += "Love";
                break;
            case 1:
                score += "Fifteen";
                break;
            case 2:
                score += "Thirty";
                break;
            case 3:
                score += "Forty";
                break;
        }
        return score;
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
