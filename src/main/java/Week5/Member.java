package Week5;

public class Member {
    private String name;
    private String role;
    private String studentId;
    private String major;

    public Member(String name, String role, String studentId, String major) {
        this.name = name;
        this.role = role;
        this.studentId = studentId;
        this.major = major;
    }

    public String getName() { return name; }
    public String getRole() { return role; }
    public String getStudentId() { return studentId; }
    public String getMajor() { return major; }

    @Override
    public String toString() {
        return "[" + role + "] " + name + " | 학번: " + studentId + " | 전공: " + major;
    }
}