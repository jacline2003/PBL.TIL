# 📘 Today I Learned

### 1. 오늘 배운 내용
- Spring Boot 프로젝트 구조와 REST API 기본 흐름 이해하기
- HTTP 메서드(GET, POST, PUT, DELETE)와 상태 코드 활용하기
- DTO를 사용해서 요청과 응답 데이터를 분리하는 방법
- build.gradle을 통한 라이브러리 및 의존성 관리
- Postman과 Swagger를 이용한 API 테스트 방법

### 2. 핵심 정리 (내 언어로)
- REST API는 URL로 데이터를 구분하고, HTTP 메서드로 어떤 동작을 할지 정한다. 예를 들어 POST는 데이터 생성, DELETE는 데이터 삭제에 사용된다.
- 상태 코드는 서버가 요청을 어떻게 처리했는지 알려주는 역할을 한다. 200은 성공, 404는 데이터를 찾지 못했을 때 사용하는 코드
- DTO는 데이터를 주고받을 때 사용하는 객체이다. 처음에는 왜 따로 만드는지 헷갈렸는데, 도메인 객체를 직접 노출하지 않기 위해 사용한다는 걸 이해했다.
- build.gradle 파일에서는 프로젝트에 필요한 라이브러리를 추가할 수 있다. Spring Web 의존성을 추가해야 REST API 기능을 사용할 수 있다.
- 메모리 저장소는 실행 중일 때만 데이터가 유지되고 서버를 껐다 켜면 데이터가 사라진다. 이후 JPA를 배우면 데이터베이스에 영구 저장할 수 있다고 들었다.

### 3. 스크린샷 
lion(아기사자)등록
<img width="1204" height="948" alt="image" src="https://github.com/user-attachments/assets/5f74a249-2244-4ddf-8cec-80cb9c418753" />
staff(운영진)등록
<img width="1143" height="933" alt="image" src="https://github.com/user-attachments/assets/3b1cccb2-bf56-4b2f-a3e9-c02bbd3bbabe" />
(staff) 이름 중복시
<img width="1160" height="888" alt="image" src="https://github.com/user-attachments/assets/8fe85aea-97fb-45b5-bd02-c0d42de203a8" />
단일멤버조회
<img width="1162" height="631" alt="image" src="https://github.com/user-attachments/assets/a9e4b203-d1b1-488b-8267-988e7d7c4312" />
없는멤버조회
<img width="1148" height="589" alt="image" src="https://github.com/user-attachments/assets/f42f43e4-41ba-4c57-ac99-d2568a48035b" />
lion수정
<img width="1132" height="978" alt="image" src="https://github.com/user-attachments/assets/8003194b-2396-4b3a-ad5f-5e7a78160d32" />
staff수정
<img width="1160" height="867" alt="image" src="https://github.com/user-attachments/assets/d8a96c21-9da7-4c0b-b4d2-a50da6dd7ddc" />
멤버 삭제
<img width="1246" height="699" alt="image" src="https://github.com/user-attachments/assets/61550ec1-0925-4f5c-b461-1c16b4ca7402" />
<img width="1164" height="752" alt="image" src="https://github.com/user-attachments/assets/1cbfb788-c43b-4541-8eab-437dbcf41e32" />


### 4. 느낀 점
- REST API를 직접 구현해보니까 단순히 개념으로만 배울 때보다 훨씬 이해가 잘 됐다.
- 특히 상태 코드와 HTTP 메서드를 직접 사용해보면서 각각 어떤 상황에서 쓰이는지 감이 잡혔다.
