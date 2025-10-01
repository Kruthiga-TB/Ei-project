package exercise1.creational.builder;

public class Report {
    private final String title;
    private final String author;
    private final String content;

    private Report(Builder builder) {
        this.title = builder.title;
        this.author = builder.author;
        this.content = builder.content;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getContent() { return content; }

    @Override
    public String toString() {
        return "Report: " + title + " by " + author +
                " - Content: " + (content.isEmpty() ? "None" : content);
    }

    public static class Builder {
        private String title;
        private String author;
        private String content = "";

        public Builder title(String title) {
            if (title == null || title.trim().isEmpty()) {
                throw new IllegalArgumentException("Title cannot be empty");
            }
            this.title = title.trim();
            return this;
        }

        public Builder author(String author) {
            if (author == null || author.trim().isEmpty()) {
                throw new IllegalArgumentException("Author cannot be empty");
            }
            this.author = author.trim();
            return this;
        }

        public Builder content(String content) {
            this.content = content != null ? content.trim() : "";
            return this;
        }

        public Report build() {
            if (title == null) {
                throw new IllegalStateException("Title is required");
            }
            if (author == null) {
                throw new IllegalStateException("Author is required");
            }
            return new Report(this);
        }
    }
}