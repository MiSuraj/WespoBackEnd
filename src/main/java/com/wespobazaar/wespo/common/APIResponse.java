package com.wespobazaar.wespo.common;

import java.time.LocalDateTime;

public class APIResponse {

    private final boolean success;
    private final String message;
    // try again

    public APIResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public String getTimestamp() {
        return LocalDateTime.now().toString();
    }
}
