package ru.netology.domain;

public class Radio {
    private String name;
    private int currentStation;
    private int maxStation;
    private int minStation;
    private boolean prevButton;
    private boolean nextButton;
    private int currentVolume;
    private int maxVolume;
    private int minVolume;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCurrentStation(int currentStation) {
        this.currentStation = currentStation;
    }

    public int getCurrentStation() {
        return currentStation;
    }

    public int getMaxStation() {
        return maxStation;
    }

    public void setMaxStation(int maxStation) {
        this.maxStation = maxStation;
    }

    public int getMinStation() {
        return minStation;
    }

    public void setMinStation(int minStation) {
        this.minStation = minStation;
    }

    public void setPrevButton(boolean prevButton) {
        this.prevButton = prevButton;
        if (this.prevButton == false) {
            return;
        }
            if(currentStation == minStation) {
                currentStation = maxStation;
                return;
        }
        currentStation--;
    }


    public void setNextButton(boolean nextButton) {
        this.nextButton = nextButton;
        if (this.nextButton == false){
            return;
        }
        if (currentStation == maxStation) {
            currentStation = minStation;
            return;
        }
        currentStation++;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void setCurrentVolume(int currentVolume) {

        if (currentVolume < minVolume) {
            return;
        }
        if (currentVolume > maxVolume) {
            return;
        }
        this.currentVolume = currentVolume;
    }

    public int getMaxVolume() {
        return maxVolume;
    }

    public void setMaxVolume(int maxVolume) {
        this.maxVolume = maxVolume;
    }

    public int getMinVolume() {
        return minVolume;
    }

    public void setMinVolume(int minVolume) {
        this.minVolume = minVolume;
    }
}
