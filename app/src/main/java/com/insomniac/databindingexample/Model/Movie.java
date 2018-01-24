package com.insomniac.databindingexample.Model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.insomniac.databindingexample.BR;

import java.util.Date;

/**
 * Created by Sanjeev on 1/24/2018.
 */

public class Movie extends BaseObservable{

    public String genre;
    public String imageUrl;
    public Date publishDate;
    public String title;

    @Bindable
    public String getGenre(){
        return genre;
    }

    public Movie setGenre(String genre){
        this.genre = genre;
        notifyPropertyChanged(BR.genre);
        return this;
    }

    @Bindable
    public String getImageUrl(){
        return imageUrl;
    }

    public Movie setImageUrl(String imageUrl){
        this.imageUrl = imageUrl;
        notifyPropertyChanged(BR.imageUrl);
        return this;
    }

    @Bindable
    public Date getPublishDate(){
        return publishDate;
    }

    public Movie setPublishDate(Date publishDate){
        this.publishDate = publishDate;
        notifyPropertyChanged(BR.publishDate);
        return this;
    }

    @Bindable
    public String getTitle() {
        return title;
    }

    public Movie setTitle(String title) {
        this.title = title;
        notifyPropertyChanged(BR.title);
        return this;
    }
}
