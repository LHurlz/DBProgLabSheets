/**
 * Created by t00036478 on 08/02/2018.
 */
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class BasicMovieManager {

    private SessionFactory factory = null;

    private void init() {
        Configuration config = new Configuration().configure();
        config.addAnnotatedClass(Movie.class);
        factory = config.buildSessionFactory();
    }

    private void persist() {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        Movie movie = new Movie("TheMaster","sex","Roman Polanski");

        session.save(movie);

        session.getTransaction().commit();
        System.out.println("Done");
    }


    public static void main(String[] args) {
        BasicMovieManager p = new BasicMovieManager();
        p.init();
        p.persist();
    }
}




