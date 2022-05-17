// Frans Spijkerman, Avans Hogeschool 2022
package ads_lesson_two.solution;

import ads.tools.Konsole;

public class NumberTester {

    public void run() {
        Numbers list = new Numbers(10);

        list.insertNumber(21);
        list.insertNumber(23);
        list.insertNumber(27);
        list.insertNumber(23);
        list.insertNumber(26);
        list.insertNumber(28);
        Konsole.writeLine(list);

        list.insertNumber(33);
        list.insertNumber(16);
        list.insertNumber(21);
        list.insertNumber(21);
        list.insertNumber(45);
        list.insertNumber(22);
        list.insertNumber(19);
        list.insertNumber(18);
        list.insertNumber(17);
        list.insertNumber(16);
        list.insertNumber(15);
        Konsole.writeLine(list);
    }
}
