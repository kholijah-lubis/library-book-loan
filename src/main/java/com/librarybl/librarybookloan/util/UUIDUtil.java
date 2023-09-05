package com.librarybl.librarybookloan.util;

import java.util.UUID;

public class UUIDUtil {

    public static UUID generateUUID() {
        return UUID.randomUUID();
    }

    public static UUID fromString(String uuidString) {
        return UUID.fromString(uuidString);
    }

    public static String toString(UUID uuid) {
        return uuid.toString();
    }
}
