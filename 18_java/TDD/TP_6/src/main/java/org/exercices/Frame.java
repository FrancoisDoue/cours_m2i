package org.exercices;

import java.util.ArrayList;
import java.util.List;

public class Frame {
    private int score;
    private boolean lastFrame;
    private IGenerator generator;
    private List<Roll> rolls;

    public Frame(boolean lastFrame, IGenerator generator) {
        this.lastFrame = lastFrame;
        this.generator = generator;
        rolls = new ArrayList<>();
    }

    public boolean makeRoll() {
        score = 0;
        List<Roll> strikes = rolls.stream().filter(r -> r.getPins() == 10).toList();
        if (!lastFrame) {
            if (rolls.size() > 1 || !strikes.isEmpty())
                return false;
        } else {
            boolean haveSpare = false;
            int last = 0;
            for (Roll roll : rolls) {
                last += roll.getPins();
                haveSpare = last == 10;
                if (haveSpare) last = 0;
            }
            if (rolls.size() > 3) {
                if (!haveSpare && strikes.isEmpty())
                    return false;
            }
        }
        Roll roll = new Roll(generator.randomPin(10));
        rolls.add(roll);
        rolls.forEach(r -> score += r.getPins());
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
