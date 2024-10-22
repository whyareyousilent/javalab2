import java.util.Objects;

/**
 * Клас, що представляє курс.
 */
public class Course implements Comparable<Course> {
    private String name;
    private int credits;

    public Course(String name, int credits) {
        this.name = name;
        this.credits = credits;
    }

    public String getName() {
        return name;
    }

    public int getCredits() {
        return credits;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", credits=" + credits +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course)) return false;
        Course course = (Course) o;
        return credits == course.credits && Objects.equals(name, course.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, credits);
    }

    @Override
    public int compareTo(Course o) {
        return Integer.compare(this.credits, o.credits);
    }
}
