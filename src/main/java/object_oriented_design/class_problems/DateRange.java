package object_oriented_design.class_problems;

public class DateRange {

    private String label;
    private int startDay;
    private int endDay;

    public DateRange(String label, int startDay, int endDay) {
        this.label = label;
        this.startDay = startDay;
        this.endDay = endDay;
    }

    public String getLabel() {
        return label;
    }

    public int getStartDay() {
        return startDay;
    }

    public int getEndDay() {
        return endDay;
    }

    public int getDays() {
        return endDay - startDay;
    }

    public boolean overlaps(DateRange other) {
        return this.startDay < other.endDay && other.startDay < this.endDay;
    }
}
