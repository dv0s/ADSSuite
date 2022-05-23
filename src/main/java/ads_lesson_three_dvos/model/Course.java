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

    public void addStudent(Student student) { students.add(student); }

    public boolean hasStudent(Student student) {
        return students.contains(student);
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("Course: " + name + "\nStudents:");
        for (var student : students) {
            out.append("\n").append(student);
        }
        return out + "\n";
    }

    public void printByName(){
//        Using List to sort it.
//        List<Student> studentsOBName = new ArrayList<>(students);
//        studentsOBName.sort(Comparator.comparing(Student::getName));

//        Using TreeSet
//        Set<Student> studentsOBName = new TreeSet<Student>(students);

        List<Student> studentsByName = students.stream()
                .sorted(Comparator.comparing(Student::getName))
                .toList();

        Konsole.writeLine("Students ordered by name:");
        studentsByName.forEach(student -> {
            Konsole.writeLine(student.toString());
            studentsOBName.put(student.getName(), student);
        });

        Konsole.writeLine(studentsOBName);
    }

    public void printByNumber(){
        List<Student> studentsByNumber = students.stream()
                .sorted(Comparator.comparing(Student::getNumber))
                .toList();

        Konsole.writeLine("Students ordered by number:");
        studentsByNumber.forEach(student ->{
                Konsole.writeLine(student.toString());
                studentsOBNumber.put(student.getNumber(), student);
        });

        Konsole.writeLine(studentsOBNumber);
    }
}
