package com.insomniac.databindingexample;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.insomniac.databindingexample.Model.Movie;
import com.insomniac.databindingexample.Model.MovieStore;
import com.insomniac.databindingexample.Utils.DateUtils;
import com.insomniac.databindingexample.databinding.ActivityDetailBinding;

public class DetailActivity extends AppCompatActivity {

    private static final String EXTRA_MOVIE_ID = "EXTRA_MOVIE_ID";
    private ActivityDetailBinding mActivityDetailBinding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        mActivityDetailBinding = DataBindingUtil.setContentView(this,R.layout.activity_detail);
        setContentView(R.layout.activity_detail);
        Toast.makeText(getApplicationContext(),"detail",Toast.LENGTH_SHORT).show();
        final int movieId = getIntent().getIntExtra(EXTRA_MOVIE_ID,0);
        final Movie movie = MovieStore.getAllMovies().get(movieId);
        mActivityDetailBinding.setMovie(movie);
        mActivityDetailBinding.saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = mActivityDetailBinding.title.getText().toString();
                String genre = mActivityDetailBinding.genre.getText().toString();
                String publicationDateString = mActivityDetailBinding.publicationDate.getText().toString();
                movie.setTitle(title);
                movie.setGenre(genre);
                movie.setPublishDate(DateUtils.parseDate(publicationDateString));
                finish();
            }
        });
    }
}
