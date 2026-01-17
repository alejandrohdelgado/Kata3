package software.ulpgc.kata3.viewmodel;

import software.ulpgc.kata3.model.Movie;

import java.util.List;
import java.util.function.Function;

public class HistogramBuilder {
    private final Function<Movie, Integer> binarize;
    public HistogramBuilder(Function<Movie, Integer> binarize) {
        this.binarize = binarize;
    }
    public Histogram build(List<Movie> movieList) {
        Histogram histogram = new Histogram();
        for (Movie movie : movieList){
            histogram.add(binarize.apply(movie));
        }
        return histogram;
    }
}
