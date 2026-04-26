package Week2.step3.step1;

import java.util.Scanner;

public class Step1Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("아기사자의 이름을 입력해주세요: ");
        String name = sc.nextLine();

        System.out.print("전공을 입력해주세요: ");
        String major = sc.nextLine();

        System.out.print("기수를 입력해주세요: ");
        int gen = Integer.parseInt(sc.nextLine());

        // ✅ main에서 검증
        if (name.trim().isEmpty() || major.trim().isEmpty() || gen < 1) {
            System.out.println("입력값이 유효하지 않습니다.");
            System.out.println(" 객체 생성 실패");
            return;
        }

        System.out.println("입력값 검증을 통과하여 객체를 생성하였습니다");

        Lion lion = new Lion(name, major, gen);
        lion.printInfo();
    }
}