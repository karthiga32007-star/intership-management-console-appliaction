import java.util.ArrayList;

public abstract class InternshipManager {
    protected ArrayList<Student> students = new ArrayList<>();
    protected ArrayList<Mentor> mentors = new ArrayList<>();
    protected ArrayList<Company> companies = new ArrayList<>();
    protected ArrayList<Internship> internships = new ArrayList<>();

    public abstract void registerStudent(Student s);
    public abstract void registerMentor(Mentor m);
    public abstract void registerCompany(Company c);
    public abstract void createInternship(Internship i);
    public abstract void generateReport();
}
