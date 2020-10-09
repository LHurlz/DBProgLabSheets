import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class BasicHobbyManager {
    private SessionFactory sessionFactory = null;
    // Creating SessionFactory using 4.2 version of Hibernate
    public void initSessionFactory(){
        if (sessionFactory == null) {
            // loads configuration and mappings
            Configuration configuration = new Configuration().configure();
            // builds a session factory from the service registry
            sessionFactory = configuration.buildSessionFactory();
        }
    }
    public void persistHobby(Hobby hobby) {
        Transaction tx = null;
        Session session = sessionFactory.getCurrentSession();
        try {
            tx = session.beginTransaction();
            session.save(hobby);
            tx.commit();
        }
        catch(HibernateException ex) {
            if (tx != null) tx.rollback();
            throw ex;
        }
        finally{
            session.close();
        }
    }

    public void findHobby(int hobbyId){
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Hobby hobby = (Hobby)session.load(Hobby.class, hobbyId);
        System.out.println("Hobby:" + hobby.getName());
        session.getTransaction().commit();

    }

    private void findAll(){
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<Hobby> hobbies = session.createQuery("from Hobby").list();
        session.getTransaction().commit();
        for(int i=0; i<hobbies.size(); i++)
            System.out.println(hobbies.get(i).getName());
    }

    public static void main(String[] args){
        BasicHobbyManager manager = new BasicHobbyManager();
        manager.initSessionFactory();

        Hobby hobby = new Hobby();
        hobby.setId(3);
        hobby.setName("Shitposting");
        System.out.println(manager);

        //manager.persistHobby(hobby);
        //manager.findHobby(2);
        manager.findAll();
    }

}
