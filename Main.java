import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManager manager = new StudentManager();
        
        System.out.println("=== STUDENT MANAGEMENT SYSTEM ===");
        
        while (true) {  // While loop 1
            displayMenu();
            System.out.print("Enter your choice (1-6): ");
            
            int choice;
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();  // Consume newline
            } else {
                System.out.println("Invalid input! Please enter a number.");
                scanner.nextLine();
                continue;
            }
            
            switch (choice) {
                case 1:  // Add student
                    addStudentMenu(scanner, manager);
                    break;
                    
                case 2:  // View all students
                    manager.displayAllStudents();
                    break;
                    
                case 3:  // Update student
                    updateStudentMenu(scanner, manager);
                    break;
                    
                case 4:  // Delete student
                    deleteStudentMenu(scanner, manager);
                    break;
                    
                case 5:  // Search student
                    searchStudentMenu(scanner, manager);
                    break;
                    
                case 6:  // Exit
                    System.out.println("Thank you for using Student Management System!");
                    scanner.close();
                    return;
                    
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
    
    // Method to display menu
    private static void displayMenu() {
        System.out.println("\n===== MAIN MENU =====");
        System.out.println("1. Add New Student");
        System.out.println("2. View All Students");
        System.out.println("3. Update Student Details");
        System.out.println("4. Delete Student");
        System.out.println("5. Search Student");
        System.out.println("6. Exit");
    }
    
    // Method to add student (with parameters)
    private static void addStudentMenu(Scanner scanner, StudentManager manager) {
        System.out.println("\n--- Add New Student ---");
        
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter student ID: ");
        String id = scanner.nextLine();
        
        System.out.print("Enter college: ");
        String college = scanner.nextLine();
        
        System.out.print("Enter module: ");
        String module = scanner.nextLine();
        
        double score;
        while (true) {  // While loop 2
            System.out.print("Enter module score (0-100): ");
            if (scanner.hasNextDouble()) {
                score = scanner.nextDouble();
                scanner.nextLine();
                if (score >= 0 && score <= 100) {
                    break;
                } else {
                    System.out.println("Score must be between 0 and 100!");
                }
            } else {
                System.out.println("Invalid input! Please enter a number.");
                scanner.nextLine();
            }
        }
        
        Student student = new Student(name, id, college, module, score);
        manager.addStudent(student);
    }
    
    // Method to update student
    private static void updateStudentMenu(Scanner scanner, StudentManager manager) {
        System.out.print("\nEnter student ID to update: ");
        String id = scanner.nextLine();
        
        Student student = manager.findStudent(id);
        if (student == null) {
            System.out.println("Student not found!");
            return;
        }
        
        System.out.print("Enter new college: ");
        String college = scanner.nextLine();
        
        System.out.print("Enter new module: ");
        String module = scanner.nextLine();
        
        double score;
        while (true) {
            System.out.print("Enter new module score (0-100): ");
            if (scanner.hasNextDouble()) {
                score = scanner.nextDouble();
                scanner.nextLine();
                if (score >= 0 && score <= 100) {
                    break;
                } else {
                    System.out.println("Score must be between 0 and 100!");
                }
            } else {
                System.out.println("Invalid input! Please enter a number.");
                scanner.nextLine();
            }
        }
        
        manager.updateStudent(id, college, module, score);
    }
    
    // Method to delete student
    private static void deleteStudentMenu(Scanner scanner, StudentManager manager) {
        System.out.print("\nEnter student ID to delete: ");
        String id = scanner.nextLine();
        
        // Confirmation
        System.out.print("Are you sure? (yes/no): ");
        String confirm = scanner.nextLine();
        
        if (confirm.equalsIgnoreCase("yes")) {  // If/else if
            manager.removeStudent(id);
        } else if (confirm.equalsIgnoreCase("no")) {
            System.out.println("Deletion cancelled.");
        } else {
            System.out.println("Invalid response!");
        }
    }
    
    // Method to search student
    private static void searchStudentMenu(Scanner scanner, StudentManager manager) {
        System.out.println("\n--- Search Options ---");
        System.out.println("1. Search by Student ID");
        System.out.println("2. Search by College");
        System.out.print("Enter choice: ");
        
        int choice = scanner.nextInt();
        scanner.nextLine();
        
        if (choice == 1) {
            System.out.print("Enter student ID: ");
            String id = scanner.nextLine();
            Student student = manager.findStudent(id);
            if (student != null) {
                System.out.println("\n--- Student Found ---");
                student.displayInfo();
            } else {
                System.out.println("Student not found!");
            }
        } else if (choice == 2) {
            System.out.print("Enter college name: ");
            String college = scanner.nextLine();
            manager.findStudentsByCollege(college);
        } else {
            System.out.println("Invalid choice!");
        }
    }
}