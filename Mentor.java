import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Mentor {
    private String mentorId;
    private String name;
    private String email;
    private String designation;
    private String company;
    private int maxStudents = 5;
    private int currentStudents = 0;

    // Static collection to hold all mentors
    private static List<Mentor> allMentors = new ArrayList<>();

    // Static counter
    private static int totalMentorsCreated = 0;

    public Mentor(String mentorId, String name, String email,
                  String designation, String company) throws IllegalArgumentException {
        if (mentorId == null || mentorId.trim().isEmpty())
            throw new IllegalArgumentException("Mentor ID cannot be empty.");
        if (name == null || name.trim().isEmpty())
            throw new IllegalArgumentException("Mentor name cannot be empty.");
        if (email == null || !email.contains("@"))
            throw new IllegalArgumentException("Invalid mentor email: " + email);

        this.mentorId = mentorId;
        this.name = name;
        this.email = email;
        this.designation = designation;
        this.company = company;
        totalMentorsCreated++;
    }

    public boolean canAcceptStudent() {
        return currentStudents < maxStudents;
    }

    public void assignStudent() throws Exception {
        if (!canAcceptStudent())
            throw new Exception("Mentor " + name + " has reached max student limit (" + maxStudents + ").");
        currentStudents++;
    }

    public String getMentorId() { return mentorId; }
    public String getName() { return name; }

    public static int getTotalMentorsCreated() { return totalMentorsCreated; }

    public static List<Mentor> getAllMentors() {
        return Collections.unmodifiableList(allMentors);
    }

    public static void addToGlobalList(Mentor m) {
        allMentors.add(m);
    }

    public static Mentor findById(String id) throws Exception {
        for (Mentor m : allMentors) {
            if (m.mentorId.equals(id)) return m;
        }
        throw new Exception("Mentor not found with ID: " + id);
    }

    public void display() {
        System.out.println("Mentor ID   : " + mentorId);
        System.out.println("Name        : " + name);
        System.out.println("Email       : " + email);
        System.out.println("Designation : " + designation);
        System.out.println("Company     : " + company);
        System.out.println("Students    : " + currentStudents + "/" + maxStudents);
    }
}
