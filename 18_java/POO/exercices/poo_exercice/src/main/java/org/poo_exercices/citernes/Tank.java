package org.poo_exercices.citernes;

public class Tank {
    private int weight;
    private int volumeMax;
    private int currentVolume = 0;

    private static int totalCurrentVolume = 0;

    public Tank() {
        this(5, 20, 0);
    }
    public Tank(int mass, int capacity, int currentVolume) {
        this.weight = mass;
        this.volumeMax = capacity;
        this.currentVolume = currentVolume;
        totalCurrentVolume += currentVolume;
    }

    public int addWater(int amount) {
        int tempVolume = currentVolume + amount;
        if (tempVolume > volumeMax) {
            int leak = tempVolume - volumeMax;
            setCurrentVolume(volumeMax);
            return leak;
        }
        setCurrentVolume(tempVolume);
        return 0;
    }

    public int getWater(int amount) {
        int tempVolume = currentVolume - amount;
        if (tempVolume < 0) {
            currentVolume = 0;
            setTotalCurrentVolume(volumeMax);
            return amount + tempVolume;
        }
        currentVolume -= amount;
        setTotalCurrentVolume(volumeMax + currentVolume);
        return amount;
    }
    
    public static int getTotalCurrentVolume() {
        return totalCurrentVolume;
    }

    // n'est pas en static, sinon je suis obligé de passer une instance Tank en paramètre
    private void setTotalCurrentVolume(int value){
        totalCurrentVolume -= volumeMax;
        totalCurrentVolume += value;
    }


    public int getTotalMass(){
        return weight + currentVolume;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getVolumeMax() {
        return volumeMax;
    }

    public void setVolumeMax(int volumeMax) {
        this.volumeMax = volumeMax;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void setCurrentVolume(int currentVolume) {
        setTotalCurrentVolume(currentVolume);
        this.currentVolume = currentVolume;
    }
}
