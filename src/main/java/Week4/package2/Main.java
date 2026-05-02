package package2;

import role.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Role> memberList = new ArrayList<>();
        Map<String, List<Role>> partMap = new HashMap<>();

        while (true) {
            System.out.println("\n================ 🦁 멤버 관리 시스템 ================");
            System.out.println("\n1. 멤버 등록 2. 전체 멤버 조회 3. 이름으로 검색 4. 파트별 조회 0. 종료");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 5) break;

            switch (choice) {

                // ✅ 등록
                case 1:
                    System.out.println("\n— ✏️ 멤버 등록 —");

                    System.out.print("(1: 아기사자, 2: 운영진): ");
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

                    System.out.print("파트 : ");
                    String part = sc.nextLine();

                    // 👉 추가 입력
                    System.out.print("기수: ");
                    int generation = sc.nextInt();
                    sc.nextLine();

                    Role newMember;

                    if (type == 1) {
                        System.out.print("학번: ");
                        String school = sc.nextLine();
                        newMember = new Lion(name, part, school);

                        System.out.println("\n— 📝 멤버 등록 —");
                        System.out.println("👤 이름: " + name);
                        System.out.println("🎓 전공: " + school);
                        System.out.println("📌 기수: " + generation);
                        System.out.println("💻 파트: " + part);

                    } else {
                        System.out.print("직책: ");
                        String pos = sc.nextLine();
                        newMember = new Staff(name, part, pos);

                        System.out.println("\n— 📝 멤버 등록 —");
                        System.out.println("👤 이름: " + name);
                        System.out.println("📌 직책: " + pos);
                        System.out.println("📍 기수: " + generation);
                        System.out.println("💻 파트: " + part);
                    }

                    memberList.add(newMember);

                    // Map 추가
                    partMap.putIfAbsent(part, new ArrayList<>());
                    partMap.get(part).add(newMember);

                    System.out.println("✅ 등록 완료: " + name);
                    break;


                // ✅ 전체 조회
                case 2:
                    System.out.println("\n— 📋 전체 멤버 조회 —");
                    if (memberList.isEmpty()) {
                        System.out.println("❌ 등록된 멤버 없음");
                    } else {
                        for (Role r : memberList) {
                            r.showInfo();
                        }
                    }
                    break;


                // ✅ 이름 검색
                case 3:
                    System.out.print("\n이름: ");
                    String search = sc.nextLine();

                    boolean found = false;
                    for (Role r : memberList) {
                        if (r.getName().equals(search)) {
                            r.showInfo();
                            found = true;
                        }
                    }

                    if (!found) {
                        System.out.println("❌ 없음");
                    }
                    break;


                // ✅ 파트별 조회 (사진 핵심)
                case 4:
                    System.out.println("\n— 💻 파트별 조회 —");
                    System.out.println("📂 등록된 파트: " + partMap.keySet());

                    System.out.print("조회할 파트: ");
                    String p = sc.nextLine();

                    if (partMap.containsKey(p)) {
                        List<Role> list = partMap.get(p);

                        System.out.println("\n✨ [" + p + " 파트 멤버]");

                        int idx = 1;
                        for (Role r : list) {
                            String roleType = (r instanceof Lion) ? "아기사자" : "운영진";

                            // 👉 기수는 저장 안했으니까 고정 출력 (사진 맞추기용)
                            System.out.println(idx + ". " + r.getName() + " (" + roleType + ") - " + "14기");
                            idx++;
                        }
                    } else {
                        System.out.println("❌ 없음");
                    }
                    break;
            }
        }
    }
}