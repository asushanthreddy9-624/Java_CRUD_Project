// Abstract base class
abstract class Person {
    protected String name;
    
    public Person(String name) {
        this.name = name;
    }
    
    public abstract void displayInfo();
}

// Student class inheriting from Person
class Student extends Person {
    private String studentId;
    private String college;
    private String module;
    private double moduleScore;
    
    public Student(String name, String studentId, String college, String module, double moduleScore) {
        super(name); // Call parent constructor
        this.studentId = studentId;
        this.college = college;
        this.module = module;
        this.moduleScore = moduleScore;
    }
    
    // Getters
    public String getStudentId() { return studentId; }
    public String getCollege() { return college; }
    public String getModule() { return module; }
    public double getModuleScore() { return moduleScore; }
    
    // Setters
    public void setCollege(String college) { this.college = college; }
    public void setModule(String module) { this.module = module; }
    public void setModuleScore(double moduleScore) { this.moduleScore = moduleScore; }
    
    // Override displayInfo from abstract class
    @Override
    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + studentId);
        System.out.println("College: " + college);
        System.out.println("Module: " + module);
        System.out.println("Score: " + moduleScore);
        System.out.println("-------------------");
    }
    
    // Another method with parameters
    public void updateDetails(String college, String module, double score) {
        this.college = college;
        this.module = module;
        this.moduleScore = score;
    }
    
    // Method to check if student passed
    public boolean hasPassed() {
        return moduleScore >= 50;
    }
}