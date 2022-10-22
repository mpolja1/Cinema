/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.Mario.Dal.Sql;

import hr.Mario.Dall.Repository;
import hr.Mario.Model.Actor;
import hr.Mario.Model.Admin;
import hr.Mario.Model.Director;
import hr.Mario.Model.Genre;
import hr.Mario.Model.Movie;
import hr.Mario.Model.Person;
import hr.Mario.Model.UserApp;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.sql.DataSource;

public class SQLRepository implements Repository {

    //MOVIE
    private static final String ID_MOVIE = "IdMovie";
    private static final String MOVIE_ID = "MovieId";
    private static final String ACTOR_ID = "ActorId";
    private static final String TITLE = "Title";
    private static final String PUB_DATE = "PubDate";
    private static final String DESCRIPTION = "Description";
    private static final String ORIGIN_NAZIV = "OriginNaziv";
    private static final String IMAGE_PATH = "ImagePath";
    private static final String DURATION = "Duration";
    private static final String BEGIN_DATE = "BeginDate";
    private static final String GENRENAME = "GenreName";
    private static final String GENRE_ID = "GenreId";
    private static final String CREATE_MOVIE = "{ CALL CreateMovie (?,?,?,?,?,?,?,?,?)}";
    private static final String GET_MOVIES = "{ CALL getMovies}";
    private static final String GET_MOVIE = "{ CALL getMovie(?)}";
    private static final String DELETE_MOVIE = "{ CALL deleteMovie(?)}";
    private static final String UPDATE_MOVIE = "{ CALL updateMovie(?,?,?,?,?,?,?,?,?)}";
    private static final String INSERT_MOVIE_ACTORS = "{ CALL insertMovieActors(?,?)}";
    private static final String GET_MOVIE_ACTORS = "{ CALL getMovieActors(?)}";

    //DIRECTOR
    private static final String ID_DIRECTOR = "IdDirector";
    private static final String FIRST_NAME = "FirstName";
    private static final String LAST_NAME = "LastName";
    private static final String CREATE_DIRECTOR = "{ CALL createDirector(?,?,?)}";
    private static final String GET_DIRECTORS = "{ CALL getDirectors}";
    private static final String GET_DIRECTOR = "{ CALL getDirector(?)}";
    private static final String DELETE_DIRECTOR = "{ CALL deleteDirector(?)}";
    private static final String UPDATE_DIRECTOR = "{ CALL updateDirector(?,?,?)}";

    //ACTOR
    private static final String ID_ACTOR = "IdActor";
    private static final String FULL_NAME = "FullName";
    private static final String CREATE_ACTOR = "{CALL createActor(?,?,?,?)}";
    private static final String GET_ACTORS = "{CALL getActors}";
    private static final String DELETE_ACTOR = "{CALL deleteActor(?)}";
    private static final String UPDATE_ACTOR = "{CALL updateActor(?,?,?)}";
    private static final String GET_ACTOR = "{CALL getActor(?)}";

    //GENRE
    private static final String ID_GENRE = "Id";
    private static final String NAME_GENRE = "name";
    private static final String GET_GENRES = "{CALL GetGenres}";

    private static final String DELETE_ALL_DATA = "{CALL DeleteAllData}";
    private static final String DELETE_DATA = "{CALL deleteData}";

    //USER
    private static final String USERNAME = "UserName";
    private static final String PASSWORD = "Password";
    private static final String AUTH_ADMIN = "{ CALL AuthAdmin (?,?)}";
    private static final String AUTH_USER = "{ CALL AuthUser (?,?)}";
    private static final String CREATE_USER = "{ CALL createUser (?,?)}";

    @Override
    public Optional<Admin> AuthAdmin(String username, String password) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();

