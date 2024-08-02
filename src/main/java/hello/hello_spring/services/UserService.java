package hello.hello_spring.services;

import hello.hello_spring.models.Users;
import hello.hello_spring.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * 회원가입
     */
    public Long join(Users users) {
        validateDuplicateUser(users);
        userRepository.save(users);
        return users.getId();
    }

    /**
     * 전체 조회
     */
    public List<Users> findUsers() {
        return userRepository.findAll();
    }

    /**
     * 아이디로 조회
     */
    public Optional<Users> findUserById(Long id) {
        return userRepository.findById(id);
    }

    /**
     * 이메일로 조회
     */
    public Optional<Users> findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    /**
     * 중복 이메일 체크
     */
    private void validateDuplicateUser(Users users) {
        userRepository.findByEmail(users.getEmail())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }
}
