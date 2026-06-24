# 📘 Today I Learned

### 1. 오늘 배운 내용
-@RestControllerAdvice로 전역 예외 처리기 만들기
-@ExceptionHandler로 예외 타입별로 다른 응답 반환하기
-커스텀 예외 클래스를 만들어서 비즈니스 로직 예외 표현하기
-Service에서 null 반환 → 예외 던지기 방식으로 리팩토링
-JPA 쿼리 메서드 네이밍 규칙으로 검색 기능 구현
-프론트엔드 fetch()로 백엔드 API 호출하고 화면에 렌더링하는 흐름 이해

### 2. 핵심 정리 (내 언어로)
- @RestControllerAdvice는 모든 Controller에서 예외가 터졌을 때 그걸 한 곳에서 잡아주는 역할을 한다.
  원래는 각 Controller마다 try-catch를 써야 했는데, 이걸 쓰면 한 클래스에서 모든 에러를 관리할 수 있어서 코드가 훨씬 깔끔해진다.
- @ExceptionHandler는 특정 예외 타입이 발생했을 때 어떻게 응답할지 정의하는 어노테이션이다.
    예를 들어 MemberNotFoundException이 터지면 404, DuplicateMemberNameException이 터지면 409를 반환하도록 각각 지정할 수 있다. Spring이 예외 타입을 보고 알맞은 핸들러 메서드를 자동으로 찾아서 실행해준다.
  
### 3. 스크린샷
존재하지 않는 멤버 조회
<img width="1130" height="593" alt="image" src="https://github.com/user-attachments/assets/fcaad237-7bc0-4bef-8162-884dd2676689" />
중복 이름으로 멤버 등록 
<img width="635" height="721" alt="image" src="https://github.com/user-attachments/assets/c458f391-265d-4447-ab06-13e63b3637da" />
존재하지 않는 과제 수정
<img width="684" height="730" alt="image" src="https://github.com/user-attachments/assets/1c27a91b-f5b0-4041-8604-2222ecbeb091" />
전체 과제 조회
<img width="805" height="553" alt="image" src="https://github.com/user-attachments/assets/b8a1357d-c370-4fd2-a709-211c3382ab8d" />
파트별 멤버 필터링
<img width="674" height="783" alt="image" src="https://github.com/user-attachments/assets/1da47001-568b-4890-b47d-a086078b704a" />
과제 제목 검색
<img width="904" height="634" alt="image" src="https://github.com/user-attachments/assets/3d59fbf0-4211-4027-b772-532c645ae5d7" />

멤버 등록 , 수정/삭제
<img width="818" height="527" alt="image" src="https://github.com/user-attachments/assets/192815f7-ca4e-4351-95b5-ba1e83ee281b" />
과제 등록 , 과제 조회
<img width="838" height="788" alt="image" src="https://github.com/user-attachments/assets/b11e5b35-ff75-4656-b435-9a6969705dd0" />
과제 수정
<img width="741" height="386" alt="image" src="https://github.com/user-attachments/assets/4e0f97cb-d71f-4f75-ab9f-79ce6893153d" />

과제 삭제
<img width="747" height="384" alt="image" src="https://github.com/user-attachments/assets/b79ea65f-c690-4c77-95e7-262d6edd84ac" />

### 4. 느낀 점
- 기존에는 Service가 데이터가 없으면 null을 반환하고, Controller가 null인지 체크해서 404를 직접 만들었다. 리팩토링 후에는 Service가 없으면 바로 예외를 던지고, Controller는 그냥 정상 응답만 반환한다. Controller가 에러 처리까지 신경 쓸 필요가 없어지니까 각 계층의 역할이 명확해졌다.
- 저번에 이어서 HTTP 메서드는 CRUD와 이렇게 대응된다: GET(Read, 조회) / POST(Create, 등록) / PUT(Update, 수정) / DELETE(Delete, 삭제). 오늘 로그 패널에서 직접 눈으로 확인하니까 확실히 이해가 됐다.
- 예외 처리를 제대로 구현하니까 프론트엔드에서 에러 토스트가 정확한 메시지로 뜨는 게 눈에 보여서 뿌듯했다. 백엔드와 프론트엔드가 실제로 연결되어 동작하는 과정을 이해할 수 있었다.
