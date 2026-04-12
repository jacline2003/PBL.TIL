📘 Today I Learned

1. 오늘 배운 내용

* 입력값 검증을 main 메서드에서 수행하는 방법과, 객체 내부에서 수행하는 방법의 차이를 이해했다.
* 접근 제어자(public, default, private)에 따라 필드 접근 가능 범위가 달라지는 것을 확인했다.
* 서로 다른 패키지에서 클래스 import 및 접근 방법을 실습했다.
* IntelliJ에서 패키지 구조(src/main/java)와 실행 구조를 이해했다.
* 실행 오류(패키지, import, 인코딩, 입력 오류 등)를 해결하는 방법을 학습했다.

2. 핵심 정리 (내 언어로)

* Java는 반드시 main 메서드에서 시작되며, 실행 클래스와 객체 클래스의 역할이 다르다.
* Step1에서는 main에서 입력값을 검증하고 객체를 생성했지만, Step2에서는 객체 내부에서 스스로 상태를 검증하도록 구조를 변경했다.
* 이는 객체지향에서 "객체가 자신의 상태를 책임진다"는 개념을 이해하는 과정이었다.
* 접근 제어자는 외부에서 데이터를 직접 수정할 수 있는 범위를 결정하며, 특히 private은 직접 접근이 불가능하고 getter/setter를 통해 접근해야 한다.
* 패키지 이름과 import는 정확히 일치해야 하며, 대소문자도 구분되기 때문에 중요하다.
* 또한 IntelliJ에서는 반드시 src/main/java 내부에 패키지를 생성해야 정상적으로 실행된다.

3. 결과 이미지
결과
<img width="960" height="540" alt="0412Step1Main" src="https://github.com/user-attachments/assets/aa0a1ee3-7698-410f-a287-7a7b5c1dff68" />
<img width="960" height="540" alt="0412Step2Main" src="https://github.com/user-attachments/assets/4ebddc32-8911-4d6a-b014-40d31f03a213" />
<img width="960" height="540" alt="0412Step3Main" src="https://github.com/user-attachments/assets/09b5a876-7aef-42ed-96f2-d60c254f819a" />

오류
<img width="1920" height="1080" alt="image" src="https://github.com/user-attachments/assets/17255970-5740-4ed9-b0e0-322e5c5a411e" />

4. 느낀 점

* 처음에는 패키지 구조와 실행 방법이 헷갈렸지만, 직접 오류를 해결하면서 Java 프로젝트 구조를 이해하게 되었다.
* 특히 main에서 검증하는 방식과 객체 내부에서 검증하는 방식의 차이를 직접 코드로 경험하면서 객체지향 설계의 중요성을 느꼈다.
* 접근 제어자를 통해 데이터 보호가 어떻게 이루어지는지 이해할 수 있었고, 단순히 코드를 작성하는 것을 넘어 설계의 중요성을 알게 되었다.
* 또한 실행 중 변수 선언을 하지 않아 발생한 오류를 통해, 프로그램이 실행되기 전에 컴파일 단계에서 변수와 클래스의 존재 여부가 매우 중요하다는 것을 깨달았다.

5. 오류 경험 및 해결

* Step1Main 실행 중 `cannot find symbol` 오류가 발생하였다.
* 원인은 name, major, gen 변수를 선언하지 않고 사용했기 때문이었다.
* 또한 Lion 클래스를 찾지 못하는 오류도 발생했는데, 이는 package 이름이 일치하지 않아서 생긴 문제였다.
* 패키지명을 통일하고 변수 선언 및 입력 코드를 추가함으로써 문제를 해결할 수 있었다.
