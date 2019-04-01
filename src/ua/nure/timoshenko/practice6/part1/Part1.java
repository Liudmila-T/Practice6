package ua.nure.timoshenko.practice6.part1;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;


public class Part1 {
    private static final InputStream STD_IN = System.in;
    private static final String ENCODING = "Cp1251";

    public static void main(String[] args) throws UnsupportedEncodingException {
        System.setIn(new ByteArrayInputStream("Du du^hast^mich^Du^hast^mich^Du^hast^mich stop^gefragt".
                replace("^", System.lineSeparator()).getBytes(ENCODING)));

        WordContainer.main(args);
        System.setIn(STD_IN);


    }
}
