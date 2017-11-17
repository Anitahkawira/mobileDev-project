package com.thomaskioko.tmdbmovies.adapter;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.thomaskioko.tmdbmovies.MovieDetailActivity;
import com.thomaskioko.tmdbmovies.R;
import com.thomaskioko.tmdbmovies.models.Movie;
import com.thomaskioko.tmdbmovies.models.Result;

import java.util.List;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

/**
 * This class is responsible for styling items in the RecyclerView.
 *
 * @author Thomas Kioko
 */

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MyViewHolder> {

    private Context mContext;
    private List<Result> moviesList;
    private String posterPath = "http://image.tmdb.org/t/p/w500/";

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, year, genre;
        public ImageView posterImageView;
        public View mView;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            genre = (TextView) view.findViewById(R.id.genre);
            year = (TextView) view.findViewById(R.id.year);
            posterImageView = (ImageView) view.findViewById(R.id.image_view_poster);
            mView = view;
        }
    }

    public MoviesAdapter(Context Context, List<Result> moviesList) {
        this.moviesList = moviesList;
        mContext = Context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Result movie = moviesList.get(position);
        holder.title.setText(movie.getTitle());
        holder.genre.setText(movie.getOverview());
        holder.year.setText(movie.getReleaseDate());

//        use glide to load images
        Glide.with(mContext)
                .load(posterPath+movie.getPosterPath())
                .into(holder.posterImageView);

//                Add onClickListener
        holder.mView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View V){
                Intent intent = new Intent(mContext, MovieDetailActivity.class);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }
}
