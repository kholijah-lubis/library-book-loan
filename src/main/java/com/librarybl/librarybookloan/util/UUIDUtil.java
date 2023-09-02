package com.librarybl.librarybookloan.util;

import java.util.UUID;

public class UUIDUtil {

    // Metode untuk menghasilkan UUID baru
    public static UUID generateUUID() {
        return UUID.randomUUID();
    }

    // Metode untuk mengkonversi UUID dari string
    public static UUID fromString(String uuidString) {
        return UUID.fromString(uuidString);
    }

    // Metode untuk mengkonversi UUID ke string
    public static String toString(UUID uuid) {
        return uuid.toString();
    }
}
