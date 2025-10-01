package exercise2.service;

public class ValidationService {

    public static void validateClassName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Class name cannot be empty");
        }
        if (name.length() > 50) {
            throw new IllegalArgumentException("Class name cannot exceed 50 characters");
        }
    }

    public static void validateStudentId(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("Student ID cannot be empty");
        }
        if (!id.matches("^[A-Za-z0-9-_]+$")) {
            throw new IllegalArgumentException("Student ID contains invalid characters");
        }
    }

    public static void validateStudentName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Student name cannot be empty");
        }
    }

    public static void validateAssignmentTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Assignment title cannot be empty");
        }
    }

    public static void validateNotNull(Object obj, String fieldName) {
        if (obj == null) {
            throw new IllegalArgumentException(fieldName + " cannot be null");
        }
    }
}