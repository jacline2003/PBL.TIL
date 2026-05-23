# 📘 Today I Learned

### 1. 오늘 배운 내용

* Spring Boot 프로젝트를 생성하고 IntelliJ에서 실행하는 방법을 배웠다.
* Spring Bean이 무엇인지, 스프링 컨테이너가 객체를 관리한다는 개념을 이해했다.
* @Configuration과 @Bean을 사용한 수동 주입 방식을 실습했다.
* @Service, @Repository, @Autowired를 활용한 자동 주입 방식을 실습했다.
* 생성자가 하나일 경우 @Autowired를 생략해도 동작한다는 것을 확인했다.
* @RestController와 @GetMapping을 사용해 간단한 REST API를 구현했다.
* 브라우저와 Postman으로 API 응답을 확인하는 방법을 배웠다.

### 2. 핵심 정리 (내 언어로)

* 이전에는 new 키워드로 객체를 직접 생성하고 연결했지만, Spring에서는 스프링 컨테이너가 객체를 관리해준다.
* 수동 주입은 개발자가 AppConfig에서 Bean을 직접 등록하는 방식이고, 자동 주입은 어노테이션만 붙이면 Spring이 자동으로 Bean을 생성하고 연결해준다.
* @Service, @Repository를 붙이면 Spring이 객체를 Bean으로 등록한다.
* 생성자 주입 방식은 의존성을 안전하게 관리할 수 있어서 많이 사용된다는 것을 알게 되었다.
* @RestController와 @GetMapping을 이용하면 브라우저에서 접근 가능한 API를 쉽게 만들 수 있었다.
* 단순히 코드를 작성하는 것뿐 아니라, 프로젝트 구조와 패키지 위치를 올바르게 관리하는 것도 중요하다는 것을 느꼈다.

### 3. 결과 이미지(스크린샷)
<img width="1179" height="600" alt="image" src="https://github.com/user-attachments/assets/688b2100-ad39-49a2-bf38-1281ceca0a98" />
<img width="1394" height="960" alt="image" src="https://github.com/user-attachments/assets/c06e08d8-9091-43bd-b65f-e0722441617e" />

### 4. 느낀 점
아직 intelliJ 사용이 익숙하지 않은건지 구조가 꼬이는 일이 잦다. 특히 Bean, 의존성 주입, Gradle 같은 개념이 익숙하지 않아서 프로젝트 구조가 꼬였다. 
그래도 직접 오류를 해결하고 API가 정상적으로 실행되는 것을 보면서 조금씩 흐름이 이해되기 시작했다.
Spring이 객체를 어떻게 관리하고 연결하는지에 대한 기본 원리를 배울 수 있었다. 
