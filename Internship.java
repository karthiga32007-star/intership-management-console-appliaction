import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Internship {
    private String internshipId;
    private String title;
    private String studentId;
    private String mentorId;
    private String companyId;
    private LocalDate startDate;
    private LocalDate endDate;

    // Static collection to hold all internships
    private static List<Internship> allInternships = new ArrayList<>();

    // Static counter
    private static int totalInternshipsCreated = 0;

    public Internship(String internshipId, String title,
                      String studentId, String mentorId,
                      String companyId, LocalDate startDate,
                      LocalDate endDate) throws IllegalArgumentException {
        if (internshipId == null || internshipId.trim().isEmpty())
            throw new IllegalArgumentException("Internship ID cannot be empty.");
        if (title == null || title.trim().isEmpty())
            throw new IllegalArgumentException("Internship title cannot be empty.");
        if (startDate == null || endDate == null)
            throw new IllegalArgumentException("Start and end dates cannot be null.");

        this.internshipId = internshipId;
        this.title = title;
        this.studentId = studentId;
        this.mentorId = mentorId;
        this.companyId = companyId;
        this.startDate = startDate;
        this.endDate = endDate;
        totalInternshipsCreated++;
    }

    public boolean checkDuration() throws IllegalArgumentException {
        if (startDate.isAfter(endDate))
            throw new IllegalArgumentException("Start date cannot be after end date.");
        return true;
    }

    public String getInternshipId() { return internshipId; }

    public static int getTotalInternshipsCreated() { return totalInternshipsCreated; }

    public static List<Internship> getAllInternships() {
        return Collections.unmodifiableList(allInternships);
    }

    public static void addToGlobalList(Internship i) {
        allInternships.add(i);
    }

    public static Internship findById(String id) throws Exception {
        for (Internship i : allInternships) {
            if (i.internshipId.equals(id)) return i;
        }
        throw new Exception("Internship not found with ID: " + id);
    }

    public void display() {
        System.out.println("Internship ID : " + internshipId);
        System.out.println("Title         : " + title);
        System.out.println("Student ID    : " + studentId);
        System.out.println("Mentor ID     : " + mentorId);
        System.out.println("Company ID    : " + companyId);
        System.out.println("Start Date    : " + startDate);
        System.out.println("End Date      : " + endDate);
    }
}
