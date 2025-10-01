package exercise2.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Classroom {
    private final String name;
    private final Map<String, Student> students;
    private final Map<String, Assignment> assignments;

    public Classroom(String name) {
        this.name = name;
        this.students = new HashMap<>();
        this.assignments = new HashMap<>();
    }

    public String getName() { return name; }

    public void addStudent(Student student) {
        students.put(student.getId(), student);
    }

    public void addAssignment(Assignment assignment) {
        assignments.put(assignment.getTitle(), assignment);
    }

    public void submitAssignment(String studentId, String assignmentTitle, String content) {
        Assignment assignment = assignments.get(assignmentTitle);
        if (assignment != null) {
            assignment.submit(studentId, content);
        }
    }

    public List<Student> getStudents() {
        return new ArrayList<>(students.values());
    }

    public List<Assignment> getAssignments() {
        return new ArrayList<>(assignments.values());
    }

    public boolean hasStudent(String studentId) {
        return students.containsKey(studentId);
    }

    public boolean hasAssignment(String assignmentTitle) {
        return assignments.containsKey(assignmentTitle);
    }
}