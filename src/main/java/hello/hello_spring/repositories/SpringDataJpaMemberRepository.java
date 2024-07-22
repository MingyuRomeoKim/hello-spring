package hello.hello_spring.repositories;

import hello.hello_spring.domains.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member,Long> , MemberRepository {

    @Override
    Optional<Member> findByName(String name);
}
