package object_oriented_design.assigment_problems;

import java.util.Arrays;
import java.util.Collections;

public class CampusNoticeBroadcaster {

    public static void main(String[] args) {
        NoticeBoard noticeBoard = new NoticeBoard();

        Student asha = new Student("Asha", "CSE");
        asha.addPreferredChannel(new EmailChannel());
        asha.addPreferredChannel(new AppChannel());

        Student ravi = new Student("Ravi", "ECE");
        ravi.addPreferredChannel(new SmsChannel());

        noticeBoard.registerStudent(asha);
        noticeBoard.registerStudent(ravi);

        Notice notice1 = new Notice("Lab Closed Tomorrow", Collections.singletonList("CSE"));
        noticeBoard.postNotice(notice1);

        Notice notice2 = new Notice("Fee Deadline Extended", Arrays.asList("CSE", "ECE"));
        noticeBoard.postNotice(notice2);

        Notice notice3 = new Notice("Sports Day", Collections.emptyList());
        noticeBoard.postNotice(notice3);
    }
}
