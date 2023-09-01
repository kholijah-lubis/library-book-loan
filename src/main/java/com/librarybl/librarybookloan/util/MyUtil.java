package com.librarybl.librarybookloan.util;

import java.util.UUID;

public class MyUtil {

    public static String generateUniqueKey() {
        return UUID.randomUUID().toString();
    }
}
