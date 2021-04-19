package ru.netology.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class RadioTest {

    @ParameterizedTest
    @CsvSource(
            value = {
                    "'(Start station 0)' | 0 | 9 | 0 | 9 ",
                    "'(Start station 9)' | 0 | 9 | 9 | 8 ",
            },
            delimiter = '|'
    )
    void setPrevButtonTest (String test, int minStation, int maxStation,  int currentStation, int expected) {
        Radio station = new Radio();

        station.setMinStation(minStation);
        station.setMaxStation(maxStation);
        station.setCurrentStation(currentStation);
        station.setPrevButton();
        assertEquals(expected,station.getCurrentStation());
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "'(Start station 7)' | 0 | 9 | 7 | 8 ",
                    "'(Start station 9)' | 0 | 9 | 9 | 0 ",
            },
            delimiter = '|'
    )
    void setNextButtonTest (String test, int minStation, int maxStation,  int currentStation, int expected) {
        Radio station = new Radio();

        station.setMinStation(minStation);
        station.setMaxStation(maxStation);
        station.setCurrentStation(currentStation);
        station.setNextButton();
        assertEquals(expected,station.getCurrentStation());
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "'(Start volume 9)' | 10 | 9  | 10 ",
                    "'(Start volume 10)'| 10 | 10 | 10 ",
            },
            delimiter = '|'
    )
    void setUpVolumeTest (String test,  int maxVolume,  int currentVolume, int expected) {
        Radio station = new Radio();

        station.setMaxVolume(maxVolume);
        station.setCurrentVolume(currentVolume);
        station.setUpVolume();
        assertEquals(expected,station.getCurrentVolume());
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "'(Start volume 1 )' | 0 | 1 | 0 ",
                    "'(Start volume 0 )' | 0 | 0 | 0 ",
            },
            delimiter = '|'
    )
    void setDownVolumeTest (String test, int minVolume,  int currentVolume, int expected) {
        Radio station = new Radio();

        station.setMinVolume(minVolume);
        station.setCurrentVolume(currentVolume);
        station.setDownVolume();
        assertEquals(expected,station.getCurrentVolume());
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "'(Start station 0)' | 0 | 9 | 10 | 0 ",
                    "'(Start station 9)' | 1 | 9 | 0  | 0 ",
                    "'(Start station 9)' | 0 | 9 | 7  | 7 ",
            },
            delimiter = '|'
    )
    void setCurrentStationTest (String test, int minStation, int maxStation,  int currentStation, int expected) {
        Radio station = new Radio();

        station.setMinStation(minStation);
        station.setMaxStation(maxStation);
        station.setCurrentStation(currentStation);
        assertEquals(expected,station.getCurrentStation());
    }
}