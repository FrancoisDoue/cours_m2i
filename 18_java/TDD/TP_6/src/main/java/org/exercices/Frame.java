package org.exercices;

import java.util.ArrayList;
import java.util.List;

public class Frame {
    private int score;
    private boolean lastFrame;
    private IGenerator generator;
    private List<Roll> rolls;

    public Frame(int score, boolean lastFrame, IGenerator generator) {
        this.score = score;
        this.lastFrame = lastFrame;
        this.generator = generator;
        rolls = new ArrayList<>();
    }

    public boolean makeRoll() {
//        if (rolls.size() > 1) return false;
        int temp = generator.randomPin(10);
        rolls.add(new Roll(temp));
        score += temp;
        return true;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public boolean isLastFrame() {
        return lastFrame;
    }

    public void setLastFrame(boolean lastFrame) {
        this.lastFrame = lastFrame;
    }

    public IGenerator getGenerator() {
        return generator;
    }

    public void setGenerator(IGenerator generator) {
        this.generator = generator;
    }

    public List<Roll> getRolls() {
        return rolls;
    }

    public void setRolls(List<Roll> rolls) {
        this.rolls = rolls;
    }
}
