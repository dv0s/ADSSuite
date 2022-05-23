// Frans Spijkerman, Avans Hogeschool 2022
package ads_lesson_three_dvos.model;

public class Student {

    private final int number;
    private final String name;
    private final int year;

    public Student(int number, String name, int year) {
        this.number = number;
        this.name = name;
        this.year = year;
    }

    @Override
    public String toString() {
        return year + ", " + number + ", " + name;
    }

    public String getName() {
        return name;
    }

    public Integer getNumber(){ return number; }

    @Override
    public int hashCode() {
        return (name + number + year).hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Student that = (Student) obj;
        return this.number == that.number
                && this.year == that.year
                && this.name.equals(that.name);
    }

}
