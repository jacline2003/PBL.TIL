package Week3.Role;

import Week3.Policy.Policy;

public abstract class Roles {
    private String name;
    private String major;
    private int gen;
    private String part;

    public Roles(String name, String major, int gen, String part) {
        this.name = name;
        this.major = major;
        this.gen = gen;
        this.part = part;
    }

    // getter
    public String getName() { return name; }
    public String getMajor() { return major; }
    public int getGen() { return gen; }
    public String getPart() { return part; }

    // 🔥 정책 반환
    protected abstract Policy getPolicy();

    // 🔥 위임
    public boolean canSubmit() {
        return getPolicy().canSubmit();
    }

    public abstract String getInfo();
}