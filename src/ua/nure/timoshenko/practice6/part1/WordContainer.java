package ua.nure.timoshenko.practice6.part1;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class WordContainer {
    private List<Word> words;
    private static final String ENCODING = "Cp1251";


    public WordContainer() {
        this.words = new ArrayList<>();
    }

    public List<Word> getWords() {
         return words.subList(0,words.size());
    }

    public static void main(String[] args) {
        String s;
        WordContainer wc = new WordContainer();
        List<String> arrayList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in, ENCODING))) {
            while ((s = br.readLine()) != null) {
                Pattern pattern = Pattern.compile("\\w+");
                Matcher matcher = pattern.matcher(s);
                while (matcher.find()) {
                    arrayList.add(matcher.group());
                }
            }
            for (String list : arrayList) {
                if ("stop".equals(list)) {
                    break;
                }
                wc.add(list);
            }
            wc.sort();
            System.out.println(wc);
        } catch (IOException e){
            e.printStackTrace();
        }

    }

    public void add(String s) {
        boolean markAdd = true;
        for (Word word : words) {
            if (s.equalsIgnoreCase(word.getContent())) {
                word.incrementFrequency();
                markAdd = false;
            }
        }
        if (markAdd) {
            words.add(new Word(s));
        }
    }


    public void sort() {
        Collections.sort(words);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Object word : words) {
            sb.append(word).append(System.lineSeparator());
        }
        return sb.toString();
    }
}