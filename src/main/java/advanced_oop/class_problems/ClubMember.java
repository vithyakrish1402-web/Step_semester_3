package advanced_oop.class_problems;

import java.util.Objects;

public class ClubMember {

    private String rollNumber;
    private String name;

    public ClubMember(String rollNumber, String name) {
        this.rollNumber = rollNumber;
        this.name = name;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ClubMember that = (ClubMember) o;
        return Objects.equals(rollNumber, that.rollNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rollNumber);
    }
}
