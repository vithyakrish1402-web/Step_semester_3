package object_oriented_design.assigment_problems;

public class AppChannel implements NotificationChannel {

    @Override
    public void send(String studentName, String noticeTitle) {
        System.out.println("[App \u2192 " + studentName + "] " + noticeTitle);
    }

    @Override
    public String getChannelName() {
        return "App";
    }
}
