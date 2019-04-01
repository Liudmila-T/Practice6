package ua.nure.timoshenko.practice6;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public final class Util {
    private static final String EOL = System.lineSeparator();

    private Util() {
        super();
    }


    public static String readFile(String path, String charSet) {
        StringBuilder result = new StringBuilder();
        String s;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path), charSet))) {
            while ((s = br.readLine()) != null) {
                result.append(s).append(EOL);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.toString();
    }
}
