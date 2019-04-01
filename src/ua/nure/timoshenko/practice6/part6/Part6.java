package ua.nure.timoshenko.practice6.part6;

import ua.nure.timoshenko.practice6.Util;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class Part6 {

    private static final int QUANTITY_COMMANDS = 4;
    private static String[] words;

    public static void main(String[] args) throws UnsupportedEncodingException {
        String[] input = new String[QUANTITY_COMMANDS];
        for (int i = 0; i < input.length; i++) {
            System.setIn(new ByteArrayInputStream(args[i].getBytes("cp1251")));
            Scanner in = new Scanner(System.in, "cp1251");
            while (in.hasNextLine()) {
                input[i] = in.nextLine();
            }
        }
        parseInput(input);

    }

    private static void parseInput(String[] input) {

        for (int i = 0; i < input.length; i++) {
            if ("--input".equalsIgnoreCase(input[i]) || ("-i".equalsIgnoreCase(input[i]))) {
                workWithFile(input[i + 1]);
            }
            if ("--task".equalsIgnoreCase(input[i]) || ("-t".equalsIgnoreCase(input[i]))) {
                checkInput(input[i + 1]);
                break;
            }

        }
    }

    private static void workWithFile(String input) {
        String text = Util.readFile(input, "UTF-8");
        words = text.split("[ ?,.(){}\\[\\]\\-\\n\\r]+");
    }

    private static void checkInput(String input) {
        if (words != null) {
            if ("frequency".equals(input)) {
                Part61.main(words);
            }
            if ("length".equals(input)) {
                Part62.main(words);
            }
            if ("duplicates".equals(input)) {
                Part63.main(words);

            }
        }
    }
}

