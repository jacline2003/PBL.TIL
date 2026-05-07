package Week5;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class MockMemberRepository implements MemberRepository {
    private List<Member> dummyData = Arrays.asList(
            new Member("홍길동", "아기사자", "20210001", "컴퓨터공학"),
            new Member("김철수", "운영진", "20190002", "소프트웨어학"),
            new Member("이영희", "아기사자", "20220003", "정보통신학")
    );

    @Override
    public void save(Member member) {
        System.out.println("[Mock] save() 호출됨 - 실제 저장하지 않음");
    }

    @Override
    public List<Member> findByName(String name) {
        List<Member> result = new ArrayList<>();
        for (Member m : dummyData) {
            if (m.getName().equals(name)) result.add(m);
        }
        return result;
    }

    @Override
    public List<Member> findAll() {
        return dummyData;
    }

    @Override
    public boolean existsByName(String name) {
        for (Member m : dummyData) {
            if (m.getName().equals(name)) return true;
        }
        return false;
    }
}