import java.util.ArrayList;
import java.util.List;

public abstract class Notification {
    protected String notificationId;
    protected String message;

    // Static log of all sent notifications
    private static List<String> notificationLog = new ArrayList<>();

    public abstract void send() throws Exception;

    // Static method to log a notification
    protected static void logNotification(String entry) {
        notificationLog.add(entry);
    }

    // Static method to view all logs
    public static List<String> getNotificationLog() {
        return new ArrayList<>(notificationLog);
    }

    // Static method to get count
    public static int getTotalNotificationsSent() {
        return notificationLog.size();
    }
}
