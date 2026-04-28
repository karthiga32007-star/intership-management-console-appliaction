import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PerformanceEvaluation {
    private String evaluationId;
    private String studentId;
    private String mentorId;
    private double score;

    // Static list of all evaluations
    private static List<PerformanceEvaluation> allEvaluations = new ArrayList<>();

    // Static default score
    private static final double DEFAULT_SCORE = 8.0;

    // File name for saving evaluations
    private static final String EVALUATION_FILE = "evaluations_log.txt";

    public PerformanceEvaluation(String evaluationId, String studentId, String mentorId)
            throws IllegalArgumentException {
        if (evaluationId == null || evaluationId.trim().isEmpty())
            throw new IllegalArgumentException("Evaluation ID cannot be empty.");
        if (studentId == null || studentId.trim().isEmpty())
            throw new IllegalArgumentException("Student ID cannot be empty.");
        if (mentorId == null || mentorId.trim().isEmpty())
            throw new IllegalArgumentException("Mentor ID cannot be empty.");

        this.evaluationId = evaluationId;
        this.studentId = studentId;
        this.mentorId = mentorId;
        this.score = DEFAULT_SCORE;
    }

    public void setScore(double score) throws IllegalArgumentException {
        if (score < 0 || score > 10)
            throw new IllegalArgumentException("Score must be between 0 and 10.");
        this.score = score;
    }

    // Static method to add evaluation
    public static void addEvaluation(PerformanceEvaluation pe) {
        allEvaluations.add(pe);
    }

    // Static method to get all evaluations
    public static List<PerformanceEvaluation> getAllEvaluations() {
        return new ArrayList<>(allEvaluations);
    }

    // Static method to get average score across all evaluations
    public static double getAverageScore() throws Exception {
        if (allEvaluations.isEmpty())
            throw new Exception("No evaluations available to compute average.");
        double sum = 0;
        for (PerformanceEvaluation pe : allEvaluations) {
            sum += pe.score;
        }
        return sum / allEvaluations.size();
    }

    // File handling: save all evaluations to file
    public static void saveToFile() {
        try (FileWriter fw = new FileWriter(EVALUATION_FILE, false)) {
            fw.write("===== PERFORMANCE EVALUATIONS =====\n");
            for (PerformanceEvaluation pe : allEvaluations) {
                fw.write("Evaluation ID : " + pe.evaluationId + "\n");
                fw.write("Student ID    : " + pe.studentId + "\n");
                fw.write("Mentor ID     : " + pe.mentorId + "\n");
                fw.write("Score         : " + pe.score + "\n");
                fw.write("----------------------------------\n");
            }
            System.out.println("Evaluations saved to " + EVALUATION_FILE);
        } catch (IOException e) {
            System.out.println("Error saving evaluations file: " + e.getMessage());
        }
    }

    public void display() {
        System.out.println("Evaluation ID : " + evaluationId);
        System.out.println("Student ID    : " + studentId);
        System.out.println("Mentor ID     : " + mentorId);
        System.out.println("Score         : " + score);
    }
}
