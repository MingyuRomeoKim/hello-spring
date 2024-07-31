package hello.hello_spring.java.user;

public interface UserService {

    void join(User user);

    User findUser(Long userId);
}
