import java.util.Scanner;
import java.time.LocalDate;

public class MainApp {

    static Scanner sc = new Scanner(System.in);
    static InternshipSystemManager manager = new InternshipSystemManager();

    public static void main(String[] args) {

        int choice = 0;

        do {
            System.out.println("\n===== INTERNSHIP MANAGEMENT SYSTEM =====");
            System.out.println("1.  Register Student");
            System.out.println("2.  Register Mentor");
            System.out.println("3.  Register Company");
            System.out.println("4.  Create Internship");
            System.out.println("5.  Generate Report");
            System.out.println("6.  Track Attendance");
            System.out.println("7.  Issue Certificate");
            System.out.println("8.  Add Performance Evaluation");
            System.out.println("9.  Add Progress Report");
            System.out.println("10. Send Email Notification");
            System.out.println("11. Save All Data to Files");
            System.out.println("12. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:  registerStudent();         break;
                case 2:  registerMentor();          break;
                case 3:  registerCompany();         break;
                case 4:  createInternship();        break;
                case 5:  manager.generateReport();  break;
                case 6:  trackAttendance();         break;
                case 7:  issueCertificate();        break;
                case 8:  addEvaluation();           break;
                case 9:  addProgressReport();       break;
                case 10: sendEmailNotification();   break;
                case 11: saveAllDataToFiles();      break;
                case 12: System.out.println("Thank you! Program exited."); break;
                default: System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 12);

        sc.close();
    }

    private static void registerStudent() {
        System.out.println("\n--- Register Student ---");
        try {
            System.out.print("Student ID   : "); String sid   = sc.nextLine();
            System.out.print("First Name   : "); String fname = sc.nextLine();
            System.out.print("Last Name    : "); String lname = sc.nextLine();
            System.out.print("Email        : "); String email = sc.nextLine();
            System.out.print("Phone        : "); String phone = sc.nextLine();

            System.out.print("Birth Year   : "); int year  = Integer.parseInt(sc.nextLine().trim());
            System.out.print("Birth Month  : "); int month = Integer.parseInt(sc.nextLine().trim());
            System.out.print("Birth Day    : "); int day   = Integer.parseInt(sc.nextLine().trim());

            System.out.print("Department   : "); String dept = sc.nextLine();
            System.out.print("Semester     : "); int sem    = Integer.parseInt(sc.nextLine().trim());
            System.out.print("CGPA         : "); double cgpa = Double.parseDouble(sc.nextLine().trim());

            Student student = new Student(sid, fname, lname, email, phone,
                    LocalDate.of(year, month, day), dept, sem, cgpa);
            manager.registerStudent(student);

        } catch (IllegalArgumentException e) {
            System.out.println("Input error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }
    }

    private static void registerMentor() {
        System.out.println("\n--- Register Mentor ---");
        try {
            System.out.print("Mentor ID    : "); String mid     = sc.nextLine();
            System.out.print("Name         : "); String name    = sc.nextLine();
            System.out.print("Email        : "); String email   = sc.nextLine();
            System.out.print("Designation  : "); String desig   = sc.nextLine();
            System.out.print("Company      : "); String company = sc.nextLine();

            Mentor mentor = new Mentor(mid, name, email, desig, company);
            manager.registerMentor(mentor);

        } catch (IllegalArgumentException e) {
            System.out.println("Input error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }
    }

    private static void registerCompany() {
        System.out.println("\n--- Register Company ---");
        try {
            System.out.print("Company ID   : "); String cid      = sc.nextLine();
            System.out.print("Company Name : "); String cname    = sc.nextLine();
            System.out.print("Industry     : "); String industry = sc.nextLine();
            System.out.print("Address      : "); String address  = sc.nextLine();

            Company company = new Company(cid, cname, industry, address);
            manager.registerCompany(company);

        } catch (IllegalArgumentException e) {
            System.out.println("Input error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }
    }

    private static void createInternship() {
        System.out.println("\n--- Create Internship ---");
        try {
            System.out.print("Internship ID    : "); String iid   = sc.nextLine();
            System.out.print("Internship Title : "); String title = sc.nextLine();
            System.out.print("Student ID       : "); String sid   = sc.nextLine();
            System.out.print("Mentor ID        : "); String mid   = sc.nextLine();
            System.out.print("Company ID       : "); String cid   = sc.nextLine();

            Internship internship = new Internship(iid, title, sid, mid, cid,
                    LocalDate.now(), LocalDate.now().plusMonths(3));
            manager.createInternship(internship);

        } catch (IllegalArgumentException e) {
            System.out.println("Input error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }
    }

    private static void trackAttendance() {
        System.out.println("\n--- Track Attendance ---");
        try {
            System.out.print("Student ID    : "); String sid        = sc.nextLine();
            System.out.print("Present Days  : "); int presentDays   = Integer.parseInt(sc.nextLine().trim());
            System.out.print("Total Days    : "); int totalDays     = Integer.parseInt(sc.nextLine().trim());

            AttendanceTracker at = new AttendanceTracker(sid, presentDays, totalDays);
            AttendanceTracker.track(at);
            at.display();

        } catch (IllegalArgumentException e) {
            System.out.println("Input error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }
    }

    private static void issueCertificate() {
        System.out.println("\n--- Issue Certificate ---");
        try {
            System.out.print("Certificate ID   : "); String cid   = sc.nextLine();
            System.out.print("Student Name     : "); String sname = sc.nextLine();
            System.out.print("Internship Title : "); String title = sc.nextLine();

            Certificate cert = new Certificate(cid, sname, title);
            Certificate.issue(cert);
            cert.display();

        } catch (IllegalArgumentException e) {
            System.out.println("Input error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }
    }

    private static void addEvaluation() {
        System.out.println("\n--- Add Performance Evaluation ---");
        try {
            System.out.print("Evaluation ID : "); String eid = sc.nextLine();
            System.out.print("Student ID    : "); String sid = sc.nextLine();
            System.out.print("Mentor ID     : "); String mid = sc.nextLine();
            System.out.print("Score (0-10)  : "); double score = Double.parseDouble(sc.nextLine().trim());

            PerformanceEvaluation pe = new PerformanceEvaluation(eid, sid, mid);
            pe.setScore(score);
            PerformanceEvaluation.addEvaluation(pe);
            pe.display();

        } catch (IllegalArgumentException e) {
            System.out.println("Input error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }
    }

    private static void addProgressReport() {
        System.out.println("\n--- Add Progress Report ---");
        try {
            System.out.print("Report ID  : "); String rid  = sc.nextLine();
            System.out.print("Student ID : "); String sid  = sc.nextLine();
            System.out.print("Week No.   : "); String week = sc.nextLine();

            ProgressReport pr = new ProgressReport(rid, sid, week);
            ProgressReport.addReport(pr);
            pr.display();

        } catch (IllegalArgumentException e) {
            System.out.println("Input error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }
    }

    private static void sendEmailNotification() {
        System.out.println("\n--- Send Email Notification ---");
        try {
            System.out.print("Notification ID : "); String nid     = sc.nextLine();
            System.out.print("Recipient Email : "); String email   = sc.nextLine();
            System.out.print("Message         : "); String message = sc.nextLine();

            EmailNotification en = new EmailNotification(nid, email, message);
            en.send();

        } catch (IllegalArgumentException e) {
            System.out.println("Input error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }
    }

    private static void saveAllDataToFiles() {
        System.out.println("\n--- Saving All Data to Files ---");
        AttendanceTracker.saveToFile();
        Certificate.saveToFile();
        PerformanceEvaluation.saveToFile();
        ProgressReport.saveToFile();
        manager.generateReport();
        System.out.println("All data saved successfully.");
    }
}
