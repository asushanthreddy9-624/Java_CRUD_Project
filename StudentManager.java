import java.util.ArrayList;

// Implements the interface and uses collection
class StudentManager implements StudentOperations {
    private ArrayList<Student> students;  // Collection
    
    public StudentManager() {
        students = new ArrayList<>();
    }
    
    // CREATE: Add a student
    @Override
    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student added successfully!");
    }
    
    // READ: Display all students
    @Override
    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        
        System.out.println("\n=== ALL STUDENTS ===");
        for (Student student : students) {  // For-each loop
            student.displayInfo();
        }
    }
    
    // READ: Find student by ID
    public Student findStudent(String studentId) {
        for (int i = 0; i < students.size(); i++) {  // For loop
            if (students.get(i).getStudentId().equals(studentId)) {
                return students.get(i);
            }
        }
        return null;
    }
    
    // UPDATE: Update student details
    public void updateStudent(String studentId, String college, String module, double score) {
        Student student = findStudent(studentId);
        if (student != null) {
            student.updateDetails(college, module, score);
            System.out.println("Student updated successfully!");
        } else {
            System.out.println("Student not found!");
        }
    }
    
    // DELETE: Remove a student
    @Override
    public void removeStudent(String studentId) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getStudentId().equals(studentId)) {
                students.remove(i);
                System.out.println("Student removed successfully!");
                return;
            }
        }
        System.out.println("Student not found!");
    }
    
    // Additional method: Count students
    public int countStudents() {
        return students.size();
    }
    
    // Additional method: Find students by college
    public void findStudentsByCollege(String college) {
        boolean found = false;
        for (Student student : students) {
            if (student.getCollege().equalsIgnoreCase(college)) {
                student.displayInfo();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No students found from " + college);
        }
    }
}