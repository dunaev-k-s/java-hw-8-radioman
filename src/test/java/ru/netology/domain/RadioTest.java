package ru.netology.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class RadioTest {

    @ParameterizedTest
    @CsvSource(
            value = {
                    "'(Start station 0, true button)' | true  | 0 | 9 | 0 | 9 ",
                    "'(Start station 9, true button)' | true  | 0 | 9 | 9 | 8 ",
                    "'(Start station 9, false button)'| false | 0 | 9 | 9 | 9 "
            },
            delimiter = '|'
    )
    void setPrevButton (String test, boolean prevButton, int minStation, int maxStation,  int currentStation, int expected) {
        Radio station = new Radio();

        station.setMinStation(minStation);
        station.setMaxStation(maxStation);
        station.setCurrentStation(currentStation);
        station.setPrevButton(prevButton);
        assertEquals(expected,station.getCurrentStation());
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "'(Start station 9, true button)' | true  | 0 | 9 | 7 | 8 ",
                    "'(Start station 9, true button)' | true  | 0 | 9 | 9 | 0 ",
                    "'(Start station 5, false button)'| false | 0 | 9 | 5 | 5 "
            },
            delimiter = '|'
    )
    void setNextButton (String test, boolean nextButton, int minStation, int maxStation,  int currentStation, int expected) {
        Radio station = new Radio();

        station.setMinStation(minStation);
        station.setMaxStation(maxStation);
        station.setCurrentStation(currentStation);
        station.setNextButton(nextButton);
        assertEquals(expected,station.getCurrentStation());
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "'(Start volume 9, true button)' | true  | 10 | 9  | 10 ",
                    "'(Start volume 10, true button)'| true  | 10 | 10 | 10 ",
                    "'(Start volume 5, false button)'| false | 10 | 5  | 5 "
            },
            delimiter = '|'
    )
    void setUpVolume (String test, boolean upVolume, int maxVolume,  int currentVolume, int expected) {
        Radio station = new Radio();

        station.setMaxVolume(maxVolume);
        station.setCurrentVolume(currentVolume);
        station.setUpVolume(upVolume);
        assertEquals(expected,station.getCurrentVolume());
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "'(Start volume 1, true button)' | true  | 0 | 1  | 0 ",
                    "'(Start volume 0, true button)' | true  | 0 | 0  | 0 ",
                    "'(Start volume 5, false button)'| false | 0 | 5  | 5 "
            },
            delimiter = '|'
    )
    void setDownVolume (String test, boolean downVolume, int minVolume,  int currentVolume, int expected) {
        Radio station = new Radio();

        station.setMinVolume(minVolume);
        station.setCurrentVolume(currentVolume);
        station.setDownVolume(downVolume);
        assertEquals(expected,station.getCurrentVolume());
    }
}