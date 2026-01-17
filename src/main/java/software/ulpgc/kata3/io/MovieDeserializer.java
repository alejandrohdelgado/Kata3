package software.ulpgc.kata3.io;

import software.ulpgc.kata3.model.Movie;

public class MovieDeserializer {
    public static Movie fromTsv(String fileName) {
        return formTsv(fileName.split("\t"));
    }

    private static Movie formTsv(String[] split) {
        return new Movie(split[2], toInt(split[5]), toInt(split[7]));
    }

    private static int toInt(String s) {
        if (s.equals("\\N")) return -1;
        return Integer.parseInt(s);
    }
}
