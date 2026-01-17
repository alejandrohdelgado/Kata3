package software.ulpgc.kata3.app;

import software.ulpgc.kata3.io.MovieDeserializer;
import software.ulpgc.kata3.io.RemoteMovieLoader;
import software.ulpgc.kata3.model.Movie;
import software.ulpgc.kata3.viewmodel.Histogram;
import software.ulpgc.kata3.viewmodel.HistogramBuilder;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Movie> movies = new RemoteMovieLoader(MovieDeserializer::fromTsv).loadAll();
        Histogram histogram = new HistogramBuilder(Movie::year).build(movies);
        for (int bin : histogram) {
            System.out.println(bin + ": " + histogram.count(bin));
        }
    }
}
