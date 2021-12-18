package com.amaris.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Convert {

    public static LocalDateTime toLocalDateTime(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return LocalDateTime.parse(date, formatter);
    }
}