package ua.nure.timoshenko.practice6.part6;

import ua.nure.timoshenko.practice6.part1.Word;
import ua.nure.timoshenko.practice6.part1.WordContainer;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class Part61 {
    private static final String EOL = System.lineSeparator();
    private static final int FROM_INDEX = 0;
    private static final int TO_INDEX = 3;
    private static WordContainer wc;

    public static void main(String[] args) {
        wc = new WordContainer();

        for (String arg : args) {
            wc.add(arg);
        }
        wc.getWords().sort((Word a, Word b) -> -a.getFrequency() + b.getFrequency());

        wc.getWords().subList(FROM_INDEX, TO_INDEX).sort((Word a, Word b) -> b.getContent().compareToIgnoreCase(a.getContent()));

        print(wc.getWords().subList(FROM_INDEX, TO_INDEX));
    }

    public static void print(Collection<Word> list) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(wc.getWords().subList(FROM_INDEX,TO_INDEX).get(i).getContent()).append(" ==> ")
                    .append(wc.getWords().subList(FROM_INDEX, TO_INDEX).get(i).getFrequency()).append(EOL);
        }
        System.out.println(sb);
    }

}
