package software.ulpgc.kata3.app;

import software.ulpgc.kata3.model.Movie;
import software.ulpgc.kata3.view.HistigramBuilder;
import software.ulpgc.kata3.view.Histogram;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Movie> movies = new RemoteMovieReader(MovieDeserializer::fromTsv).readAll();
        Histogram histogram = new HistigramBuilder(movie -> (movie.year()/10)*10).buildWith(movies);
        for (int bin: histogram){
            System.out.println(bin + ": " + histogram.count(bin));
        }
    }
}
