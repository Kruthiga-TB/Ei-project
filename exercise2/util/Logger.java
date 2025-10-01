package exercise2.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    private static final DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void info(String message) {
        String timestamp = LocalDateTime.now().format(formatter);
        System.out.println("[INFO][" + timestamp + "] " + message);
    }

    public static void error(String message) {
        String timestamp = LocalDateTime.now().format(formatter);
        System.out.println("[ERROR][" + timestamp + "] " + message);
    }

    public static void debug(String message) {
        String timestamp = LocalDateTime.now().format(formatter);
        System.out.println("[DEBUG][" + timestamp + "] " + message);
    }
}