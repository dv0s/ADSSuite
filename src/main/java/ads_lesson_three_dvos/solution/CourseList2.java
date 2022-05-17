// Frans Spijkerman, Avans Hogeschool 2020

package ads_lesson_three_dvos.solution;

import ads.model.Course;
import ads_lesson_three_dvos.model.Student;
import ads_lesson_three_dvos.tools.Konsole;

public class CourseList2 extends CourseList {

    @Override
    public void run() {
        course = new Course("Nuclear physics");

        Student[] students = {
            new Student(2301, "Carl", 2001),
            new Student(2302, "Sheen", 2001),
            new Student(2303, "Jimmy", 2000)
        };

        for (var student : students) {
            course.addStudent(student);
        }

        Konsole.writeLine(course);
        
        checkStudent(students[0]);
        checkStudent(students[1]);
    }
}
