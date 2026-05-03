package Week3.Role;

import Week3.Policy.Policy;
import Week3.Policy.StaffPolicy;

public class Staff extends Roles {
    private String position;

    public Staff(String name, String major, int gen, String part, String position) {
        super(name, major, gen, part);
        this.position = position;
    }

    @Override
    protected Policy getPolicy() {
        return new StaffPolicy();
    }

    @Override
    public String getInfo() {
        return "🛠️ 운영진\n" +
                "이름: " + getName() + "\n" +
                "전공: " + getMajor() + "\n" +
                "기수: " + getGen() + "\n" +
                "파트: " + getPart() + "\n" +
                "직책: " + position;
    }
}