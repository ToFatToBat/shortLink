package com.tofattobat.tinyurl;

import java.util.UUID;

public class UUIDRandomIdGenerator {
    private static final int ID_SIZE = 10;

    public static String genereteId() {
        UUID uuid = UUID.randomUUID();
        String uuidWithoutDash = uuid.toString().replace("-", "");
        return uuidWithoutDash.substring(0, ID_SIZE);
    }
}
