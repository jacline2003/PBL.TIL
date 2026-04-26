package Week2.step3.step1;

import java.util.Scanner;

public class Step2Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("아기사자의 이름을 입력해주세요: ");
        String name = sc.nextLine();

        System.out.print("전공을 입력해주세요: ");
        String major = sc.nextLine();

        System.out.print("기수를 입력해주세요: ");
        int gen = sc.nextInt();

        // ✅ 일단 객체 생성
        System.out.println("아기사자 객체가 자신의 상태를 정상으로 판단했습니다.");
        Lion lion = new Lion(name, major, gen);
        // ✅ 객체 내부에서 검증
        if (!lion.validate()) {
            System.out.println("객체 검증을 실패했습니다");
            return;
        }

        sc.close();
    }
}