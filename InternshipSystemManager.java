import java.io.FileWriter;
import java.io.IOException;

public class InternshipSystemManager extends InternshipManager {

    // Static report file
    private static final String REPORT_FILE = "system_report.txt";

    public void registerStudent(Student s) {
        try {
            s.checkEmailFormat();
            s.checkPhoneLength();
            s.checkCGPARange();
            students.add(s);
            Student.addToGlobalList(s);
            System.out.println("Student registered: " + s.getFullName());
        } catch (IllegalArgumentException e) {
            System.out.println("Student registration failed: " + e.getMessage());
        }
    }

    public void registerMentor(Mentor m) {
        try {
            if (m == null) throw new IllegalArgumentException("Mentor cannot be null.");
            mentors.add(m);
            Mentor.addToGlobalList(m);
            System.out.println("Mentor registered: " + m.getName());
        } catch (IllegalArgumentException e) {
            System.out.println("Mentor registration failed: " + e.getMessage());
        }
    }

    public void registerCompany(Company c) {
        try {
            if (c == null) throw new IllegalArgumentException("Company cannot be null.");
            companies.add(c);
            Company.addToGlobalList(c);
            System.out.println("Company registered: " + c.getName());
        } catch (IllegalArgumentException e) {
            System.out.println("Company registration failed: " + e.getMessage());
        }
    }

    public void createInternship(Internship i) {
        try {
            i.checkDuration();
            internships.add(i);
            Internship.addToGlobalList(i);
            System.out.println("Internship created: " + i.getInternshipId());
        } catch (IllegalArgumentException e) {
            System.out.println("Internship creation failed: " + e.getMessage());
        }
    }

    public void generateReport() {
        System.out.println("\n===== SYSTEM REPORT =====");
        System.out.println("Total Students    : " + students.size());
        System.out.println("Total Mentors     : " + mentors.size());
        System.out.println("Total Companies   : " + companies.size());
        System.out.println("Total Internships : " + internships.size());
        saveReportToFile();
    }

    // File handling: save report to file
    private void saveReportToFile() {
        try (FileWriter fw = new FileWriter(REPORT_FILE, false)) {
            fw.write("===== SYSTEM REPORT =====\n");
            fw.write("Total Students    : " + students.size() + "\n");
            fw.write("Total Mentors     : " + mentors.size() + "\n");
            fw.write("Total Companies   : " + companies.size() + "\n");
            fw.write("Total Internships : " + internships.size() + "\n");

            fw.write("\n--- Students ---\n");
            for (Student s : students) {
                fw.write(s.getStudentId() + " : " + s.getFullName() + "\n");
            }
            fw.write("\n--- Mentors ---\n");
            for (Mentor m : mentors) {
                fw.write(m.getMentorId() + " : " + m.getName() + "\n");
            }
            fw.write("\n--- Companies ---\n");
            for (Company c : companies) {
                fw.write(c.getCompanyId() + " : " + c.getName() + "\n");
            }
            fw.write("\n--- Internships ---\n");
            for (Internship i : internships) {
                fw.write(i.getInternshipId() + "\n");
            }
            System.out.println("Report saved to " + REPORT_FILE);
        } catch (IOException e) {
            System.out.println("Error saving report: " + e.getMessage());
        }
    }
}
