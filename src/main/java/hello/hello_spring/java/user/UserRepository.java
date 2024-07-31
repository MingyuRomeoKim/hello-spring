package hello.hello_spring.java.user;

public interface UserRepository {

    void save(User user);

    User findById(Long userId);
}
