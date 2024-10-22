import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Створення курсів
        Course math = new Course("Mathematics", 5);
        Course physics = new Course("Physics", 4);
        Course chemistry = new Course("Chemistry", 3);
        Course programming = new Course("Programming", 6);
        Course history = new Course("History", 2);

        // Додавання курсів до списку
        List<Course> courses = new ArrayList<>();
        courses.add(math);
        courses.add(physics);
        courses.add(chemistry);
        courses.add(programming);
        courses.add(history);

        // Створення студентів за допомогою патерну Builder
        Student student1 = new Student.Builder()
                .setName("Ivan Ivanov")
                .setAge(20)
                .setCourses(List.of(math, physics))
                .build();

        Student student2 = new Student.Builder()
                .setName("Maria Petrenko")
                .setAge(22)
                .setCourses(List.of(chemistry, programming))
                .build();

        Student student3 = new Student.Builder()
                .setName("Oleg Sokolov")
                .setAge(19)
                .setCourses(List.of(math, chemistry, history))
                .build();

        Student student4 = new Student.Builder()
                .setName("Anna Kuznetsova")
                .setAge(21)
                .setCourses(List.of(physics, programming))
                .build();

        Student student5 = new Student.Builder()
                .setName("Sergey Petrov")
                .setAge(23)
                .setCourses(List.of(history, programming, chemistry))
                .build();

        // Додавання студентів до списку
        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);

        // Використання сервісних методів
        UniversityService service = new UniversityService();

        // Сортування студентів за віком
        List<Student> sortedByAge = service.sortStudentsByAge(students);
        System.out.println("Sorted Students by Age: " + sortedByAge);

        // Фільтрація студентів за курсом
        List<Student> filteredByCourse = service.filterStudentsByCourse(students, programming);
        System.out.println("Filtered Students by Programming Course: " + filteredByCourse);

        // Підрахунок загальної кількості кредитів
        int totalCredits = service.totalCredits(students);
        System.out.println("Total Credits: " + totalCredits);

        // Сортування курсів за кредитами
        List<Course> sortedCourses = service.sortCoursesByCredits(courses);
        System.out.println("Sorted Courses by Credits: " + sortedCourses);
    }
}
