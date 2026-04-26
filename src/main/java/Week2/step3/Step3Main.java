package Week2.step3;

import Week2.step3.step1.Lion;

public class Step3Main {

    public static void main(String[] args) {

        Lion lion = new Lion("김민지", "환경학과", 14);

        // ✅ public → 접근 가능
        lion.name = "김사자";
        System.out.println("name 필드 값을 변경합니다.");

        // ❌ default → 다른 패키지라 접근 불가 (컴파일 에러)
        // lion.major = "전자공학";

        // ❌ private → 접근 불가 (컴파일 에러)
        // lion.generation = 20;

        // ✅ private은 setter로 접근
        lion.setGeneration(20);
        System.out.println("generation 변경 성공");

        lion.printInfo();
    }
}