package hello.hello_spring.repositories;

import hello.hello_spring.models.User;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

public class UserRepositoryJpa implements UserRepositoryInterface {

    private final EntityManager entityManager;

    public UserRepositoryJpa(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public User save(User user) {
        entityManager.persist(user);
        return user;
    }

    @Override
    public Optional<User> findById(Long id) {
        User user = entityManager.find(User.class,id);
        return Optional.ofNullable(user);
    }

    @Override
    public Optional<User> findByName(String name) {
        return entityManager.createQuery("select m from User m where m.name = :name", User.class)
                .setParameter("name", name)
                .getResultList()
                .stream()
                .findAny();
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return entityManager.createQuery("select m from User m where m.email = :email", User.class)
                .setParameter("email", email)
                .getResultList()
                .stream()
                .findAny();
    }

    @Override
    public List<User> findAll() {
        return entityManager.createQuery("select m from User m", User.class).getResultList();
    }
}
