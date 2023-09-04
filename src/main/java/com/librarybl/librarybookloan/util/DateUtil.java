package com.librarybl.librarybookloan.util;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DateUtil {

    // Metode untuk menghitung selisih hari antara dua tanggal
    public static long calculateDaysBetween(LocalDate startDate, LocalDate endDate) {
        return ChronoUnit.DAYS.between(startDate, endDate);
    }
}
