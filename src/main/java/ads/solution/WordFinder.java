// Frans Spijkerman, Avans Hogeschool 2020
package ads.solution;

import ads.tools.*;
import java.util.Arrays;

public class WordFinder {

    /**
     * loop counter
     */
    private long count;

    /**
     * The sorted list of words
     */
    private static final String names[] = new String[]{
        "Adam", "Aiden", "Alexander", "Alice", "Amber", "Amelie", "Amélie",
        "Amir", "Anna", "Arthur", "Axelle", "Aya", "Ayden", "Bas", "Camille",
        "Cas", "Charlotte", "Cyriel", "Daan", "David", "Dries", "Eden", "Elena",
        "Elias", "Elise", "Ella", "Emiel", "Emily", "Emma", "Esmée", "Eva",
        "Febe", "Felix", "Fenna", "Ferre", "Fien", "Finn", "Fleur", "Floris",
        "Fran", "Gabriel", "Gust", "Hamza", "Hanne", "Helena", "Imran", "Inaya",
        "Jack", "Jade", "Janne", "Jayden", "Jules", "Julie", "Juliette",
        "Kamiel", "Kato", "Kobe", "Lara", "Lars", "Laura", "Laure", "Lena",
        "Leon", "Leonie", "Lewis", "Lex", "Liam", "Lily", "Lina", "Linde",
        "Lisa", "Liv", "Lize", "Lore", "Lotte", "Lou", "Louis", "Louise",
        "Luca", "Lucas", "Lucie", "Lukas", "Luna", "Manon", "Marie", "Mathias",
        "Mathis", "Mats", "Matteo", "Maurice", "Max", "Maxim", "Mila", "Milan",
        "Mohamed", "Mona", "Nathan", "Nina", "Noa", "Noah", "Nolan", "Noor",
        "Nora", "Olivia", "Omar", "Oona", "Oscar", "Rayan", "Renée", "Roos",
        "Ruben", "Sam", "Sara", "Sarah", "Seppe", "Sofia", "Stan", "Tess",
        "Theo", "Thomas", "Thor", "Tuur", "Vic", "Victor", "Vince", "Wout",
        "Yasmine"};

    /**
     * menu and runner
     */
    public void run() {
        int choice = -1;
        while (choice != 0) {
            choice = Konsole.readInt("[1=show list, 2=find one word, 3=find all, 4=find none, 5=shake] : ", 0, 4);
            switch (choice) {
                case 1 ->
                    showList();
                case 2 ->
                    findOne();
                case 3 ->
                    testFindAll();
                case 4 ->
                    testFindNone();
                case 5 ->
                    shake();
            }
        }
    }

    private void showList() {
        for (String name : names) {
            Konsole.write(name + "; ");
        }
        Konsole.writeLine();
    }

    /**
     * shake the name list to render it useless sort order is now from second
     * character in name
     */
    private void shake() {
        Arrays.sort(names, (String a, String b)
                -> a.substring(1).compareTo(b.substring(1))
        );
    }

    /**
     * ask for a word and try to find it repeat until empty line entered
     */
    private void findOne() {
        while (true) {
            String word = Konsole.readLine("Word to find: ");
            if (word.length() == 0) {
                return;
            }
            int pos = findWord(word, true);
            Konsole.writeLine("Found on position {0} in {1} steps", pos, count);
        }
    }

    /**
     * try to find every name from the list in the list
     */
    private void testFindAll() {
        int n = names.length;
        int total = 0;
        for (int i = 0; i < n; i++) {
            int pos = findWord(names[i], false);
            Konsole.writeLine("{0} steps to find {1} on position {2}", count, names[i], pos);
            total += count;
        }
        Konsole.writeLine("number of words: {0}", n);
        Konsole.writeLine("average steps: {0}", (double) total / n);
    }

    /**
     * try to find words that are not in the list
     */
    private void testFindNone() {
        int n = names.length;
        int total = 0;
        for (int i = 0; i < n; i++) {
            String name = names[i] + " de Vries";
            int pos = findWord(name, false);
            Konsole.writeLine("{0} steps to find {1} on position {2}", count, name, pos);
            total += count;
        }
        Konsole.writeLine("number of words: " + n);
        Konsole.writeLine("average steps: " + ((double) total / n));
    }

    /**
     * find a word in the list
     *
     * @param word, word to find
     * @return index of word in list, or -1 if not found
     */
    private int findWord(String word, boolean show) {
        int left = 0;
        int right = names.length - 1;
        count = 0;
        while (right >= left) {
            count++;
            int mid = (right + left) / 2;
            if (show) {
                Konsole.writeLine("{0} .. {1} : {2}", left, right, mid);
            }
            int dif = word.compareToIgnoreCase(names[mid]);
            if (dif == 0) {
                return mid;
            }
            if (dif > 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
