package hello.hello_spring.java.user;

import hello.hello_spring.java.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UserApp {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = applicationContext.getBean("userService", UserService.class);

        User user = new User(1L,"mingyu1","mingyu1@kimmingyu.co.kr",Grade.VIP);
        userService.join(user);


        User findUser = userService.findUser(1L);
        System.out.println("new user = " + user.toString());
        System.out.println("find user = " + findUser.toString());
    }
}
