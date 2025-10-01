# Groupware System 요구사항 정의서 (SRS)

## 1. 개요
- **프로젝트명**: Groupware System
- **목적**: 기업 내 협업과 소통을 지원하는 그룹웨어 핵심 기능 구현
- **범위**: 전자결재, 연차/근태 관리, 업무 관리, 자료실, 공지사항, 실시간 메신저, 내정보 관리
- **개발 기간**: 2025.09 ~ 2025.12
- **대상 사용자**: 기업 구성원 (관리자, 일반 사용자)

## 2. 용어 정의
용어 | 정의
------|------
관리자 | 시스템 운영과 문서/공지/자료 관리 권한이 있는 사용자
일반 사용자 | 그룹웨어 기능을 사용하는 직원
OTP | One-Time Password, 2단계 인증에 사용
WebSocket | 실시간 데이터 전송 프로토콜
Redis | 메모리 기반 캐싱 및 Pub/Sub 메시지 전송에 사용

## 3. 시스템 요구사항

### 3.1 기능 요구사항

#### 3.1.1 업무관리
- 업무 등록/수정/삭제 기능
- 담당자 지정, 상태 변경(진행/완료/보류)
- 업무 조회 및 필터링

#### 3.1.2 전자결재
- 문서 기안/제출/승인/반려
- 문서 양식 관리(관리자)
- 결재 문서함 조회  (기안/승인/반려/완료)
- 결재 통계 및 로그 관리 (관리자)

#### 3.1.3 연차/근태 관리
- 연차 신청/취소/조회
- 근태 기록 관리
- Google Calendar 연동 (승인연차 자동 반영)

#### 3.1.4 자료실
- 문서 업로드/다운로드
- 서식 자료 관리
- 접근 권한 관리 (관리자/사용자)

#### 3.1.5 공지사항
- 공지 등록/수정/삭제 (관리자)
- 공지 조회 (전체)

#### 3.1.6 메신저 (실시간 채팅)
- 1:1, 그룹 채팅
- 읽음/안읽음 표시
- WebSocket + Redis Pub/Sub
- 브라우저 Notification API 연동 (윈도우 알림)

#### 3.1.7 내정보
- 프로필 조회/수정
- 비밀번호 변경
- OTP 기반 2단계 인증

### 3.2 비기능 요구사항
- **보안**: Spring Security, Role 기반 접근 제어, OTP 2단계 인증
- **성능**: 다수 동시 접속자 지원, Redis 캐싱 활용
- **가용성**: AWS EC2/RDS/S3 기반 운영
- **확장성**: REST API 설계, 마이크로서비스 대비 가능
- **테스트**: JUnit, AOP 기반 로깅

### 3.3 시스템 환경
- **Backend**: Java 21, Spring Boot 3.x, JPA + MyBatis, WebSocket
- **Frontend**: React, JavaScript, jQuery, Chart.js, Notification API
- **Database**: PostgreSQL, Redis
- **Integration**: Google Calendar API, Google OTP
- **Infra & DevOps**: Docker, Docker Compose, GitHub Actions (CI/CD), AWS EC2/RDS/S3

### 3.4 제약 사항
- 브라우저 기반 UI 지원 (Chrome, Edge)
- 모바일 환경은 추후 확장 가능
- 외부 API 연동 시 인증 토큰 관리 필수  
