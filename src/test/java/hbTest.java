/**
 * @author kin
 * @version $: v 0.1 2016/10/26 Exp $$
 */

    import com.hibernate.model.User;
    import org.hibernate.Session;
    import org.hibernate.SessionFactory;
    import org.hibernate.cfg.Configuration;

    public class hbTest {

        public static void main(String[] args){
            User s = new User();
            s.setId(2);
            s.setNickname("lll");
            s.setLastname("chen");
            s.setFirstname("li");

            Configuration cfg = new Configuration();
            SessionFactory sf = cfg.configure().buildSessionFactory();

            Session session = sf.openSession();
            session.beginTransaction();
            session.save(s);
            session.getTransaction().commit();
            session.close();
            sf.close();
        }
    }

