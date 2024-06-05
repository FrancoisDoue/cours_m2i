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
        boolean isSpare = false;
        Roll strike = rolls.stream().filter(r -> r.getPins() == 10).findFirst().orElse(null);
        if (rolls.size() == 2) {
            isSpare = rolls.get(0).getPins() + rolls.get(1).getPins() == 10;
        }
        if (!lastFrame && (strike != null || rolls.size() >= 2)) return false;
        if (lastFrame && rolls.size() > 1 && strike == null) return false;
        rolls.add(new Roll(generator.randomPin(10)));
        score = rolls.stream().map(Roll::getPins).reduce(0, Integer::sum);
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
