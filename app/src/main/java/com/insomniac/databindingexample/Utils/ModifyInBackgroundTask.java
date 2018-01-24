package com.insomniac.databindingexample.Utils;

import android.os.AsyncTask;

import com.insomniac.databindingexample.Model.Movie;

/**
 * Created by Sanjeev on 1/24/2018.
 */

public class ModifyInBackgroundTask extends AsyncTask<Movie,Void,Void>{
    @Override
    protected Void doInBackground(Movie... Movies) {
        for(Movie movie : Movies){
            movie.setTitle(movie.getTitle() + " modified");
        }
        return null;
    }
}
