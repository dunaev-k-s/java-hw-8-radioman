package ru.netology.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Radio {
    private String name;
    private int currentStation;
    private int maxStation = 10;
    private int currentVolume;
    private int maxVolume = 100;
    private int minVolume;


    public Radio(int maxStation) {
        this.maxStation = maxStation;
    }

    public Radio(int currentStation, int maxStation) {
        this.maxStation = maxStation;
        this.currentStation = currentStation;
    }

    public void setCurrentStation(int currentStation) {
        if(currentStation > maxStation){
            return;
        }
        this.currentStation = currentStation;
    }

    public void setPrevButton() {
        if (currentStation == 0) {
            currentStation = maxStation;
            return;
        }
        currentStation--;
    }


    public void setNextButton() {
        if (currentStation == maxStation) {
            currentStation = 0;
            return;
        }
        currentStation++;
    }

    public void setUpVolume() {
        if (currentVolume == maxVolume) {
            return;
        }
        currentVolume++;
    }

    public void setDownVolume() {
        if (currentVolume == minVolume) {
            return;
        }
        currentVolume--;
    }
}