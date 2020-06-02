package edu.udel.mattsch.BasketCase;

import android.annotation.SuppressLint;

@SuppressLint("DefaultLocale")
public class BasketCaseGameRecord {
	private String player;
    private Integer score;
    private Long date;
    public BasketCaseGameRecord(String player, Integer score, Long date) {
        this.player = player;
        this.score = score;
        this.date = date;
    }
    public String getPlayer() {
        return player;
    }
    public void setPlayer(String player) {
        this.player = player;
    }
    public Integer getScore() {
        return score;
    }
    public void setScore(Integer score) {
        this.score = score;
    }
    public Long getDate() {
        return date;
    }
    public void setDate(Long date) {
        this.date = date;
    }
    public String toString() {
        return String.format("%6s %6d %3$tm/%3$td/%3$ty", player, score, date);
    }
}
