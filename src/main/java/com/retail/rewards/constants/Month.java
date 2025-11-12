package com.retail.rewards.constants;

import lombok.Getter;

@Getter

public enum Month {

    JANUARY("01","January"),
    FEBRUARY("02","February"),
    MARCH("03", "March"),
    APRIL("04", "April"),
    MAY("05", "May"),
    JUNE("06", "June"),
    JULY("07", "July"),
    AUGUST("08", "August"),
    SEPTEMBER("09", "September"),
    OCTOBER("10", "October"),
    NOVEMBER("11", "Novembor"),
    DECEMBER("12", "December");

    private final String code;
    private final String name;

    Month(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public static String getMonth(int code){
        String formattedCode = String.format("%02d",code);
        for(Month month : Month.values()){
            if(month.getCode().equals(formattedCode)){
                return month.getName();
            }
        }
        throw new IllegalArgumentException("Invalid month number has been passed: "+code);
    }
}
