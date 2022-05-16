package ads_lesson_two;

import ads_lesson_one.tools.Konsole;

public class Main {
    public static void main(String[] args)
    {
        int choice = -1;
        while (choice != 0) {
            Konsole.writeLine("0: close the application");
            Konsole.writeLine("1: find prime factor");
            Konsole.writeLine("2: find word");
            choice = Konsole.readInt(0, 2);

            switch (choice) {
                case 0 -> System.out.println("Goodbye.");
                case 1 -> System.out.println("ADSSuite lesson two, choice 1");
                case 2 -> System.out.println("ADSSuite lesson two, choice 2");
            }
        }
    }
}
