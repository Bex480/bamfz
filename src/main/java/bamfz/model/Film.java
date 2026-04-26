package bamfz.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "films")
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String genre;

    protected Film (){}

    public Film(String title, String genre){
        this.title = title;
        this.genre = genre;
    }

    public Long getId(){
        return this.id;
    }
    public String getTitle(){
        return this.title;
    }
    public String getGenre(){
        return this.genre;
    }

    public void setTitle(String title){
        this.title = title;
    }
    public void setGenre(String genre){
        this.genre = genre;
    }

}
