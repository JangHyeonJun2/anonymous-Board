package com.sparta.basicassignment.utils;

import java.util.UUID;

public class CreateUUID {
    public String makeUUID() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString().substring(0,7);
    }


}
