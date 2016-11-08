package dmroy.luxoft;

import dmroy.luxoft.dao.FileStatisticDao;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

/**
 *
 * @author dmitriyroy
 */
@Controller
public class MainContext {

    public static FileStatisticDao fileStatisticDao;
    BeanFactory factory = null;

    public MainContext() {
        if (factory == null) {
//            ApplicationContext context = new FileSystemXmlApplicationContext(path);
            ApplicationContext context = new ClassPathXmlApplicationContext("mainContext.xml");
            factory = (BeanFactory) context;
            MainContext.fileStatisticDao = (FileStatisticDao) factory.getBean("fileStatisticDao");

        } else {
            System.out.println("BeanFactory factory - NOT NULL");
        }
    }
}
