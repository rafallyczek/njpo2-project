package njpo2.project.bookrepo.book;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Book {

    //Pola
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private int id;
    @NotBlank(message="Podanie tytułu jest obowiązkowe.")
    private String title;
    @NotBlank(message = "Podanie autora jest obowiązkowe.")
    private String author;
    @NotBlank(message = "Podanie gatunku jest obowiązkowe.")
    private String genre;
    @NotBlank(message = "Podanie roku wydania jest obowiązkowe.")
    private String release;

    //Konstruktor bezparametrowy
    public Book() {
    }

    //Konstruktor z parametrami
    public Book(String title, String author, String genre, String release) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.release = release;
    }

    //Gettery i Settery
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getRelease() {
        return release;
    }

    public void setRelease(String release) {
        this.release = release;
    }

}
