import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AttendanceTracker {
    private String studentId;
    private int presentDays;
    private int totalDays;

    // Static map: studentId -> AttendanceTracker
    private static Map<String, AttendanceTracker> attendanceMap = new HashMap<>();

    // Static log of all attendance records saved to file
    private static final String ATTENDANCE_FILE = "attendance_log.txt";

    public AttendanceTracker(String studentId, int presentDays, int totalDays) throws IllegalArgumentException {
        if (studentId == null || studentId.trim().isEmpty())
            throw new IllegalArgumentException("Student ID cannot be empty.");
        if (totalDays <= 0)
            throw new IllegalArgumentException("Total days must be greater than 0.");
        if (presentDays < 0 || presentDays > totalDays)
            throw new IllegalArgumentException("Present days must be between 0 and total days.");

        this.studentId = studentId;
        this.presentDays = presentDays;
        this.totalDays = totalDays;
    }

    public int getAttendancePercent() {
        return (presentDays * 100) / totalDays;
    }

    // Static method to add tracker to map
    public static void track(AttendanceTracker at) {
        attendanceMap.put(at.studentId, at);
    }

    // Static method to get tracker by student ID
    public static AttendanceTracker getByStudentId(String studentId) throws Exception {
        AttendanceTracker at = attendanceMap.get(studentId);
        if (at == null)
            throw new Exception("No attendance record found for student ID: " + studentId);
        return at;
    }

    // Static method to get all tracked records
    public static List<AttendanceTracker> getAllRecords() {
        return new ArrayList<>(attendanceMap.values());
    }

    // File handling: save all attendance records to a file
    public static void saveToFile() {
        try (FileWriter fw = new FileWriter(ATTENDANCE_FILE, false)) {
            fw.write("===== ATTENDANCE RECORDS =====\n");
            for (AttendanceTracker at : attendanceMap.values()) {
                fw.write("Student ID : " + at.studentId + "\n");
                fw.write("Attendance : " + at.getAttendancePercent() + "%\n");
                fw.write("------------------------------\n");
            }
            System.out.println("Attendance records saved to " + ATTENDANCE_FILE);
        } catch (IOException e) {
            System.out.println("Error saving attendance file: " + e.getMessage());
        }
    }

    public void display() {
        System.out.println("Student ID : " + studentId);
        System.out.println("Attendance : " + getAttendancePercent() + "%");
    }
}
