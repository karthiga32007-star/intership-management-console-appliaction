import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProgressReport {
    private String reportId;
    private String studentId;
    private String weekNumber;

    // Static list of all progress reports
    private static List<ProgressReport> allReports = new ArrayList<>();

    // File name for saving reports
    private static final String REPORT_FILE = "progress_reports_log.txt";

    public ProgressReport(String reportId, String studentId, String weekNumber)
            throws IllegalArgumentException {
        if (reportId == null || reportId.trim().isEmpty())
            throw new IllegalArgumentException("Report ID cannot be empty.");
        if (studentId == null || studentId.trim().isEmpty())
            throw new IllegalArgumentException("Student ID cannot be empty.");
        if (weekNumber == null || weekNumber.trim().isEmpty())
            throw new IllegalArgumentException("Week number cannot be empty.");

        this.reportId = reportId;
        this.studentId = studentId;
        this.weekNumber = weekNumber;
    }

    // Static method to add report
    public static void addReport(ProgressReport pr) {
        allReports.add(pr);
        System.out.println("Progress report added: " + pr.reportId);
    }

    // Static method to get all reports
    public static List<ProgressReport> getAllReports() {
        return new ArrayList<>(allReports);
    }

    // Static method to get reports by student
    public static List<ProgressReport> getReportsByStudent(String studentId) {
        List<ProgressReport> result = new ArrayList<>();
        for (ProgressReport pr : allReports) {
            if (pr.studentId.equals(studentId)) {
                result.add(pr);
            }
        }
        return result;
    }

    // File handling: save all progress reports to file
    public static void saveToFile() {
        try (FileWriter fw = new FileWriter(REPORT_FILE, false)) {
            fw.write("===== PROGRESS REPORTS =====\n");
            for (ProgressReport pr : allReports) {
                fw.write("Report ID  : " + pr.reportId + "\n");
                fw.write("Student ID : " + pr.studentId + "\n");
                fw.write("Week       : " + pr.weekNumber + "\n");
                fw.write("----------------------------\n");
            }
            System.out.println("Progress reports saved to " + REPORT_FILE);
        } catch (IOException e) {
            System.out.println("Error saving progress reports file: " + e.getMessage());
        }
    }

    public void display() {
        System.out.println("Report ID  : " + reportId);
        System.out.println("Student ID : " + studentId);
        System.out.println("Week       : " + weekNumber);
    }
}
