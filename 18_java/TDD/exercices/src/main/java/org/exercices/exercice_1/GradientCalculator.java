package org.exercices.exercice_1;

public class GradientCalculator {
    public int score;
    public int attendancePercentage;

    public GradientCalculator(int score, int attendancePercentage) {
        this.score = score;
        this.attendancePercentage = attendancePercentage;
    }

    public char getGrade () {
        if (score > 90 && attendancePercentage > 70) return 'A';
        if (score > 80 && attendancePercentage > 60) return 'B';
        if (score > 60 && attendancePercentage > 60) return 'C';
        return 'F';
    }
}
