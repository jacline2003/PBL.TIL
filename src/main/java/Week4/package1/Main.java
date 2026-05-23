package Week4.package1;

import Week3.Role.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Roles> memberList = new ArrayList<>();

        while (true) {
            System.out.println("\n1. 등록 2. 전체조회 3. 이름으로 검색 0. 종료");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 0) break;

            switch (choice) {
                case 1:
                    System.out.print("1: 아기사자, 2: 운영진: ");
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

                    for (Roles r : memberList) {
                        if (r.getName().equals(search)) {
                            System.out.println(r.getInfo());
                        }
                    }
                    break;
            }
        }
    }
}