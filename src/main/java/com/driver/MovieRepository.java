package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class MovieRepository {
    HashMap<String,Movie>movieDb;
    HashMap<String,Director>directorDB;
    HashMap<String, List<String>>directorVsMovieDB;
    List<String>allMovies;

    public MovieRepository() {
        this.movieDb=new HashMap<>();
        this.directorDB=new HashMap<>();
        this.directorVsMovieDB=new HashMap<>();
        this.allMovies=new ArrayList<>();
    }

    public void addMovie(Movie movie){
        String movieName=movie.getName();
        movieDb.put(movieName,movie);
        allMovies.add(movieName);
    }

    public void addDirector(Director director){
        String directorName=director.getName();
        directorDB.put(directorName,director);
        directorVsMovieDB.put(directorName,new ArrayList<>());
    }

    public void addMovieDirectorPair(String movieName,String directorName){
        List<String>noOfMoviesOfDirector=directorVsMovieDB.get(directorName);
        noOfMoviesOfDirector.add(movieName);
    }

    public Movie getMovieByName(String movieName){
       return movieDb.get(movieName);
    }

    public Director getDirectorByName(String directorName){
        return directorDB.get(directorName);
    }

    public List<String> getMoviesByDirectorName(String directorName){
        return directorVsMovieDB.get(directorName);
    }

    public List<String> findAllMovies(){
        return this.allMovies;
    }

    public void deleteDirectorByName(String directorName){
        directorDB.remove(directorName);
        directorVsMovieDB.remove(directorName);
    }

    public void deleteAllDirectors(){
        directorVsMovieDB=new HashMap<>();
        directorDB=new HashMap<>();
    }
}
