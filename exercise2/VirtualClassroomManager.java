package exercise2;

import exercise2.model.Assignment;
import exercise2.model.Classroom;
import exercise2.model.Student;
import exercise2.service.ClassroomService;
import exercise2.util.Logger;

import java.util.List;
import java.util.Scanner;

public class VirtualClassroomManager {
    private final ClassroomService classroomService;
    private final Scanner scanner;
    private boolean running;

    public VirtualClassroomManager() {
        this.classroomService = ClassroomService.getInstance();
        this.scanner = new Scanner(System.in);
        this.running = true;
    }

    public void start() {
        Logger.info("Virtual Classroom Manager started");
        displayWelcome();

        while (running) {
            try {
                displayMenu();
                String input = scanner.nextLine().trim();
                processCommand(input);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                Logger.error("Unexpected error: " + e.getMessage());
            }
        }
    }

    private void displayWelcome() {
        System.out.println("\n🎓 Virtual Classroom Manager");
        System.out.println("=============================");
    }

    private void displayMenu() {
        System.out.println("\nCommands:");
        System.out.println("1. add_classroom <name>");
        System.out.println("2. add_student <id> <name> <class>");
        System.out.println("3. schedule_assignment <class> <title> <description>");
        System.out.println("4. submit_assignment <student_id> <class> <title> <content>");
        System.out.println("5. list_classrooms");
        System.out.println("6. list_students <class>");
        System.out.println("7. list_assignments <class>");
        System.out.println("8. remove_classroom <name>");
        System.out.println("9. help");
        System.out.println("10. exit");
        System.out.print("\nEnter command: ");
    }

    private void processCommand(String input) {
        if (input.isEmpty()) {
            System.out.println("Please enter a command");
            return;
        }

        String[] parts = input.split(" ", 2);
        String command = parts[0];
        String args = parts.length > 1 ? parts[1] : "";

        switch (command) {
            case "add_classroom":
                handleAddClassroom(args);
                break;
            case "add_student":
                handleAddStudent(args);
                break;
            case "schedule_assignment":
                handleScheduleAssignment(args);
                break;
            case "submit_assignment":
                handleSubmitAssignment(args);
                break;
            case "list_classrooms":
                handleListClassrooms();
                break;
            case "list_students":
                handleListStudents(args);
                break;
            case "list_assignments":
                handleListAssignments(args);
                break;
            case "remove_classroom":
                handleRemoveClassroom(args);
                break;
            case "help":
                displayHelp();
                break;
            case "exit":
                handleExit();
                break;
            default:
                System.out.println("Unknown command: " + command);
                displayHelp();
        }
    }

    private void handleAddClassroom(String args) {
        if (args.isEmpty()) {
            throw new IllegalArgumentException("Classroom name required");
        }
        classroomService.addClassroom(args);
        System.out.println("Classroom " + args + " has been created.");
    }

    private void handleAddStudent(String args) {
        String[] parts = args.split(" ", 3);
        if (parts.length < 3) {
            throw new IllegalArgumentException("Usage: add_student <id> <name> <class>");
        }
        classroomService.addStudent(parts[0], parts[1], parts[2]);
        System.out.println("Student " + parts[0] + " has been enrolled in " + parts[2] + ".");
    }

    private void handleScheduleAssignment(String args) {
        String[] parts = args.split(" ", 3);
        if (parts.length < 3) {
            throw new IllegalArgumentException("Usage: schedule_assignment <class> <title> <description>");
        }
        classroomService.scheduleAssignment(parts[0], parts[1], parts[2]);
        System.out.println("Assignment for " + parts[0] + " has been scheduled.");
    }

    private void handleSubmitAssignment(String args) {
        String[] parts = args.split(" ", 4);
        if (parts.length < 4) {
            throw new IllegalArgumentException("Usage: submit_assignment <student_id> <class> <title> <content>");
        }
        classroomService.submitAssignment(parts[0], parts[1], parts[2], parts[3]);
        System.out.println("Assignment submitted by Student " + parts[0] + " in " + parts[1] + ".");
    }

    private void handleListClassrooms() {
        List<Classroom> classrooms = classroomService.getAllClassrooms();
        if (classrooms.isEmpty()) {
            System.out.println("No classrooms available.");
        } else {
            System.out.println("\nClassrooms:");
            for (Classroom classroom : classrooms) {
                System.out.println("Class: " + classroom.getName() +
                        " (Students: " + classroom.getStudents().size() +
                        ", Assignments: " + classroom.getAssignments().size() + ")");
            }
        }
    }

    private void handleListStudents(String args) {
        if (args.isEmpty()) {
            throw new IllegalArgumentException("Classroom name required");
        }
        Classroom classroom = classroomService.getClassroom(args);
        List<Student> students = classroom.getStudents();

        if (students.isEmpty()) {
            System.out.println("No students enrolled in " + args);
        } else {
            System.out.println("\nStudents in " + args + ":");
            for (Student student : students) {
                System.out.println("👨‍🎓 " + student);
            }
        }
    }

    private void handleListAssignments(String args) {
        if (args.isEmpty()) {
            throw new IllegalArgumentException("Classroom name required");
        }
        Classroom classroom = classroomService.getClassroom(args);
        List<Assignment> assignments = classroom.getAssignments();

        if (assignments.isEmpty()) {
            System.out.println("No assignments in " + args);
        } else {
            System.out.println("\nAssignments in " + args + ":");
            for (Assignment assignment : assignments) {
                System.out.println("📝 " + assignment);
            }
        }
    }

    private void handleRemoveClassroom(String args) {
        if (args.isEmpty()) {
            throw new IllegalArgumentException("Classroom name required");
        }
        classroomService.removeClassroom(args);
        System.out.println("Classroom " + args + " has been removed.");
    }

    private void displayHelp() {
        System.out.println("""
            \nAvailable Commands:
            add_classroom <name>          - Create a new classroom
            add_student <id> <name> <class> - Enroll student
            schedule_assignment <class> <title> <desc> - Schedule assignment
            submit_assignment <student_id> <class> <title> <content> - Submit assignment
            list_classrooms               - List all classrooms
            list_students <class>         - List students in classroom
            list_assignments <class>      - List assignments in classroom
            remove_classroom <name>       - Remove classroom
            help                          - Show this help
            exit                          - Exit application
            """);
    }

    private void handleExit() {
        Logger.info("Application shutting down");
        System.out.println("Thank you for using Virtual Classroom Manager!");
        running = false;
        scanner.close();
    }

    public static void main(String[] args) {
        try {
            VirtualClassroomManager manager = new VirtualClassroomManager();
            manager.start();
        } catch (Exception e) {
            Logger.error("Failed to start application: " + e.getMessage());
            System.err.println("Critical error: " + e.getMessage());
        }
    }
}
