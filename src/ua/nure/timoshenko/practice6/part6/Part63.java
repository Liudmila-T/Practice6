package ua.nure.timoshenko.practice6.part6;

import ua.nure.timoshenko.practice6.part1.Word;
import ua.nure.timoshenko.practice6.part1.WordContainer;


public class Part63 {
    private static final String EOL = System.lineSeparator();
    private static final int FROM_INDEX = 0;
    private static final int TO_INDEX = 3;
    private static final int QUANTITY_DUPLICATES = 2;


    public static void main(String[] args) {

        StringBuilder reverseSB = new StringBuilder();
        StringBuilder result = new StringBuilder();
        WordContainer wc = new WordContainer() {
            private int i = FROM_INDEX;
            @Override
            public String toString() {
                for (Word word : getWords()) {
                    if ((i < TO_INDEX) && (word.getFrequency() >= QUANTITY_DUPLICATES)) {
                        reverseSB.append(word.getContent().toUpperCase()).reverse();
                        result.append(reverseSB).append(System.lineSeparator());
                        reverseSB.delete(FROM_INDEX, word.getContent().length());
                        i++;
                    }
                }
                return result.toString();
            }
        };

        for (String arg : args) {
            wc.add(arg);
        }
        System.out.println(wc);
    }

}

