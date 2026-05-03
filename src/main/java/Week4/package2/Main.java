package package2;

import Week3.Role.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Roles> memberList = new ArrayList<>();
        Map<String, List<Roles>> partMap = new HashMap<>();

        while (true) {
            System.out.println("\n================ 🦁 멤버 관리 시스템 ================");
            System.out.println("1. 멤버 등록");
            System.out.println("2. 전체 멤버 조회");
            System.out.println("3. 이름으로 검색");
            System.out.println("4. 파트별 조회");
            System.out.println("5. 종료");
            System.out.print("선택: ");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 5) break;

            switch (choice) {
                case 1:
                    System.out.println("\n멤버 등록");

                    System.out.print("역할 선택 (1: 아기사자, 2: 운영진): ");
                    int type = sc.nextInt();
                    sc.nextLine();

                    System.out.print("이름: ");
                    String name = sc.nextLine();

                    boolean exists = false;
                    for (Roles r : memberList) {
                        if (r.getName().equals(name)) {
                            exists = true;
                        }
                    }

                    if (exists) {
                        System.out.println("중복!");
                        break;
                    }

                    System.out.print("파트: ");
                    String part = sc.nextLine();

                    System.out.print("기수: ");
                    int gen = sc.nextInt();
                    sc.nextLine();

                    Roles newMember;

                    if (type == 1) {
                        System.out.print("전공: ");
                        String major = sc.nextLine();

                        System.out.print("학번: ");
                        String studentId = sc.nextLine();

                        newMember = new Lion(name, major, gen, part, studentId);
                    } else {
                        System.out.print("전공: ");
                        String major = sc.nextLine();

                        System.out.print("직책: ");
                        String pos = sc.nextLine();

                        newMember = new Staff(name, major, gen, part, pos);
                    }

                    memberList.add(newMember);

                    partMap.putIfAbsent(part, new ArrayList<>());
                    partMap.get(part).add(newMember);

                    System.out.println("등록 완료");
                    break;

                case 2:
                    for (Roles r : memberList) {
                        System.out.println(r.getInfo());
                    }
                    break;

                case 3:
                    System.out.print("이름: ");
                    String search = sc.nextLine();

                    boolean found = false;
                    for (Roles r : memberList) {
                        if (r.getName().equals(search)) {
                            System.out.println(r.getInfo());
                            found = true;
                        }
                    }

                    if (!found) {
                        System.out.println("없음");
                    }
                    break;

                case 4:
                    System.out.println("파트 목록: " + partMap.keySet());
                    System.out.print("파트 입력: ");
                    String p = sc.nextLine();

                    if (partMap.containsKey(p)) {
                        List<Roles> list = partMap.get(p);
                        int idx = 1;
                        for (Roles r : list) {
                            String roleType = (r instanceof Lion) ? "아기사자" : "운영진";
                            System.out.println(idx + ". " + r.getName() + " (" + roleType + ")");
                            idx++;
                        }
                    } else {
                        System.out.println("없음");
                    }
                    break;
            }
        }
    }
}