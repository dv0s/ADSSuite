package ads_lesson_one.tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.MessageFormat;

public class Konsole {

    private static final BufferedReader BUF = new BufferedReader(new InputStreamReader(System.in));

    public static String readLine() {
        try {
            return BUF.readLine();
        } catch (IOException e) {
            System.err.println(e.getLocalizedMessage());
            return "";
        }
    }

    public static String readLine(String prompt) {
        if(!prompt.isEmpty())
            writeLine(prompt);
        return readLine();
    }
    
    public static int readInt(int min, int max) {
        return (int) readLong("", min, min, max);
    }

    public static int readInt(String prompt, int min, int max) {
        return (int) readLong(prompt, min, min, max);
    }

    public static int readInt(String prompt, int deflt, int min, int max) {
        return (int) readLong(prompt, deflt, min, max);
    }

    public static long readLong(String prompt, long min, long max) {
        return readLong(prompt, min, min, max);
    }

    public static long readLong(String prompt, long deflt, long min, long max) {
        while (true) {
            String input = readLine(prompt);
            if (input.length() == 0) {
                return deflt;
            }
            try {
                long value = Long.parseLong(input);
                if (value >= min && value <= max) {
                    return value;
                }
                System.err.println("We need something between " + min + " and " + max);
            } catch (NumberFormatException e) {
                System.err.println("?");
            }
        }
    }

    private static void _write(String message, Object[] args) {
        MessageFormat fmt = new MessageFormat(message);
        System.out.print(fmt.format(args));
    }

    public static void writeLine() {
        System.out.println();
    }

    public static void write(Object object) {
        System.out.print(object);
    }

    public static void writeLine(Object object) {
        System.out.println(object);
    }

    public static void write(String message, Object... args) {
        _write(message, args);
    }

    public static void writeLine(String message, Object... args) {
        _write(message, args);
        System.out.println();
    }

}
