package com.example.shellenergy.HumanReadableTime;

import java.util.Collection;

public class HumanTime {
    public String getReadableTime(int seconds){
        if(!checkIfInputIsValid(seconds)) {
            throw new IllegalArgumentException("Input is invalid");
        }
        String hoursInStringForm = Integer.toString(seconds/3600);
        String minutesInStringForm = Integer.toString(seconds % 3600 / 60);
        String secondsInStringForm = Integer.toString(seconds % 60);

        return convertsToReadableForm(hoursInStringForm, minutesInStringForm, secondsInStringForm);
    }



    private boolean checkIfInputIsValid(double seconds) {
        if(seconds < 0 || seconds > 359999) {
            return false;
        }
        return true;
    }

    private String convertsToReadableForm(String hours, String minutes, String seconds){
        return addingZeroInFrontOfIntegerLessThanTen(hours) + ":" +
                addingZeroInFrontOfIntegerLessThanTen(minutes)+":" +
                addingZeroInFrontOfIntegerLessThanTen(seconds);
    }

    private String addingZeroInFrontOfIntegerLessThanTen(String number){
        if(number.length() < 2){
            number = "0" + number;
        }
        return number;
    }
}
