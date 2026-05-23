# 📘 Today I Learned

### 1. 오늘 배운 내용
-Service 생성자에서 MemberRepository repository를 인터페이스 타입으로 받아서, 어떤 구현체가 들어와도 동일하게 동작하도록 만드는 생성자 주입 방식을 배웠다.
-코드를 Repository, Service, Main 3개의 레이어로 분리하는 방법과 이유를 배웠다.
-의존성 주입(DI)이라는 개념을 배웠다 — Service가 Repository를 직접 만들지 않고 외부에서 받아서 쓰는 방식을 배웠다.
-Memory 저장소와 Mock 저장소 두 가지를 만들어서 교체했다.


### 2. 핵심 정리 (내 언어로)
-코드를 데이터(Member), 저장(Repository), 로직(Service), 실행(Main) 으로 나누면 나중에 수정할 때 해당 부분만 건드리면 된다.
-인터페이스는 반드시 만들어야 하는 정보를 전달한다.
-의존성 주입은 쉽게 말하면 부품을 밖에서 갈아끼울 수 있게 만드는 것이다, Service 코드는 그대로인데 저장소만 Memory ↔ Mock으로 바꿀 수 있었다.
-private 필드는 직접 접근이 안 되기 때문에 Getter를 통해서만 값을 읽을 수 있다.



### 3. 결과 이미지(스크린샷)
<img width="1710" height="1112" alt="스크린샷 2026-05-07 오후 2 11 25" src="https://github.com/user-attachments/assets/61407432-8b6d-4bdc-a0e0-e9a13b917df6" />
<img width="1710" height="1112" alt="스크린샷 2026-05-07 오후 2 45 12" src="https://github.com/user-attachments/assets/1a08d3a1-fe9b-42cb-b3ef-aa6c88f59e59" />
<img width="1710" height="1112" alt="스크린샷 2026-05-07 오후 2 45 17" src="https://github.com/user-attachments/assets/90c461a4-53dc-4442-a2b0-8de0c8d3cb2c" />




### 4. 느낀 점
- 처음에 MemberService가 MemberRepository를 직접 new로 생성했을 때는 저장소를 바꾸려면 Service 코드 안을 직접 수정해야 했는데, 생성자 주입 방식으로 바꾸니까 Main에서 한 줄만 바꿔도 Service는 전혀 건드리지 않아도 됐다.
- private final MemberRepository repository 에서 final 키워드를 쓴 이유가, 한번 주입된 저장소가 중간에 바뀌면 안 되기 때문이라는 걸 이해했다.
- 인터페이스 덕분에 MemoryMemberRepository와 MockMemberRepository가 완전히 다른 동작을 하는데도 Service 입장에서는 똑같은 MemberRepository 타입으로 다룰 수 있다는 게 인상깊었다.
- @Override 어노테이션이 "인터페이스에서 선언한 메서드를 내가 여기서 구현한다"는 표시라는 걸 제대로 이해했다.

