// Frans Spijkerman, Avans Hogeschool 2022
package ads_lesson_three_dvos.model;

import ads_lesson_three_dvos.tools.Konsole;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Course {

    private final String name;
    private final HashSet<Student> students;
    private final HashMap<String, Student> studentsOBName;
    private final HashMap<Integer, Student> studentsOBNumber;

    public Course(String name) {
        this.name = name;
        this.students = new HashSet<>();
        this.studentsOBName = new HashMap<>();
        this.studentsOBNumber = new HashMap<>();
    }

    public void addStudent(Student student) {
        if(studentsOBNumber.containsKey(student.getNumber()))
        {
            Konsole.writeLine("Student " + student.getName() + "With number " + student.getNumber() + " is already enrolled!");
            return;
        }

        students.add(student);
        sortAndSaveByName();
        sortAndSaveByNumber();
    }

    public boolean hasStudent(Student student) {
        return students.contains(student);
    }

    public Student findStudent(int number)
    {
        if(studentsOBNumber.get(number) != null){
            return studentsOBNumber.get(number);
        }
        // This is cheating...
        return new Student(-1, "Student not Found", 0);
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("Course: " + name + "\nStudents:");
        for (var student : students) {
            out.append("\n").append(student);
        }
        return out + "\n";
    }

    public void sortAndSaveByName(){
        List<Student> studentsByName = students.stream()
                .sorted(Comparator.comparing(Student::getName))
                .toList();

        studentsByName.forEach(student -> studentsOBName.put(student.getName(), student));
    }

    public void sortAndSaveByNumber(){
        List<Student> studentsByNumber = students.stream()
                .sorted(Comparator.comparing(Student::getNumber))
                .toList();

        studentsByNumber.forEach(student -> studentsOBNumber.put(student.getNumber(), student));
    }


    public void printByName(){
        Konsole.writeLine("Students ordered by name: ");
        Konsole.writeLine(studentsOBName);
        Konsole.writeLine();
    }

    public void printByNumber(){
        Konsole.writeLine("Students ordered by number: ");
        Konsole.writeLine(studentsOBNumber);
        Konsole.writeLine();
    }
}
