📘 Today I Learned
1. 오늘 배운 내용
- 과제 제출 가능 여부를 판단하기 위해 정책 인터페이스(Policy)를 만들고, 역할별로 다른 정책을 적용했다.
- 아기사자(Lion)는 제출 가능(true), 운영진(Staff)은 제출 불가능(false)하도록 각각 다른 정책 클래스를 구현했다.
- 조건문(if, instanceof) 없이 역할별 동작을 다르게 만들었다.
- Main에서는 역할을 구분하지 않고, 공통 타입(Roles)으로 객체를 다뤘다.

2. 핵심 정리 (내 언어로)
- Roles라는 추상 클래스를 만들고,이름/전공/기수/파트 같은 공통 정보는 여기서 관리했다.
- Lion과 Staff는 Roles를 상속받아서 각각 추가 정보(학번, 직책)를 가지도록 했다.
- Roles 클래스에서는  과제 제출 가능 여부를 직접 판단 하지않고  정책 객체에게 물어보는 방식으로 구현했다.
public boolean canSubmit() {
    return getPolicy().canSubmit();
}

3. 결과 이미지
<img width="3086" height="904" alt="image" src="https://github.com/user-attachments/assets/f975180f-5f50-4b39-8116-d9a766ca7b1e" />


4. 느낀 점
- 처음에는 왜 굳이 Policy를 따로 만들어야 하는지 이해가 잘 안됐는데, 직접 해보니 역할과 정책을 분리하는 이유를 알게 되었다.
- 특히 과제 제출 가능 여부를 객체가 아니라 정책 객체가 판단하도록 만든 구조가 기억에 남는다.
