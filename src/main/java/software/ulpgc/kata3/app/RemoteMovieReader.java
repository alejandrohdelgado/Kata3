package software.ulpgc.kata3.app;
import software.ulpgc.kata3.io.MovieReader;
import software.ulpgc.kata3.model.Movie;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.zip.GZIPInputStream;


public class RemoteMovieReader implements MovieReader {
    private final Function<String, Movie> deserialize;


    public RemoteMovieReader(Function<String, Movie> deserialize) {
        this.deserialize = deserialize;
    }

    @Override
    public List<Movie> readAll() {
        try {
            return loadFrom(new URL("https://datasets.imdbws.com/title.basics.tsv.gz"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private List<Movie> loadFrom(URL url) throws IOException {
        return loadFrom(url.openConnection());
    }

    private List<Movie> loadFrom(URLConnection urlConnection) {
        try (InputStream inputStream = unzip(urlConnection.getInputStream())){
            return loadFrom(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private List<Movie> loadFrom(InputStream inputStream) throws IOException {
        return loadFrom(toReader(inputStream));
    }

    private List<Movie> loadFrom(BufferedReader reader) throws IOException {
        List<Movie> movies = new ArrayList<>();
        reader.readLine();
        while(movies.size() < 100000){
            String line = reader.readLine();
            if (line == null) break;
            movies.add(deserialize.apply(line));
        }
        return movies;
    }

    private BufferedReader toReader(InputStream inputStream) {
        return new BufferedReader(new InputStreamReader(inputStream));
    }

    private InputStream unzip(InputStream inputStream) throws IOException {
        return new GZIPInputStream(new BufferedInputStream(inputStream));
    }
}
