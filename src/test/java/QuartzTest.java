
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Created by zipon on 2016/11/6.
 */
public class QuartzTest {
    /**
     * @param args
     */
    public static void main(String[] args)
    {
        System.out.println("Test start.");
        //String currentUrl= getClass().getResource("/").getFile().toString();
        ApplicationContext context = new FileSystemXmlApplicationContext("src\\quartz-config.xml");
        //如果配置文件中将startQuertz bean的lazy-init设置为false 则不用实例化
        //context.getBean("startQuertz");
        System.out.print("Test end..");


    }
}
