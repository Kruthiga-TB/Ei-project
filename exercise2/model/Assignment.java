package exercise2.model;

import java.util.HashMap;
import java.util.Map;

public class Assignment {
    private final String title;
    private final String description;
    private final Map<String, String> submissions; // studentId -> content

    public Assignment(String title, String description) {
        this.title = title;
        this.description = description;
        this.submissions = new HashMap<>();
    }

    public String getTitle() { return title; }
    public String getDescription() { return description; }

    public void submit(String studentId, String content) {
        submissions.put(studentId, content);
    }

    public boolean isSubmittedBy(String studentId) {
        return submissions.containsKey(studentId);
    }

    @Override
    public String toString() {
        return title + " - " + description;
    }
}