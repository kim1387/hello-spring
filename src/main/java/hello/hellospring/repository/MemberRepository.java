package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    Member save(Member menber);
    Optional<Member> findByID(Long id);
    Optional<Member> findByName(String name);
    List<Member> findall();

}
