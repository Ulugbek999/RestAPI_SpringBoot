package com.restapi.rest.score;

public class Score {
    private int wins;
    private int ties;
    private int losses;


    public Score() {
    }

    
    public Score(int wins, int ties, int losses) {
        this.wins = wins;
        this.ties = ties;
        this.losses = losses;
    }


    public int getWins() {
        return wins;
    }
    public void setWins(int wins) {
        this.wins = wins;
    }
    public int getTies() {
        return ties;
    }
    public void setTies(int ties) {
        this.ties = ties;
    }
    public int getLosses() {
        return losses;
    }
    public void setLosses(int losses) {
        this.losses = losses;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Score{");
        sb.append("wins=").append(wins);
        sb.append(", ties=").append(ties);
        sb.append(", losses=").append(losses);
        sb.append('}');
        return sb.toString();
    }


}
