// Frans Spijkerman, Avans Hogeschool 2022
package ads_lesson_three_dvos.solution;

import ads_lesson_three_dvos.model.Course;
import ads_lesson_three_dvos.model.Student;
import ads_lesson_three_dvos.tools.Konsole;

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
