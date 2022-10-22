/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.Mario.Model;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 *
 * @author mario
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Movie implements Comparable<Movie>{

    public static final DateTimeFormatter DATE_FORMATTER_PUBDATE =  DateTimeFormatter.RFC_1123_DATE_TIME;
    public static final DateTimeFormatter DATE_FORMATTER_BEGINDATE = DateTimeFormatter.ofPattern("d.M.yyyy", Locale.GERMAN);
    

    private int id;
 
    @XmlElement(name = "title")
    private String title;
    @XmlElement(name = "pubDate")
    private String pubDate;
    @XmlElement(name = "description")
    private String description;
    @XmlElement(name = "originNaziv")
    private String originNaziv;
    @XmlElement(name = "genre")
    private Genre genre;
    @XmlElement(name = "duration")
    private int duration;
    @XmlElement(name = "imagePath")
    private String imagePath;
    @XmlJavaTypeAdapter(BeginDateAdapter.class)
    @XmlElement(name = "beginDate")
    private LocalDate beginDate;
     @XmlElementWrapper
     @XmlElement(name = "directors")
    private List<Person> director;
      @XmlElementWrapper
       @XmlElement(name = "actor")
    private List<Person> actors;

  

    public List<Person> getDirector() {
        return director;
    }

    public void setDirectors(List<Person> director) {
        this.director = director;
    }

    public int getId() {
        return id;
    }

    

    public List<Person> getActors() {
        return actors;
    }

    public void setActors(List<Person> actors) {
        this.actors = actors;
    }

    public String getTitle() {
        return title;
    }

    public Movie() {
    }

    public Movie(String title, String pubDate, String description, String originNaziv, Genre genre, int duration, String imagePath, LocalDate beginDate) {
        this.title = title;
        this.pubDate = pubDate;
        this.description = description;
        this.originNaziv = originNaziv;
        this.genre = genre;
        this.duration = duration;
        this.imagePath = imagePath;
        this.beginDate = beginDate;
    }
     
    public Movie(int id,String title,String pubDate, String description, String originNaziv, int duration, String imagePath,LocalDate beginDate) {
        this.id = id;
        this.title = title;
        this.pubDate= pubDate;
        this.description = description;
        this.originNaziv = originNaziv;
        this.duration = duration;
        this.imagePath = imagePath;
        this.beginDate= beginDate;
    }

    public Movie(int id,String title, String pubDate, String description, String originNaziv, Genre genre, int duration, String imagePath, LocalDate beginDate) {
        this(title, pubDate, description, originNaziv, genre, duration, imagePath, beginDate);
        this.id = id;
    }

    public String getOriginNaziv() {
        return originNaziv;
    }

    public void setOriginNaziv(String originNaziv) {
        this.originNaziv = originNaziv;
    }

    public Genre getGenre() {
        return genre;
    }

//    @Override
//    public String toString() {
//        return "Movie{" + "Id=" + Id + ", Title=" + Title + ", PubDate=" + PubDate + ", Description=" + Description + ", OriginNaziv=" + OriginNaziv + ", Genre=" + Genre + ", Duration=" + Duration + ", ImagePath=" + ImagePath + ", Link=" + Link + ", Guid=" + Guid + ", BeginDate=" + BeginDate + ", director=" + director + ", actors=" + actors + '}';
//    }

    @Override
    public String toString() {
        return  title ;
    }



    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public LocalDate getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(LocalDate beginDate) {
        this.beginDate = beginDate;
    }

    @Override
    public int compareTo(Movie o) {
        
        return title.compareTo(o.title);
      }

}
