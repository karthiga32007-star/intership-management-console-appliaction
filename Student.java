import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Student {
    private String studentId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private LocalDate birthDate;
    private String department;
    private int semester;
    private double cgpa;

    // Static collection to hold all students
    private static List<Student> allStudents = new ArrayList<>();

    // Static counter
    private static int totalStudentsCreated = 0;

    public Student(String studentId, String firstName, String lastName,
                   String email, String phone, LocalDate birthDate,
                   String department, int semester, double cgpa) throws IllegalArgumentException {
        if (studentId == null || studentId.trim().isEmpty())
            throw new IllegalArgumentException("Student ID cannot be empty.");
        if (firstName == null || firstName.trim().isEmpty())
            throw new IllegalArgumentException("First name cannot be empty.");
        if (lastName == null || lastName.trim().isEmpty())
            throw new IllegalArgumentException("Last name cannot be empty.");
        if (birthDate == null)
            throw new IllegalArgumentException("Birth date cannot be null.");

        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.birthDate = birthDate;
        this.department = department;
        this.semester = semester;
        this.cgpa = cgpa;
        totalStudentsCreated++;
    }

    public boolean checkEmailFormat() throws IllegalArgumentException {
        if (email == null || !email.contains("@") || !email.contains("."))
            throw new IllegalArgumentException("Invalid email format: " + email);
        return true;
    }

    public boolean checkPhoneLength() throws IllegalArgumentException {
        if (phone == null || phone.length() != 10)
            throw new IllegalArgumentException("Phone must be 10 digits. Got: " + (phone == null ? "null" : phone.length()));
        return true;
    }

    public boolean checkCGPARange() throws IllegalArgumentException {
        if (cgpa < 0 || cgpa > 10)
            throw new IllegalArgumentException("CGPA must be between 0 and 10. Got: " + cgpa);
        return true;
    }

    public int calculateAge() {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }

    public boolean isEligibleForInternship() {
        return cgpa >= 6.5 && calculateAge() >= 18;
    }

    public String getStudentId() { return studentId; }
    public String getFullName() { return firstName + " " + lastName; }

    // Static method to get total students created
    public static int getTotalStudentsCreated() { return totalStudentsCreated; }

    // Static method to get unmodifiable view of all students
    public static List<Student> getAllStudents() {
        return Collections.unmodifiableList(allStudents);
    }

    // Static method to add to global list
    public static void addToGlobalList(Student s) {
        allStudents.add(s);
    }

    // Static method to find student by ID
    public static Student findById(String id) throws Exception {
        for (Student s : allStudents) {
            if (s.studentId.equals(id)) return s;
        }
        throw new Exception("Student not found with ID: " + id);
    }

    public void display() {
        System.out.println("Student ID : " + studentId);
        System.out.println("Name       : " + getFullName());
        System.out.println("Email      : " + email);
        System.out.println("Phone      : " + phone);
        System.out.println("Department : " + department);
        System.out.println("Semester   : " + semester);
        System.out.println("CGPA       : " + cgpa);
        System.out.println("Age        : " + calculateAge());
        System.out.println("Eligible   : " + (isEligibleForInternship() ? "Yes" : "No"));
    }
}
