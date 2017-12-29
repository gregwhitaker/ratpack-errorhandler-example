package com.github.gregwhitaker.ratpackerrorhandler.example.core.error;

import java.util.HashMap;
import java.util.Map;

public class HttpStatusMessage {
    private static Map<Integer, String> MESSAGES = new HashMap<>(100);

    static {
        MESSAGES.put(400, "Bad Request");
        MESSAGES.put(401, "Unauthorized");
        MESSAGES.put(402, "Payment Required");
        MESSAGES.put(403, "Forbidden");
        MESSAGES.put(404, "Not Found");
        MESSAGES.put(405, "Method Not Allowed");
        MESSAGES.put(406, "Not Acceptable");
        MESSAGES.put(407, "Proxy Authentication Required");

        MESSAGES.put(500, "Internal Server Error");
    }

    public static String of(int status) {
        return MESSAGES.getOrDefault(status, null);
    }
}
