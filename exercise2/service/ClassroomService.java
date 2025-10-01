package exercise2.service;

import exercise2.model.Assignment;
import exercise2.model.Classroom;
import exercise2.model.Student;
import exercise2.util.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClassroomService {
    private final Map<String, Classroom> classrooms;

    // Singleton pattern
    private static ClassroomService instance;

    private ClassroomService() {
        this.classrooms = new HashMap<>();
    }

    public static ClassroomService getInstance() {
        if (instance == null) {
            instance = new ClassroomService();
        }
        return instance;
    }

    public void addClassroom(String name) {
        ValidationService.validateClassName(name);

        if (classrooms.containsKey(name)) {
            throw new IllegalArgumentException("Classroom '" + name + "' already exists");
        }

        Classroom classroom = new Classroom(name);
        classrooms.put(name, classroom);
        Logger.info("Classroom created: " + name);
    }

    public void addStudent(String studentId, String studentName, String className) {
        ValidationService.validateStudentId(studentId);
        ValidationService.validateStudentName(studentName);

        Classroom classroom = getClassroom(className);

        if (classroom.hasStudent(studentId)) {
            throw new IllegalArgumentException("Student " + studentId + " already enrolled");
        }

        Student student = new Student(studentId, studentName);
        classroom.addStudent(student);
        Logger.info("Student enrolled: " + studentId + " in " + className);
    }

    public void scheduleAssignment(String className, String title, String description) {
        ValidationService.validateAssignmentTitle(title);

        Classroom classroom = getClassroom(className);

        if (classroom.hasAssignment(title)) {
            throw new IllegalArgumentException("Assignment '" + title + "' already exists");
        }

        Assignment assignment = new Assignment(title, description);
        classroom.addAssignment(assignment);
        Logger.info("Assignment scheduled: '" + title + "' in " + className);
    }

    public void submitAssignment(String studentId, String className, String assignmentTitle, String content) {
        Classroom classroom = getClassroom(className);

        if (!classroom.hasStudent(studentId)) {
            throw new IllegalArgumentException("Student " + studentId + " not enrolled");
        }

        if (!classroom.hasAssignment(assignmentTitle)) {
            throw new IllegalArgumentException("Assignment '" + assignmentTitle + "' not found");
        }

        classroom.submitAssignment(studentId, assignmentTitle, content);
        Logger.info("Assignment submitted: " + studentId + " for '" + assignmentTitle + "'");
    }

    public List<Classroom> getAllClassrooms() {
        return new ArrayList<>(classrooms.values());
    }

    public Classroom getClassroom(String name) {
        Classroom classroom = classrooms.get(name);
        if (classroom == null) {
            throw new IllegalArgumentException("Classroom '" + name + "' not found");
        }
        return classroom;
    }

    public void removeClassroom(String name) {
        if (!classrooms.containsKey(name)) {
            throw new IllegalArgumentException("Classroom '" + name + "' not found");
        }
        classrooms.remove(name);
        Logger.info("Classroom removed: " + name);
    }
}