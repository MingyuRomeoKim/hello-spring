package hello.hello_spring.java.user;

public class UserApp {

    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        User user = new User(1L,"mingyu1","mingyu1@kimmingyu.co.kr",Grade.VIP);
        userService.join(user);


        User findUser = userService.findUser(1L);
        System.out.println("new user = " + user.toString());
        System.out.println("find user = " + findUser.toString());
    }
}
