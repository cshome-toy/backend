# Discord Clone Cording
온라인 메신저 프로그램 Discord의 클론 코딩 프로젝트

## Features

- 디스코드의 포스트 기능을 클론하여 게시판의 CRUD 기능 구현
- 디스코드의 실시간 채팅 기능을 클론하여 채팅 기능 구현
- JWT 인증 기반의 로그인 및 회원가입 기능 구현

## Stacks
- Java 21
- Spring Boot 3.5
- MySQL
- Spring JPA
- QueryDSL
- JWT

## Convention

### Commit Convention

| 타입 | 설명 |
|------|------|
| `feat` | 새로운 기능 추가 |
| `fix` | 버그 수정 |
| `refactor` | 코드 리팩토링 (기능 변화 없음) |
| `docs` | 문서 수정 |
| `chore` | 빌드/배포/패키지 관리 등 기타 작업 |
| `test` | 테스트 코드 추가/수정 |

커밋 메시지는 아래와 같이 작성한다
> 분류(파일명 혹은 작업 도메인): 작업 설명

*ex1) feat(Member): 회원 가입 기능 구현*

*ex2) fix(Board): 게시판 조회 가능 권한 수정*

### Branch Convention

| 타입 | 설명 |
|------|-----|
| `feat` | 새로운 기능 추가 |
| `fix` | 버그 수정 |
| `refactor` | 코드 리팩토링 (기능 변화 없음) |
| `docs` | 문서 수정 |
| `chore` | 빌드/배포/패키지 관리 등 기타 작업 |
| `test` | 테스트 |

브랜치 이름은 아래와 같이 작성한다.
> 분류/#이슈번호

*ex1) feat/#1*

*ex2) fix/#43*


### Issue Convention

이슈명은 간결하되 어떤 작업인지 알 수 있도록 적는다.

내용에는 이슈 내용과, 작업 리스트를 간결하게 적는다.

### PR Convention

풀 리퀘스트의 제목은 아래의 형식에 맞추어 변경사항을 간결하고 명확하게 적는다.
> 분류: 작업 내용

*ex1) feat: 회원 가입 기능 구현 완료*

*ex2) fix: 게시판 조회 가능 권한 수정 완료*

PR 내용의 맨 위에는 PR에 해당하는 이슈를 태그한다.

그 밑에는 작업 내용 요약을 간략히 적는다.

Reviewers에 백엔드 팀원을, Assigness에 본인을, Label에 해당하는 카테고리를, Development에 해당 이슈를 넣는다.

PR을 올린 후 팀원 최소 한명이 Approve하게 되면 Merge한다.