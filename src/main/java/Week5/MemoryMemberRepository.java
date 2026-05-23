package Week5;

import java.util.ArrayList;
import java.util.List;

public class MemoryMemberRepository implements MemberRepository {
    private List<Member> store = new ArrayList<>();

    @Override
    public void save(Member member) {
        store.add(member);
    }

    @Override
    public List<Member> findByName(String name) {
        List<Member> result = new ArrayList<>();
        for (Member m : store) {
            if (m.getName().equals(name)) {
                result.add(m);
            }
        }
        return result;
    }

    @Override
    public List<Member> findAll() {
        return store;
    }

    @Override
    public boolean existsByName(String name) {
        for (Member m : store) {
            if (m.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }
}