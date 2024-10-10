package com.caloteiros.spring.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtils {

    public static String formatDate(LocalDate date, String pattern) {
        if (date != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
            return date.format(formatter);
        } else {
            return "";
        }
    }
}
