package Week5;

import java.util.List;

public interface MemberRepository {
    void save(Member member);
    List<Member> findByName(String name);
    List<Member> findAll();
    boolean existsByName(String name);
}