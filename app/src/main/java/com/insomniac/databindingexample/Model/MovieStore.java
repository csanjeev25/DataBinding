package com.insomniac.databindingexample.Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Sanjeev on 1/24/2018.
 */

public class MovieStore {

    private static List<Movie> ALL_MOVIES;

    public static List<Movie> getAllMovies() {
        return ALL_MOVIES;
    }

    static {
        ALL_MOVIES = new ArrayList<>(20);
        ALL_MOVIES
                .add(new Movie().setTitle("Marvel's The Avengers 2: Age of Ultron").setGenre("Action")
                        .setPublishDate(new Date(1430438400000L)).setImageUrl(
                                "https://image.tmdb.org/t/p/original/xkgUhkH2ODT5yy5q6FviW3M2aRB.jpg"));
        ALL_MOVIES.add(new Movie().setTitle("The Amazing Spider-Man").setGenre("Action")
                .setPublishDate(new Date(1341360000000L))
                .setImageUrl("https://image.tmdb.org/t/p/original/dosjP4HDZgUl8vD3qq09cbSF5E2.jpg"));
        ALL_MOVIES.add(new Movie().setTitle("Terminator 2: Judgment Day").setGenre("Action")
                .setPublishDate(new Date(678326400000L))
                .setImageUrl("https://image.tmdb.org/t/p/original/1hSvGqtRgXTjgxIM6OU7ioeKPwz.jpg"));
        ALL_MOVIES.add(new Movie().setTitle("From Dusk Till Dawn").setGenre("Horror")
                .setPublishDate(new Date(821923200000L))
                .setImageUrl("https://image.tmdb.org/t/p/original/iMmtziO0vr4WY2qr598VA7ulaon.jpg"));
        ALL_MOVIES.add(new Movie().setTitle("Shaun the Sheep Movie").setGenre("Family")
                .setPublishDate(new Date(1423180800000L))
                .setImageUrl("https://image.tmdb.org/t/p/original/ibfQa5xTUKHfKbVQIIgu9mDjgkS.jpg"));
    }
}
