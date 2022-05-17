// Frans Spijkerman, Avans Hogeschool 2022
package ads;

import ads.tools.Konsole;
import ads.solution.*;

class Main {

    public static void main(String[] args) {

        int choice = -1;
        while (choice != 0) {

            Konsole.writeLine("1: List 1");
            Konsole.writeLine("2: List 2");
            Konsole.writeLine("3: List 3");
            Konsole.writeLine("4: Array of Numbers");
            choice = Konsole.readInt(0, 4);

            switch (choice) {
                case 1 ->
                    new CourseList1().run();
                case 2 ->
                    new CourseList2().run();
                case 3 ->
                    new CourseList3().run();
                case 4 ->
                    new NumberTester().run();
            }
        }
    }

}
