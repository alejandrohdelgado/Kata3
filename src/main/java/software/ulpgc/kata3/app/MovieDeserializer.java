package software.ulpgc.kata3.app;

import software.ulpgc.kata3.model.Movie;

public class MovieDeserializer {

    static Movie fromTsv(String line) {
        return fromTsv(line.split("\t"));
    }

    private static Movie fromTsv(String[] split) {
        return new Movie(split[2], toInteger(split[5]), toInteger(split[7]));
    }

    private static int toInteger(String s) {
        if (s.equals("\\N")) return 0;
        return Integer.parseInt(s);
    }
}
