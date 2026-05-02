package Week4.package1;

import role.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Role> memberList = new ArrayList<>();

        while (true) {
            System.out.println("\n1. 등록 2. 전체조회 3. 이름으로 검색 0. 종료");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 0) break;

            switch (choice) {
                case 1:
                    System.out.println("\n— ✏️ 멤버 등록 —");

                    System.out.print("1: 아기사자, 2: 운영진: ");
                    int type = sc.nextInt();
                    sc.nextLine();

                    System.out.print("이름: ");
                    String name = sc.nextLine();

                    // 중복 검사
                    boolean exists = false;
                    for (Role r : memberList) {
                        if (r.getName().equals(name)) {
                            exists = true;
                        }
                    }

                    if (exists) {
                        System.out.println("❌ 중복!");
                        break;
                    }

                    System.out.print("파트: ");
                    String part = sc.nextLine();

                    // 👉 추가된 부분
                    System.out.print("기수: ");
                    int generation = sc.nextInt();
                    sc.nextLine();

                    System.out.print("학번: ");
                    String studentId = sc.nextLine();

                    if (type == 1) {
                        System.out.print("전공: ");
                        String school = sc.nextLine();
                        memberList.add(new Lion(name, part, school));

                        // 👉 출력 꾸미기
                        System.out.println("\n— 📝 멤버 등록 —");
                        System.out.println("👤 이름: " + name);
                        System.out.println("🎓 전공: " + school);
                        System.out.println("📌 기수: " + generation);
                        System.out.println("💻 파트: " + part);
                        System.out.println("🆔 학번: " + studentId);
                    } else {
                        System.out.print("직책: ");
                        String pos = sc.nextLine();
                        memberList.add(new Staff(name, part, pos));

                        // 👉 출력 꾸미기
                        System.out.println("\n— 📝 멤버 등록 —");
                        System.out.println("👤 이름: " + name);
                        System.out.println("📌 직책: " + pos);
                        System.out.println("📍 기수: " + generation);
                        System.out.println("💻 파트: " + part);
                        System.out.println("🆔 학번: " + studentId);
                    }

                    System.out.println("✅ 등록 완료: " + name);
                    break;

                case 2:
                    for (Role r : memberList) {
                        r.showInfo();
                    }
                    break;

                case 3:
                    System.out.print("이름: ");
                    String search = sc.nextLine();

                    for (Role r : memberList) {
                        if (r.getName().equals(search)) {
                            r.showInfo();
                        }
                    }
                    break;
            }
        }
    }
}