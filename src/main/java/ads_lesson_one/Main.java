package ads_lesson_one;

import ads_lesson_one.solution.*;
import ads_lesson_one.tools.*;

class Main {

    public static void main(String[] args) {

        int choice = -1;
        while (choice != 0) {
            
            Konsole.writeLine("1: find prime factor");
            Konsole.writeLine("2: find word");
            choice = Konsole.readInt(0, 2);
            
            switch (choice) {
                case 1 ->
                    new FactorFinder().run();
                case 2 ->
                    new WordFinder().run();
            }
        }
    }
}
