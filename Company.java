import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Company {
    private String companyId;
    private String name;
    private String industry;
    private String address;

    // Static collection to hold all companies
    private static List<Company> allCompanies = new ArrayList<>();

    // Static counter
    private static int totalCompaniesCreated = 0;

    public Company(String companyId, String name,
                   String industry, String address) throws IllegalArgumentException {
        if (companyId == null || companyId.trim().isEmpty())
            throw new IllegalArgumentException("Company ID cannot be empty.");
        if (name == null || name.trim().isEmpty())
            throw new IllegalArgumentException("Company name cannot be empty.");

        this.companyId = companyId;
        this.name = name;
        this.industry = industry;
        this.address = address;
        totalCompaniesCreated++;
    }

    public String getCompanyId() { return companyId; }
    public String getName() { return name; }

    public static int getTotalCompaniesCreated() { return totalCompaniesCreated; }

    public static List<Company> getAllCompanies() {
        return Collections.unmodifiableList(allCompanies);
    }

    public static void addToGlobalList(Company c) {
        allCompanies.add(c);
    }

    public static Company findById(String id) throws Exception {
        for (Company c : allCompanies) {
            if (c.companyId.equals(id)) return c;
        }
        throw new Exception("Company not found with ID: " + id);
    }

    public void display() {
        System.out.println("Company ID : " + companyId);
        System.out.println("Name       : " + name);
        System.out.println("Industry   : " + industry);
        System.out.println("Address    : " + address);
    }
}