        try (Connection conn = dataSource.getConnection();
                CallableStatement stmt = conn.prepareCall(AUTH_ADMIN)) {

            stmt.setString("@" + USERNAME, username);
            stmt.setString("@" + PASSWORD, password);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {

                    return Optional.of(new Admin(
                            rs.getString(USERNAME),
                            rs.getString(PASSWORD)));
                }
            }

        }
        return Optional.empty();
    }

    @Override
    public int createActor(Person actor) throws Exception {

        DataSource dataSource = DataSourceSingleton.getInstance();

        try (Connection conn = dataSource.getConnection();
                CallableStatement stmt = conn.prepareCall(CREATE_ACTOR)) {
            stmt.setString("@" + FULL_NAME, actor.getFullName());
            stmt.setString("@" + FIRST_NAME, actor.getFirstName());
            stmt.setString("@" + LAST_NAME, actor.getLastName());

            stmt.registerOutParameter("@" + ID_ACTOR, Types.INTEGER);
            stmt.executeUpdate();

            return stmt.getInt("@" + ID_ACTOR);

        }

    }

    @Override
    public void createActors(List<Person> actors) throws Exception {

        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection conn = dataSource.getConnection();
                CallableStatement stmt = conn.prepareCall(CREATE_ACTOR)) {

            for (Person actor : actors) {
                stmt.setString("@" + FULL_NAME, actor.getFullName());
                stmt.setString("@" + FIRST_NAME, actor.getFirstName());
                stmt.setString("@" + LAST_NAME, actor.getLastName());
                stmt.registerOutParameter("@" + ID_ACTOR, Types.INTEGER);

                stmt.executeUpdate();
            }

        }
    }

    @Override
    public void updateActor(int id, Person data) throws Exception {

        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(UPDATE_ACTOR)) {

            stmt.setString("@" + FIRST_NAME, data.getFirstName());
            stmt.setString("@" + LAST_NAME, data.getLastName());

            stmt.setInt("@" + ID_ACTOR, id);
            stmt.executeUpdate();

        }

    }

    @Override
    public void deleteActor(int id) throws Exception {

        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(DELETE_ACTOR)) {

            stmt.setInt("@" + ID_ACTOR, id);

            stmt.executeUpdate();
        }

    }

    @Override
    public List<Person> GetActors() throws Exception {

        List<Person> actors = new ArrayList<>();

        DataSource dataSource = DataSourceSingleton.getInstance();

        try (Connection conn = dataSource.getConnection();
                CallableStatement stmt = conn.prepareCall(GET_ACTORS);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                actors.add(new Person(
                        rs.getInt(ID_ACTOR),
                        rs.getString(FIRST_NAME),
                        rs.getString(LAST_NAME),
                        rs.getString(FULL_NAME)
                ));
            }

        }
        return actors;
    }

    @Override
    public Optional<Person> getActor(int id) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(GET_ACTOR)) {

            stmt.setInt("@" + ID_ACTOR, id);
            try (ResultSet rs = stmt.executeQuery()) {

                if (rs.next()) {
                    return Optional.of(new Actor(
                            rs.getInt(ID_ACTOR),
                            rs.getString(FIRST_NAME),
                            rs.getString(LAST_NAME)
                    ));
                }
            }
        }
        return Optional.empty();

    }

    @Override
    public int createDirector(Person director) throws Exception {

        DataSource dataSource = DataSourceSingleton.getInstance();

        try (Connection conn = dataSource.getConnection();
                CallableStatement stmt = conn.prepareCall(CREATE_DIRECTOR)) {
            stmt.setString("@" + FIRST_NAME, director.getFirstName());
            stmt.setString("@" + LAST_NAME, director.getLastName());

            stmt.registerOutParameter("@" + ID_DIRECTOR, Types.INTEGER);
            stmt.executeUpdate();

            return stmt.getInt("@" + ID_DIRECTOR);

        }

    }

    @Override
    public void createDirectors(List<Person> directors) throws Exception {

        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection conn = dataSource.getConnection();
                CallableStatement stmt = conn.prepareCall(CREATE_DIRECTOR)) {

            for (Person director : directors) {

                stmt.setString("@" + FIRST_NAME, director.getFirstName());
                stmt.setString("@" + LAST_NAME, director.getLastName());
                stmt.registerOutParameter("@" + ID_DIRECTOR, Types.INTEGER);

                stmt.executeUpdate();
            }

        }

    }

    @Override
    public void updateDirector(int id, Person data) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(UPDATE_DIRECTOR)) {

            stmt.setString("@" + FIRST_NAME, data.getFirstName());
            stmt.setString("@" + LAST_NAME, data.getLastName());

            stmt.setInt("@" + ID_DIRECTOR, id);
            stmt.executeUpdate();

        }
    }

    @Override
    public void deleteDirector(int id) throws Exception {

        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(DELETE_DIRECTOR)) {

            stmt.setInt("@" + ID_DIRECTOR, id);

            stmt.executeUpdate();
        }
    }

    @Override
    public Optional<Person> GetDirector(int id) throws Exception {

        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(GET_DIRECTOR)) {

            stmt.setInt("@" + ID_DIRECTOR, id);
            try (ResultSet rs = stmt.executeQuery()) {

                if (rs.next()) {
                    return Optional.of(new Director(
                            rs.getInt(ID_DIRECTOR),
                            rs.getString(FIRST_NAME),
                            rs.getString(LAST_NAME)
                    ));
                }
            }
        }
        return Optional.empty();

    }

    @Override
    public List<Person> GetDirectors() throws Exception {

        List<Person> directors = new ArrayList<>();

        DataSource dataSource = DataSourceSingleton.getInstance();

        try (Connection conn = dataSource.getConnection();
                CallableStatement stmt = conn.prepareCall(GET_DIRECTORS);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                directors.add(new Director(
                        rs.getInt(ID_DIRECTOR),
                        rs.getString(FIRST_NAME),
                        rs.getString(LAST_NAME)
                ));
            }

        }
        return directors;
    }

    @Override
    public int createMovie(Movie movie) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();

        try (Connection conn = dataSource.getConnection();
                CallableStatement stmt = conn.prepareCall(CREATE_MOVIE)) {
            stmt.setString("@" + TITLE, movie.getTitle());
//            stmt.setString("@" + PUB_DATE, movie.getPubDate().format(Movie.DATE_FORMATTER_PUBDATE));
            stmt.setString("@" + PUB_DATE, movie.getPubDate());
            stmt.setString("@" + DESCRIPTION, movie.getDescription());
            stmt.setString("@" + ORIGIN_NAZIV, movie.getOriginNaziv());
            stmt.setString("@" + BEGIN_DATE, movie.getBeginDate().format(Movie.DATE_FORMATTER_BEGINDATE));
            stmt.setString("@" + IMAGE_PATH, movie.getImagePath());
            stmt.setInt("@" + DURATION, movie.getDuration());

//            for (Person mov : movie.getActors()) {
//                if (mov instanceof Actor) {
//                    
//                }
//            }
            stmt.setString("@" + GENRENAME, movie.getGenre().getName());

            stmt.registerOutParameter("@" + ID_MOVIE, Types.INTEGER);
            stmt.executeUpdate();

            return stmt.getInt("@" + ID_MOVIE);

        }
    }

    @Override
    public void createMovies(List<Movie> movies) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection conn = dataSource.getConnection();
                CallableStatement stmt = conn.prepareCall(CREATE_MOVIE)) {

            for (Movie movie : movies) {

                stmt.setString("@" + TITLE, movie.getTitle());
//                stmt.setString("@" + PUB_DATE, movie.getPubDate().format(Movie.DATE_FORMATTER_PUBDATE));
                stmt.setString("@" + PUB_DATE, movie.getPubDate());
                stmt.setString("@" + DESCRIPTION, movie.getDescription());
                stmt.setString("@" + ORIGIN_NAZIV, movie.getOriginNaziv());
                stmt.setString("@" + BEGIN_DATE, movie.getBeginDate().format(Movie.DATE_FORMATTER_BEGINDATE));
                stmt.setString("@" + IMAGE_PATH, movie.getImagePath());
                stmt.setInt("@" + DURATION, movie.getDuration());
                stmt.setString("@" + GENRENAME, movie.getGenre().getName());
                stmt.registerOutParameter("@" + ID_MOVIE, Types.INTEGER);

                stmt.executeUpdate();
            }

        }

    }

    @Override
    public void updateMovie(int id, Movie data) throws Exception {

        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(UPDATE_MOVIE)) {

            stmt.setString("@" + TITLE, data.getTitle());
//            stmt.setString("@" + PUB_DATE, data.getPubDate().format(Movie.DATE_FORMATTER_PUBDATE));
            stmt.setString("@" + PUB_DATE, data.getPubDate());
            stmt.setString("@" + DESCRIPTION, data.getDescription());
            stmt.setString("@" + ORIGIN_NAZIV, data.getOriginNaziv());
            stmt.setString("@" + IMAGE_PATH, data.getImagePath());
            stmt.setInt("@" + DURATION, data.getDuration());
            stmt.setString("@" + BEGIN_DATE, data.getBeginDate().format(Movie.DATE_FORMATTER_BEGINDATE));
            stmt.setInt("@" + GENRE_ID, data.getGenre().getId());

            stmt.setInt("@" + ID_MOVIE, id);
            stmt.executeUpdate();

        }

    }

    @Override
    public void deleteMovie(int id) throws Exception {

        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(DELETE_MOVIE)) {

            stmt.setInt("@" + ID_MOVIE, id);

            stmt.executeUpdate();
        }
    }

    @Override
    public List<Movie> GetMovies() throws Exception {
        List<Movie> movies = new ArrayList<>();
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(GET_MOVIES);
                ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Genre genre = new Genre(rs.getString(GENRENAME));
                movies.add(new Movie(
                        rs.getInt(ID_MOVIE),
                        rs.getString(TITLE),
                        //                        LocalDateTime.parse(rs.getString(PUB_DATE), Movie.DATE_FORMATTER_PUBDATE),
                        rs.getString(PUB_DATE),
                        rs.getString(DESCRIPTION),
                        rs.getString(ORIGIN_NAZIV),
                       genre,
                        rs.getInt(DURATION),
                        rs.getString(IMAGE_PATH),
                        LocalDate.parse(rs.getString(BEGIN_DATE), Movie.DATE_FORMATTER_BEGINDATE)));
            }
        }
        return movies;
    }

    @Override
    public Optional<Movie> getMovie(int IdMovie) throws Exception {

        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(GET_MOVIE)) {

            stmt.setInt("@" + ID_MOVIE, IdMovie);
            try (ResultSet rs = stmt.executeQuery()) {
//int id,String title, String description, String originNaziv, int duration, String imagePath,LocalDate beginDate
                if (rs.next()) {
                    return Optional.of(new Movie(
                            rs.getInt(ID_MOVIE),
                            rs.getString(TITLE),
//                                                        LocalDateTime.parse(rs.getString(PUB_DATE), Movie.DATE_FORMATTER_PUBDATE),
                            rs.getString(PUB_DATE),
                            rs.getString(DESCRIPTION),
                            rs.getString(ORIGIN_NAZIV),
                            rs.getInt(DURATION),
                            rs.getString(IMAGE_PATH),
                            LocalDate.parse(rs.getString(BEGIN_DATE), Movie.DATE_FORMATTER_BEGINDATE)));

                }
            }
        }
        return Optional.empty();

    }

    @Override
    public List<Genre> GetGenres() throws Exception {
        List<Genre> genres = new ArrayList<>();
        DataSource dataSource = DataSourceSingleton.getInstance();

        try (Connection conn = dataSource.getConnection();
                CallableStatement stmt = conn.prepareCall(GET_GENRES);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                genres.add(new Genre(
                        rs.getInt(ID_GENRE),
                        rs.getString(NAME_GENRE)
                ));
            }

        }

        return genres;

    }

    @Override
    public int DeleteAllData() throws Exception {

        DataSource dataSource = DataSourceSingleton.getInstance();

        try (Connection conn = dataSource.getConnection();
                CallableStatement stmt = conn.prepareCall(DELETE_ALL_DATA)) {

            try (ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {

                }
            }
        }
        return 0;
    }

    @Override
    public void insertMovieActors(int MovieId, int ActorId) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();

        try (Connection conn = dataSource.getConnection();
                CallableStatement stmt = conn.prepareCall(INSERT_MOVIE_ACTORS)) {

            stmt.setInt("@" + MOVIE_ID, MovieId);
            stmt.setInt("@" + ACTOR_ID, ActorId);

            stmt.executeUpdate();

        }
    }

    @Override
    public List<Person> GetMovieActors(int MovieId) throws Exception {

        DataSource dataSource = DataSourceSingleton.getInstance();

        List<Person> actors = new ArrayList<>();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(GET_MOVIE_ACTORS)) {

            stmt.setInt("@" + MOVIE_ID, MovieId);
            try (ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {
                    actors.add(new Person(
                            rs.getInt(ID_ACTOR),
                            rs.getString(FIRST_NAME),
                            rs.getString(LAST_NAME),
                            rs.getString(FULL_NAME)));

                }
            }
        }
        return actors;

    }

    @Override
    public Optional<UserApp> AuthUser(String username, String password) throws Exception {

        DataSource dataSource = DataSourceSingleton.getInstance();

        try (Connection conn = dataSource.getConnection();
                CallableStatement stmt = conn.prepareCall(AUTH_USER)) {

            stmt.setString("@" + USERNAME, username);
            stmt.setString("@" + PASSWORD, password);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {

                    return Optional.of(new UserApp(
                            rs.getString(USERNAME),
                            rs.getString(PASSWORD)));
                }
            }

        }
        return Optional.empty();

    }

    @Override
    public void createUser(String username, String password) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();

        try (Connection conn = dataSource.getConnection();
                CallableStatement stmt = conn.prepareCall(CREATE_USER)) {
            stmt.setString("@" + USERNAME, username);
            stmt.setString("@" + PASSWORD, password);

            stmt.executeUpdate();

        }

    }

    @Override
    public void DeleteData() throws Exception {

        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(DELETE_DATA)) {
            stmt.executeUpdate();
        }

    }

}
