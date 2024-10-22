import java.util.*;
import java.util.stream.Collectors;

/**
 * Сервісний клас для роботи з колекціями об'єктів університету.
 */
public class UniversityService {
    /**
     * Сортує студентів за віком.
     *
     * @param students Список студентів.
     * @return Відсортований список студентів.
     */
    public List<Student> sortStudentsByAge(List<Student> students) {
        return students.stream()
                .sorted(Comparator.comparingInt(Student::getAge))
                .collect(Collectors.toList());
    }

    /**
     * Фільтрує студентів за курсом.
     *
     * @param students Список студентів.
     * @param course   Курс, за яким потрібно фільтрувати.
     * @return Список студентів, які проходять вказаний курс.
     */
    public List<Student> filterStudentsByCourse(List<Student> students, Course course) {
        return students.stream()
                .filter(student -> student.getCourses().contains(course))
                .collect(Collectors.toList());
    }

    /**
     * Підраховує загальну кількість кредитів курсів, які проходять студенти.
     *
     * @param students Список студентів.
     * @return Загальна кількість кредитів.
     */
    public int totalCredits(List<Student> students) {
        return students.stream()
                .flatMap(student -> student.getCourses().stream())
                .mapToInt(Course::getCredits)
                .sum();
    }

    /**
     * Сортує курси за кількістю кредитів.
     *
     * @param courses Список курсів.
     * @return Відсортований список курсів.
     */
    public List<Course> sortCoursesByCredits(List<Course> courses) {
        return courses.stream()
                .sorted()
                .collect(Collectors.toList());
    }
}
