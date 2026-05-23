package Week3.Role;

import Week3.Policy.LionPolicy;
import Week3.Policy.Policy;

public class Lion extends Roles {
    private String studentId;

    public Lion(String name, String major, int gen, String part, String studentId) {
        super(name, major, gen, part);
        this.studentId = studentId;
    }

    @Override
    protected Policy getPolicy() {
        return new LionPolicy();
    }

    @Override
    public String getInfo() {
        return "🦁 아기사자\n" +
                "이름: " + getName() + "\n" +
                "전공: " + getMajor() + "\n" +
                "기수: " + getGen() + "\n" +
                "파트: " + getPart() + "\n" +
                "학번: " + studentId;
    }
}