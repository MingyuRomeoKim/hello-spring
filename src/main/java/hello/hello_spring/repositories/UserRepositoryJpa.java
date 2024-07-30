package hello.hello_spring.repositories;

import hello.hello_spring.models.User;

import java.util.List;
import java.util.Optional;

public class UserRepositoryJpa implements UserRepositoryInterface{
    @Override
    public User save(User member) {
        return null;
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<User> findByName(String name) {
        return Optional.empty();
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return Optional.empty();
    }

    @Override
    public List<User> findAll() {
        return null;
    }
}
