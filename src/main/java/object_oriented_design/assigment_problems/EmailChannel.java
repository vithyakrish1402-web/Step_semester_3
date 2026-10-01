package object_oriented_design.assigment_problems;

public class EmailChannel implements NotificationChannel {

    @Override
    public void send(String studentName, String noticeTitle) {
        System.out.println("[Email \u2192 " + studentName + "] " + noticeTitle);
    }

    @Override
    public String getChannelName() {
        return "Email";
    }
}
