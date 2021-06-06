package ru.netology.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class RadioTest {

    @ParameterizedTest
    @CsvSource(
            value = {
                    "'(Start station 0)'   | 100 |  0  | 100 ",
                    "'(Start station 100)' | 100 | 100 | 99  ",
            },
            delimiter = '|'
    )
    void setPrevButtonTest(String test,
                           int maxStation,
                           int currentStation,
                           int expected) {

        Radio station = new Radio(currentStation, maxStation);
        station.setPrevButton();
        assertEquals(expected, station.getCurrentStation());
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "'(Start station 98)'  | 100 | 98  | 99 ",
                    "'(Start station 100)' | 100 | 100 | 0  ",
            },
            delimiter = '|'
    )
    void setNextButtonTest(String test,
                           int maxStation,
                           int currentStation,
                           int expected) {

        Radio station = new Radio(currentStation, maxStation);
        station.setNextButton();
        assertEquals(expected, station.getCurrentStation());
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "'(Start volume 99)' | 99  | 100 ",
                    "'(Start volume 100)'| 100 | 100 ",
            },
            delimiter = '|'
    )
    void setUpVolumeTest(String test,
                         int currentVolume,
                         int expected) {

        Radio station = new Radio();
        station.setCurrentVolume(currentVolume);
        station.setUpVolume();
        assertEquals(expected, station.getCurrentVolume());
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "'(Start volume 2 )' | 2 | 1 ",
                    "'(Start volume 0 )' | 0 | 0 ",
            },
            delimiter = '|'
    )
    void setDownVolumeTest(String test,
                           int currentVolume,
                           int expected) {

        Radio station = new Radio();
        station.setCurrentVolume(currentVolume);
        station.setDownVolume();
        assertEquals(expected, station.getCurrentVolume());
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "'(Start station 0)' | 100 | 10 | 101 | 10 ",
                    "'(Start station 9)' | 9   | 7  | 9   | 9  ",
            },
            delimiter = '|'
    )
    void setCurrentStationTest(String test,
                               int maxStation,
                               int currentStation,
                               int setStation,
                               int expected) {
        Radio station = new Radio(currentStation, maxStation);
        station.setMaxStation(maxStation);
        station.setCurrentStation(setStation);
        assertEquals(expected, station.getCurrentStation());
  }
}