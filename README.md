# Likelion Member Manager

멋쟁이사자처럼 부원(아기사자/운영진) 및 과제를 관리하는 Spring Boot REST API 서버입니다.

## 기술 스택

| 기술 | 버전 |
|------|------|
| Java | 21 |
| Spring Boot | 3.5.14 |
| Spring Data JPA | - |
| MySQL | 8.x |
| Lombok | - |

## 실행 방법

1. 레포지토리 클론
```bash
   git clone https://github.com/your-repo/Week7.git
   cd Week7
```

2. MySQL DB 생성
```sql
   CREATE DATABASE likelion;
```

3. `application.properties` 설정
```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/likelion
   spring.datasource.username=root
   spring.datasource.password=your_password
   spring.jpa.hibernate.ddl-auto=update
```

4. 실행
```bash
   ./gradlew bootRun
```

5. 브라우저 접속: `http://localhost:8080`

## API 목록

### Member API

| 메서드 | URI | 설명 |
|--------|-----|------|
| POST | `/members/lions` | 아기사자 등록 |
| POST | `/members/staffs` | 운영진 등록 |
| GET | `/members` | 전체 멤버 조회 |
| GET | `/members?part={part}` | 파트별 필터링 |
| GET | `/members/{id}` | 단건 조회 |
| PUT | `/members/lions/{id}` | 아기사자 수정 |
| PUT | `/members/staffs/{id}` | 운영진 수정 |
| DELETE | `/members/{id}` | 멤버 삭제 |

### Assignment API

| 메서드 | URI | 설명 |
|--------|-----|------|
| POST | `/members/{memberId}/assignments` | 과제 등록 |
| GET | `/assignments` | 전체 과제 조회 |
| GET | `/members/{memberId}/assignments` | 멤버별 과제 조회 |
| GET | `/assignments/{id}` | 과제 단건 조회 |
| GET | `/assignments/search?keyword=` | 제목 검색 |
| PUT | `/assignments/{id}` | 과제 수정 |
| DELETE | `/assignments/{id}` | 과제 삭제 |

### 에러 응답 형식

```json
{
  "status": 404,
  "message": "해당 멤버를 찾을 수 없습니다. id: 999"
}
```

| 상황 | 상태 코드 |
|------|-----------|
| 존재하지 않는 멤버 조회 | 404 Not Found |
| 존재하지 않는 과제 조회 | 404 Not Found |
| 중복 이름으로 멤버 등록 | 409 Conflict |

## 프로젝트 구조

```
src/main/java/com/example/Week7/
├── Week7Application.java
├── GlobalExceptionHandler.java
├── exception/
│   ├── MemberNotFoundException.java
│   ├── AssignmentNotFoundException.java
│   ├── DuplicateMemberNameException.java
│   └── ErrorResponse.java
├── domain/
│   ├── Member.java
│   └── RoleType.java
├── dto/
│   ├── LionCreateRequest.java
│   ├── LionUpdateRequest.java
│   ├── StaffCreateRequest.java
│   ├── StaffUpdateRequest.java
│   └── MemberResponse.java
├── repository/
│   └── MemberRepository.java
├── service/
│   └── MemberService.java
├── controller/
│   └── MemberController.java
└── assignment/
    ├── Assignment.java
    ├── AssignmentRepository.java
    ├── AssignmentService.java
    ├── AssignmentController.java
    ├── AssignmentRequestDto.java
    └── AssignmentResponseDto.java
```
