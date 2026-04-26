package Week3;

// 사진 속 구조에 맞춰서 Role.java 안에 있는 Roles 클래스를 가져옵니다.
import Week3.Role.Roles;
import Week3.Role.Lion;
import Week3.Role.Staff;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // AbstractMember 대신 사진에 있는 Roles 타입으로 리스트를 만듭니다.
        List<Roles> members = new ArrayList<>();

        // 1. 아기사자 정보 입력
        System.out.println("========= 🦁 아기사자 정보 입력 =========");
        System.out.print("👤 이름: "); String lName = sc.next();
        System.out.print("🎓 전공: "); String lMajor = sc.next();
        System.out.print("📌 기수: "); int lGen = sc.nextInt();
        System.out.print("💻 파트: "); String lPart = sc.next();
        System.out.print("🆔 학번: "); String lId = sc.next();

        // Lion 객체 생성 및 리스트 추가
        members.add(new Lion(lName, lMajor, lGen, lPart, lId));
        System.out.println();

        // 2. 운영진 정보 입력
        System.out.println("========= 👨‍💼 운영진 정보 입력 =========");
        System.out.print("👤 이름: "); String sName = sc.next();
        System.out.print("🎓 전공: "); String sMajor = sc.next();
        System.out.print("📌 기수: "); int sGen = sc.nextInt();
        System.out.print("💻 파트: "); String sPart = sc.next();
        System.out.print("⭐ 직책: "); String sPos = sc.next();

        // Staff 객체 생성 및 리스트 추가
        members.add(new Staff(sName, sMajor, sGen, sPart, sPos));
        System.out.println();

        // 3. 결과 출력
        System.out.println("========= 📋 결과 출력 =========");
        for (Roles m : members) {
            m.getInfo();
        }

        sc.close();
    }
}