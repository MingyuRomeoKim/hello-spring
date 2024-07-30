package hello.hello_spring.repositories;

import hello.hello_spring.models.User;

import java.util.List;
import java.util.Optional;

public interface UserRepositoryInterface {
    User save(User user);
    Optional<User> findById(Long id);
    Optional<User> findByName(String name);
    Optional<User> findByEmail(String email);
    List<User> findAll();
}
