package com.upgrad.ublog.utils;

import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
/**
 * TODO: 4.13. Implement a method with the following signature.
 *  public static String format(LocalDateTime localDateTime)
 *  This method should convert the default date time to the human readable format[dd-MM-yyyy HH:mm:ss].
 */

public class DateTimeFormatter {


    public static String format(LocalDateTime localDateTime){
       // String date = localDateTime.format(java.time.format.DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        String timeStamp = localDateTime.format(java.time.format.DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));

        return timeStamp;

    }

}
