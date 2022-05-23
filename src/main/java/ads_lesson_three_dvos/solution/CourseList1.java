// Frans Spijkerman, Avans Hogeschool 2022
package ads_lesson_three_dvos.solution;

import ads_lesson_three_dvos.model.Course;
import ads_lesson_three_dvos.model.Student;
import ads_lesson_three_dvos.tools.Konsole;

public class CourseList1 extends CourseList {

    @Override
    public void run() {
        course = new Course("Acting for beginners");

        Student john = new Student(1201, "John Doe", 2019);
        Student paul = new Student(1202, "Paul Doe", 2019);
        Student george = new Student(1203, "George Doe", 2019);
        Student ringo = new Student(1204, "Ringo Doe", 2019);
        Student ringo2 = new Student(1204, "Ringo Doe2", 2019);
        Student ringo3 = new Student(1204, "Ringo Doe3", 2019);

        course.addStudent(paul);
        course.addStudent(george);
        course.addStudent(ringo);
        course.addStudent(ringo2);
        course.addStudent(ringo3);

        Konsole.writeLine(course);

        checkStudent(john);
        checkStudent(paul);

        course.printByName();
        course.printByNumber();
    }
}
