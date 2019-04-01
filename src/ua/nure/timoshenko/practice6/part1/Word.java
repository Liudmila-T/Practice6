package ua.nure.timoshenko.practice6.part1;

import java.util.Objects;

public class Word implements Comparable<Word> {
    private String content;
    private int frequency;

    public Word(String content) {
        this.content = content;
        this.frequency = 1;
    }

    public int getFrequency() {
        return frequency;
    }

    public String getContent() {
        return content;
    }

    public void incrementFrequency() {
        frequency++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Word word1 = (Word) o;
        return frequency == word1.frequency &&
                Objects.equals(content, word1.content);
    }

    @Override
    public int hashCode() {

        return Objects.hash(content, frequency);
    }

    @Override
    public String toString() {
        return content + " : " + frequency;
    }


    @Override
    public int compareTo(Word o) {
        int fr = o.frequency - this.frequency;
        if (fr == 0) {
            return content.compareToIgnoreCase(o.getContent());
        }
        return fr;
    }

}
