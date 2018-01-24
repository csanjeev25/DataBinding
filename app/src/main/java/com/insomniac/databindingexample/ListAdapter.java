package com.insomniac.databindingexample;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.insomniac.databindingexample.Model.Movie;
import com.insomniac.databindingexample.databinding.ListItemBinding;

import java.util.List;

/**
 * Created by Sanjeev on 1/24/2018.
 */

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder>{

    public interface onItemClickListener{
        void onItemClick(final int id, final Movie movie);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private final ListItemBinding mListItemBinding;

        public ViewHolder(ListItemBinding listItemBinding) {
            super(listItemBinding.getRoot());
            mListItemBinding = listItemBinding;
        }
    }

    private List<Movie> mMovieList;
    private onItemClickListener mOnItemClickListener;

    public ListAdapter(List<Movie> movies){
        mMovieList = movies;
    }


    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final ListItemBinding listItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),R.layout.list_item,parent,false);
        return new ViewHolder(listItemBinding);
    }

    @Override
    public void onBindViewHolder(ListAdapter.ViewHolder holder, final int position) {
        holder.mListItemBinding.setMovie(mMovieList.get(position));
        holder.mListItemBinding.setClicklistener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mOnItemClickListener != null)
                    mOnItemClickListener.onItemClick(position,mMovieList.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return mMovieList.size();
    }

    public void setOnItemClickListener(onItemClickListener onItemClickListener){
        this.mOnItemClickListener = onItemClickListener;
    }
}


