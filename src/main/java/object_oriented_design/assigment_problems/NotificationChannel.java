package object_oriented_design.assigment_problems;

public interface NotificationChannel {
    void send(String studentName, String noticeTitle);
    String getChannelName();
}
