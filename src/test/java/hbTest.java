/**
 * @author kin
 * @version $: v 0.1 2016/10/26 Exp $$
 */

import com.zipon.test.Common;

public class hbTest {

        public static void main(String[] args){
           /* User s = new User();
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
            sf.close();*/
            Common.readValueFromProperties("F:\\2project\\automationTest\\src\\datasourceTest.properties","aaa");
            Common.readProperties("F:\\2project\\automationTest\\src\\datasourceTest.properties");
        }
    }

