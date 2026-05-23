package Week5;

import java.util.List;

public class MemberService {
    private final MemberRepository repository;

    public MemberService(MemberRepository repository) {
        this.repository = repository;
    }

    public boolean register(Member member) {
        if (repository.existsByName(member.getName())) {
            return false;
        }
        repository.save(member);
        return true;
    }

    public List<Member> findByName(String name) {
        return repository.findByName(name);
    }

    public List<Member> findAll() {
        return repository.findAll();
    }
}