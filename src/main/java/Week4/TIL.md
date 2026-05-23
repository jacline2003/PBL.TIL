# 📘 Today I Learned

### 1. 오늘 배운 내용

1. Java에서 패키지 구조와 실제 폴더 구조는 반드시 일치해야 한다는 점
2. IntelliJ에서 Package와 Directory의 차이 (반드시 Package로 생성해야 import 가능)
3. package, import 경로를 상위 패키지까지 포함해서 정확히 작성해야 한다는 것
4. List와 Map을 활용한 컬렉션 기반 데이터 관리 및 제네릭 사용 방법

### 2. 핵심 정리

1. Java는 "폴더 구조 = 패키지 경로"라서 파일 위치 그대로 package에 써야 오류가 안난다
2. import 오류의 대부분은 경로를 끝까지 안 써서 생긴다 (ex: Week4.role)
3. List<Role>처럼 제네릭을 쓰면 타입이 안전해지고, 여러 객체를 하나로 관리할 수 있다
4. Map<String, List<Role>> 구조는 그룹별로 데이터를 묶는 데 매우 유용하다

### 3. 결과 이미지
<img width="3420" height="2224" alt="KakaoTalk_Photo_2026-05-03-21-00-48" src="https://github.com/user-attachments/assets/636259f3-5d7a-444c-a079-30e2ef659169" />
<img width="3420" height="2224" alt="KakaoTalk_Photo_2026-05-03-21-00-42" src="https://github.com/user-attachments/assets/5238a252-30be-4196-a519-bae2c65b320a" />
<img width="3420" height="2224" alt="KakaoTalk_Photo_2026-05-03-21-00-35" src="https://github.com/user-attachments/assets/90bf0e1e-ccec-405d-a30d-dbc9b0247a70" />
<img width="3420" height="2224" alt="KakaoTalk_Photo_2026-05-03-20-50-53" src="https://github.com/user-attachments/assets/11ff5adc-76af-43bd-80e2-db1983d61eb0" />


### 4. 느낀 점

1. 단순히 코드만 맞는다고 되는 게 아니라 구조(패키지)가 훨씬 중요하다는 걸 느낌
2. IntelliJ에서 뭘 선택하느냐(Package vs Directory)가 생각보다 큰 차이를 만든다
3. 작은 import 오류 하나가 전체 코드 실행을 막을 수 있어서 기본기가 중요하다고 느낌
4. 점점 구조가 연결되면서 코드가 커지는 게 흥미롭고, 오류를 해결하는 과정이 어렵지만 오류를 해결하는 과정이 많을수록 더 깊이 이해할 수 있는 거 같다.
