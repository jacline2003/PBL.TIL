# 📘 Today I Learned

### 1. 오늘 배운 내용
- Spring Boot와 MySQL을 JPA로 연동하는 방법
- @Entity, @Id, @GeneratedValue, @Enumerated 어노테이션 사용법
- JpaRepository를 상속해서 DB CRUD 기능을 자동으로 사용하는 방법
- ddl-auto=create로 테이블을 자동 생성하는 방법
- 영속성 컨텍스트와 save() 호출 시 id가 채워지는 원리
- Hibernate가 콘솔에 출력하는 SQL을 읽는 방법

### 2. 핵심 정리 (내 언어로)
- @Entity는 이 클래스가 DB 테이블과 연결된다는 선언이다. JPA가 이 클래스를 보고 테이블을 만들고 데이터를 저장한다.
- @Enumerated(EnumType.STRING)을 쓰면 enum 값이 DB에 숫자가 아니라 "LION", "STAFF" 같은 문자열로 저장된다. 나중에 enum 순서가 바뀌어도 데이터가 안전하다.
- JpaRepository를 상속하면 save(), findById(), findAll(), deleteById() 같은 메서드를 직접 구현하지 않아도 바로 쓸 수 있다.
- week7에서는 이름(name)으로 멤버를 식별했지만, week8부터는 DB id로 식별한다. 이름은 중복될 수 있지만 id는 절대 중복되지 않기 때문이다.

### 3. 스크린샷
<img width="1390" height="1838" alt="image" src="https://github.com/user-attachments/assets/09f48870-9df4-436a-af2d-c1c4329b39ff" />
<img width="1362" height="1844" alt="image" src="https://github.com/user-attachments/assets/e6bc6ee4-93ce-43ad-ad8b-574e3ff31645" />
<img width="2260" height="1964" alt="image" src="https://github.com/user-attachments/assets/2afa1a2b-93b9-4c72-a7d2-eda529b979b6" />
<img width="2258" height="1972" alt="image" src="https://github.com/user-attachments/assets/a2e4ffde-272f-470e-be34-d1bb967a4bc1" />
<img width="1414" height="1274" alt="image" src="https://github.com/user-attachments/assets/87d0aea5-856d-4592-82da-3354065e5601" />
<img width="1428" height="1470" alt="image" src="https://github.com/user-attachments/assets/9333f173-6f98-4137-a688-81c126faff3f" />
<img width="1404" height="1110" alt="image" src="https://github.com/user-attachments/assets/11d9744c-000e-4660-9ef3-0ceed47e1820" />


### 4. 느낀 점
- week7에서 직접 List로 데이터를 관리할 때는 앱을 재시작하면 데이터가 사라졌는데, JPA와 MySQL을 연동하니까 데이터가 실제로 DB에 저장되는 걸 Workbench에서 눈으로 확인할 수 있었다. 
