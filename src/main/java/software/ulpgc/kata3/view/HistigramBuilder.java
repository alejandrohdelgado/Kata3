package software.ulpgc.kata3.view;

import software.ulpgc.kata3.model.Movie;

import java.util.List;
import java.util.function.Function;

public class HistigramBuilder {
    private final Function<Movie, Integer> binarize;

    public HistigramBuilder(Function<Movie, Integer> binarize) {
        this.binarize = binarize;
    }

    public Histogram buildWith(List<Movie> movies) {
        Histogram histogram = new Histogram();
        for (Movie movie : movies) {
            histogram.add(binOf(movie));
        }
        return histogram;
    }

    private Integer binOf(Movie movie) {
        return binarize.apply(movie);
    }
}
