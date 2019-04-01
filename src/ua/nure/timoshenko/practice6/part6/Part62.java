package ua.nure.timoshenko.practice6.part6;

import ua.nure.timoshenko.practice6.part1.Word;
import ua.nure.timoshenko.practice6.part1.WordContainer;

import java.util.List;

public class Part62 {
    private static final String EOL = System.lineSeparator();
    private static final int FROM_INDEX = 0;
    private static final int TO_INDEX = 3;
    private static WordContainer wc;

    public static void main(String[] args) {
        wc = new WordContainer();

        for (String arg : args) {
            wc.add(arg);
        }
        wc.getWords().sort((a, b) -> {
            return  -a.getContent().length() + b.getContent().length();
        });
        print(wc.getWords().subList(FROM_INDEX, TO_INDEX));
    }

    public static void print(List<Word> list) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(wc.getWords().subList(FROM_INDEX,TO_INDEX).get(i).getContent()).append(" ==> ")
                    .append(wc.getWords().subList(FROM_INDEX, TO_INDEX).get(i).getContent().length()).append(EOL);
        }
        System.out.println(sb);
    }
}
