package Week5;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 저장소 선택
        System.out.println("🔧 저장소를 선택하세요:");
        System.out.println("1. MemoryMemberRepository (실제 저장)");
        System.out.println("2. MockMemberRepository (더미 데이터)");
        System.out.print("선택: ");

        int repoChoice = scanner.nextInt();
        scanner.nextLine();

        MemberRepository repository;
        if (repoChoice == 1) {
            repository = new MemoryMemberRepository();
        } else {
            repository = new MockMemberRepository();
        }

        MemberService service = new MemberService(repository);

        while (true) {
            System.out.println("\n🦁 ===== 멋사 멤버 관리 시스템 (Step 2: DI 적용) ===== 🦁");
            System.out.println("1. ➕ 멤버 등록");
            System.out.println("2. 📋 전체 멤버 조회");
            System.out.println("3. 🔍 이름으로 검색");
            System.out.println("4. 🚪 종료");
            System.out.print("선택: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.println("역할 선택: 1. 아기사자  2. 운영진");
                int roleChoice = scanner.nextInt();
                scanner.nextLine();
                String role = (roleChoice == 1) ? "아기사자" : "운영진";

                System.out.print("이름: ");
                String name = scanner.nextLine();
                System.out.print("학번: ");
                String studentId = scanner.nextLine();
                System.out.print("전공: ");
                String major = scanner.nextLine();

                Member member = new Member(name, role, studentId, major);
                boolean success = service.register(member);

                if (success) {
                    System.out.println("✅ 등록 완료: " + member);
                } else {
                    System.out.println("❌ 등록 실패: 이미 존재하는 이름입니다.");
                }

            } else if (choice == 2) {
                List<Member> members = service.findAll();
                if (members.isEmpty()) {
                    System.out.println("등록된 멤버가 없습니다.");
                } else {
                    System.out.println("=== 전체 멤버 ===");
                    for (Member m : members) {
                        System.out.println(m);
                    }
                }

            } else if (choice == 3) {
                System.out.print("검색할 이름: ");
                String name = scanner.nextLine();
                List<Member> result = service.findByName(name);
                if (result.isEmpty()) {
                    System.out.println("해당 이름의 멤버가 없습니다.");
                } else {
                    for (Member m : result) {
                        System.out.println(m);
                    }
                }

            } else if (choice == 4) {
                System.out.println("종료합니다.");
                break;
            }
        }
    }
}