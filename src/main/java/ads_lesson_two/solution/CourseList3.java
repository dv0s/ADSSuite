// Frans Spijkerman, Avans Hogeschool 2022
package ads.solution;

import ads.model.Course;
import ads.model.Student;
import ads.tools.Konsole;

public class CourseList3 extends CourseList {

    @Override
    public void run() {
        course = new Course("Thinking outside the box");

        Student[] students = {
            new Student(23763, "Donna", 2008),
            new Student(23431, "Martha", 2007),
            new Student(26403, "Yasmin", 2018),
            new Student(24123, "Amelia", 2012)
        };

        for (var student : students) {
            course.addStudent(student);
        }

        Konsole.writeLine(course);

        var donna = new Student(23763, "Donna", 2008);
        checkStudent(donna);
        Konsole.writeLine();

        course.addStudent(donna);
        Konsole.writeLine(course);
        checkStudent(donna);

        course.addStudent(donna);
        Konsole.writeLine(course);
    }
}
