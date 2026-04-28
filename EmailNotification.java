public class EmailNotification extends Notification {
    private String email;

    public EmailNotification(String notificationId, String email, String message) throws IllegalArgumentException {
        if (notificationId == null || notificationId.trim().isEmpty())
            throw new IllegalArgumentException("Notification ID cannot be empty.");
        if (email == null || !email.contains("@"))
            throw new IllegalArgumentException("Invalid email address: " + email);
        if (message == null || message.trim().isEmpty())
            throw new IllegalArgumentException("Message cannot be empty.");

        this.notificationId = notificationId;
        this.email = email;
        this.message = message;
    }

    @Override
    public void send() throws Exception {
        if (email == null || email.isEmpty())
            throw new Exception("Cannot send email: recipient address is missing.");
        System.out.println("Email sent to : " + email);
        System.out.println("Message       : " + message);
        logNotification("EmailNotification [" + notificationId + "] sent to " + email);
    }
}
