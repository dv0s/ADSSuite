// Frans Spijkerman, Avans Hogeschool 2022
package ads_lesson_three_dvos.solution;

import ads_lesson_three_dvos.model.Course;
import ads_lesson_three_dvos.model.Student;
import ads_lesson_three_dvos.tools.Konsole;

public class CourseList4 extends CourseList {

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

        var studentToFind = 23763;
        Student student = course.findStudent(studentToFind);
        Konsole.write("Found student: ");
        Konsole.write(student.getName());
        Konsole.writeLine();
        Konsole.writeLine();

        studentToFind = 26403;
        student = course.findStudent(studentToFind);
        Konsole.write("Found student: ");
        Konsole.write(student.getName());
        Konsole.writeLine();
        Konsole.writeLine();

        studentToFind = 12345;
        student = course.findStudent(studentToFind);
        Konsole.write("Found student: ");
        Konsole.write(student.getName());
        Konsole.writeLine();
        Konsole.writeLine();
    }
}
