package com.thomaskioko.tmdbmovies.api;

import com.thomaskioko.tmdbmovies.models.MovieResult;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * @author Thomas Kioko
 */

public interface ApiInterface {

//    @GET("/3/movie/550?api_key=df7ab6bd6119f184002f7065000d0fc8")
//    Call<MovieResult> getMovies();

    @GET("/3/movie/popular?api_key=df7ab6bd6119f184002f7065000d0fc8")
    Call<MovieResult> getPopularMovies();

}
