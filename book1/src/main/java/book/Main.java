package book;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;
import java.util.Arrays;

public class Main {

    private static ApplicationContext applicationContext = null;
    public static void main(String[] args) throws SQLException {
        applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookShopListService bookShopListService = (BookShopListService)applicationContext.getBean("bookShopListService");
        bookShopListService.checkout("小明",Arrays.asList(1,2));
    }
}

