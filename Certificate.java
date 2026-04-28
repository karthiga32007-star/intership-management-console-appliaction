import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Certificate {
    private String certificateId;
    private String studentName;
    private String internshipTitle;

    // Static list of all certificates issued
    private static List<Certificate> allCertificates = new ArrayList<>();

    // Static file name for saving
    private static final String CERTIFICATE_FILE = "certificates_log.txt";

    public Certificate(String certificateId, String studentName, String internshipTitle)
            throws IllegalArgumentException {
        if (certificateId == null || certificateId.trim().isEmpty())
            throw new IllegalArgumentException("Certificate ID cannot be empty.");
        if (studentName == null || studentName.trim().isEmpty())
            throw new IllegalArgumentException("Student name cannot be empty.");
        if (internshipTitle == null || internshipTitle.trim().isEmpty())
            throw new IllegalArgumentException("Internship title cannot be empty.");

        this.certificateId = certificateId;
        this.studentName = studentName;
        this.internshipTitle = internshipTitle;
    }

    // Static method to issue and register certificate
    public static void issue(Certificate c) {
        allCertificates.add(c);
        System.out.println("Certificate issued: " + c.certificateId + " for " + c.studentName);
    }

    // Static method to get all certificates
    public static List<Certificate> getAllCertificates() {
        return new ArrayList<>(allCertificates);
    }

    // Static method to get total count
    public static int getTotalCertificates() {
        return allCertificates.size();
    }

    // File handling: save all certificates to file
    public static void saveToFile() {
        try (FileWriter fw = new FileWriter(CERTIFICATE_FILE, false)) {
            fw.write("===== CERTIFICATES ISSUED =====\n");
            for (Certificate c : allCertificates) {
                fw.write("Certificate ID : " + c.certificateId + "\n");
                fw.write("Student Name   : " + c.studentName + "\n");
                fw.write("Internship     : " + c.internshipTitle + "\n");
                fw.write("------------------------------\n");
            }
            System.out.println("Certificates saved to " + CERTIFICATE_FILE);
        } catch (IOException e) {
            System.out.println("Error saving certificates file: " + e.getMessage());
        }
    }

    public void display() {
        System.out.println("Certificate ID : " + certificateId);
        System.out.println("Student Name   : " + studentName);
        System.out.println("Internship     : " + internshipTitle);
    }
}
