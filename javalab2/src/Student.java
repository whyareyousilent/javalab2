import java.util.List;
import java.util.Objects;

/**
 * Клас, що представляє студента.
 */
public class Student implements Comparable<Student> {
    private final String name;
    private final int age;
    private final List<Course> courses;

    private Student(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.courses = builder.courses;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<Course> getCourses() {
        return courses;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", courses=" + courses +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return age == student.age && Objects.equals(name, student.name) && Objects.equals(courses, student.courses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, courses);
    }

    @Override
    public int compareTo(Student o) {
        return this.name.compareTo(o.name);
    }

    /**
     * Патерн Builder для класу Student.
     */
    public static class Builder {
        private String name;
        private int age;
        private List<Course> courses;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public Builder setCourses(List<Course> courses) {
            this.courses = courses;
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }
}
