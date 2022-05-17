// Frans Spijkerman, Avans Hogeschool 2022
package ads_lesson_three_dvos.model;

import java.util.HashSet;

public class Course {

    private final String name;
    private final HashSet<Student> students;

    public void addStudent(Student student) {
        students.add(student);
    }

    public boolean hasStudent(Student student) {
        return students.contains(student);
    }

    public Course(String name) {
        this.name = name;
        this.students = new HashSet<>();
    }

    @Override
    public String toString() {
        String out = "Course: " + name + "\nStudents:";
        for (var student : students) {
            out += "\n" + student;
        }
        return out + "\n";
    }

}
