package hr.Mario.Dall;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import hr.Mario.Model.Admin;
import hr.Mario.Model.Genre;
import hr.Mario.Model.Movie;
import hr.Mario.Model.Person;
import hr.Mario.Model.UserApp;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author mario
 */
public interface Repository {
    
    Optional<Admin> AuthAdmin(String username, String password) throws Exception;
    Optional<UserApp> AuthUser(String username, String password) throws Exception;
    void createUser(String username, String password) throws Exception;
  
    int createActor(Person actor) throws Exception;
    void createActors(List<Person> actors) throws Exception;
    void updateActor(int id,Person actordata) throws Exception;
    void deleteActor(int id)throws Exception;
    List<Person> GetActors()throws Exception;
    Optional<Person> getActor(int id) throws Exception;
    
    List<Genre> GetGenres() throws Exception;
    
    int DeleteAllData()throws Exception;
    void DeleteData()throws Exception;
    
    int createDirector(Person director) throws Exception;
    void createDirectors(List<Person> director) throws Exception;
    void updateDirector(int id,Person directordata) throws Exception;
    void deleteDirector(int id)throws Exception;
    List<Person> GetDirectors()throws Exception;
    Optional<Person> GetDirector(int id)throws Exception;
    
    int createMovie(Movie movie) throws Exception;
    void createMovies(List<Movie> movies) throws Exception;
    void updateMovie(int id,Movie data) throws Exception;
    void deleteMovie(int id)throws Exception;
    Optional<Movie> getMovie(int idMovie) throws Exception;
    List<Movie> GetMovies()throws Exception;
    List<Person> GetMovieActors(int movieId) throws Exception;
    
    void insertMovieActors(int movieId, int actorId)throws Exception;
    
}
