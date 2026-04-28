import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Coordinator {
    private String coordinatorId;
    private String name;
    private String email;
    private String department;

    // Static collection of all coordinators
    private static List<Coordinator> allCoordinators = new ArrayList<>();

    // Static counter
    private static int totalCoordinators = 0;

    public Coordinator(String coordinatorId, String name,
                       String email, String department) throws IllegalArgumentException {
        if (coordinatorId == null || coordinatorId.trim().isEmpty())
            throw new IllegalArgumentException("Coordinator ID cannot be empty.");
        if (name == null || name.trim().isEmpty())
            throw new IllegalArgumentException("Coordinator name cannot be empty.");
        if (email == null || !email.contains("@"))
            throw new IllegalArgumentException("Invalid coordinator email: " + email);

        this.coordinatorId = coordinatorId;
        this.name = name;
        this.email = email;
        this.department = department;
        totalCoordinators++;
    }

    public String getCoordinatorId() { return coordinatorId; }
    public String getName() { return name; }

    public static int getTotalCoordinators() { return totalCoordinators; }

    public static List<Coordinator> getAllCoordinators() {
        return Collections.unmodifiableList(allCoordinators);
    }

    public static void addToGlobalList(Coordinator c) {
        allCoordinators.add(c);
    }

    public void display() {
        System.out.println("Coordinator ID : " + coordinatorId);
        System.out.println("Name           : " + name);
        System.out.println("Email          : " + email);
        System.out.println("Department     : " + department);
    }
}
