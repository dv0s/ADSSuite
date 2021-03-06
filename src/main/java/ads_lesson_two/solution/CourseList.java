// Frans Spijkerman, Avans Hogeschool 2022
package ads_lesson_two.solution;

import ads_lesson_two.model.Course;
import ads_lesson_two.model.Student;
import ads.tools.Konsole;

public abstract class CourseList {

    protected Course course;

    public abstract void run();

    void checkStudent(Student student) {
        Konsole.write(student.getName());
        if (course.hasStudent(student)) {
            Konsole.writeLine(" is enrolled");
        } else {
            Konsole.writeLine(" is NOT enrolled");
        }
    }
}
