package hello.hello_spring.java.user;

import hello.hello_spring.java.AppConfig;

public class UserApp {

    public static void main(String[] args) {

        AppConfig appConfig = new AppConfig();
        UserService userService = appConfig.userService();
        User user = new User(1L,"mingyu1","mingyu1@kimmingyu.co.kr",Grade.VIP);
        userService.join(user);


        User findUser = userService.findUser(1L);
        System.out.println("new user = " + user.toString());
        System.out.println("find user = " + findUser.toString());
    }
}
