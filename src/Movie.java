/**
 * Created by t00036478 on 02/02/2018.
 */
import javax.persistence.*;

@Entity
public class Movie {
    @Id
    @Column(name="ID", nullable=false, unique=true)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="movSeqGen")
    @SequenceGenerator(name = "movSeqGen", sequenceName = "MovieSequence", allocationSize = 1, initialValue= 1)
    private int id;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    private String title=null;
    private String synopsis=null;
    private String director=null;

    public Movie(){
    }

    public Movie(String title, String synopsis, String director){
        setTitle(title);
        setSynopsis(synopsis);
        setDirector(director);
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }
    public void setDirector(String director) {
        this.director = director;
    }
    public String getDirector() {
        return director;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }
    public String getSynopsis() {
        return synopsis;
    }
}