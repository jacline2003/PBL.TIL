package Week2.step3.step1;

public class Lion {

    public String name;        // public: 어디서든 접근 가능
    String major;              // default: 같은 패키지 내에서만 접근 가능
    private int generation;    // private: 클래스 내부에서만 접근 가능

    // 생성자
    public Lion(String name, String major, int generation) {
        this.name = name;
        this.major = major;
        this.generation = generation;
    }

    // ✅ Step2에서 사용할 검증 메서드
    public boolean validate() {
        System.out.println("아기사자 객체의 상태를 확인합니다.");

        if (name == null || name.trim().isEmpty()) {
            System.out.println("❌ 이름이 유효하지 않습니다.");
            return false;
        }
        if (major == null || major.trim().isEmpty()) {
            System.out.println("❌ 전공이 유효하지 않습니다.");
            return false;
        }
        if (generation < 1) {
            System.out.println("❌ 기수는 1 이상이어야 합니다.");
            return false;
        }

        System.out.println("✅ 객체 내부 검증 완료");
        return true;
    }

    // 정보 출력
    public void printInfo() {
        System.out.println("🦁 아기사자 정보");
        System.out.println("이름: " + name);
        System.out.println("전공: " + major);
        System.out.println("기수: " + generation);
    }

    // private 필드 접근용 getter/setter
    public int getGeneration() {
        return generation;
    }

    public void setGeneration(int generation) {
        this.generation = generation;
    }
}

