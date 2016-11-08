package dmroy.luxoft;

import dmroy.luxoft.dao.FileStatisticDao;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.support.XmlWebApplicationContext;

/**
 *
 * @author Дима
 */
@Controller
public class MainContext {

    public static FileStatisticDao fileStatisticDao;
    BeanFactory factory = null;

    public MainContext() {
        if (factory == null) {
            System.out.println("\n\nMainContext() 234\n\n");
            System.out.println("mainContext.xml = " + MainContext.class.getSimpleName());
//            String path = MainContext.class.getResource("mainContext.xml").toString().substring(6);
//            String path = "src/main/java/dmroy/luxoft/mainContext.xml";
//            String path = "/mainContext.xml";
            String path = "d:/!!!_0/mainContext.xml";
            System.out.println("path = " + path);
            ApplicationContext context = new FileSystemXmlApplicationContext(path);
//            ApplicationContext context = new XmlWebApplicationContext();
            factory = (BeanFactory) context;
            MainContext.fileStatisticDao = (FileStatisticDao) factory.getBean("fileStatisticDao");

        } else {
            System.out.println("BeanFactory factory - NOT NULL");
        }
    }
}
