package com.insomniac.databindingexample;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.insomniac.databindingexample.Model.Movie;
import com.insomniac.databindingexample.Model.MovieStore;
import com.insomniac.databindingexample.Utils.ModifyInBackgroundTask;
import com.insomniac.databindingexample.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mActivityMainBinding;
    private static final String EXTRA_MOVIE_ID = "EXTRA_MOVIE_ID";

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.action_modify){
            new ModifyInBackgroundTask().execute(MovieStore.getAllMovies().toArray(new Movie[0]));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        initRecyclerView();
    }

    public void initRecyclerView(){
        final RecyclerView list = mActivityMainBinding.list;
        list.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        final ListAdapter listAdapter = new ListAdapter(MovieStore.getAllMovies());
        listAdapter.setOnItemClickListener(new ListAdapter.onItemClickListener() {
            @Override
            public void onItemClick(int id, Movie movie) {
                Intent intent = new Intent(getApplicationContext(),DetailActivity.class);
                intent.putExtra(EXTRA_MOVIE_ID,id);
                startActivity(intent);
            }
        });
        list.setAdapter(listAdapter);
    }
}
