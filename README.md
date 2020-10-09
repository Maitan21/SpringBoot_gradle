# Basic of Spring Boot / WEB MVC / DB Access
웹 애플리케이션 개발의 기본 연습 (스프링 부트 / 웹 MVC / DB 접근)

## 브랜치 정보
- v.1.0.1 : MVC and Template Tutorial
- v.1.0.2 : What is API : RequestBody (JSON)
- v.1.0.3 : Create Repository and Test case
- v.1.0.4 : Spring Bean and Component Scan

## Spring MVC
- Controller : 웹 MVC의 컨트롤러 역할
- Service : 핵심 비지니스 로직 구현(중복체크 같은)
- Repository : DB에 접근 도메인 객체를 DB에 저장하고 관리
- domain : 비즈니스 도메인 객체, 예)회원, 주문, 쿠폰 등등 주로 데이터베이스에 저장하고 관리됨
- MemberService -> MemberRepository(Interface) <--- DB
            
## Spring MVC Logic
1. 사용자 요청(`HTTP request`)
2. `Controller` 가 받아서 
3. `Service`로 넘기고
4. `Service`는 `DAO(interface)`를 호출하고
5. `DAO`는 `DB`에서 데이터를 `조회`해서 다시 `Service`로 리턴하고
6. `Service`는 `데이터를 이용`해서 `로직을 수행`하고
7. `결과`를 다시 `Controller`로 넘기고
8. `Controller`는 다시 사용자에게 `응답`하게 되죠.

<p align="center"><img src="https://user-images.githubusercontent.com/45276804/95547287-912f2180-0a3d-11eb-8433-a5121de7b4b6.png"></p>

## Spring Bean and Dependency Injection

### The way of registering Spring Bean
- `컴포넌트 스캔`(이노테이션설정) 과 `자동 의존관계` 설정
- `자바코드`로 `직접` 스프링 빈 등록 `@Bean 등록후 return 해당 클래스`

### 컴포넌트 스캔과 자동 의존관계 설정
- `@Component` : 에노테이션이 있으면 스프링 빈으로 자동 등록한다. (@Controller @Service @Repository 내장)
- `@Controller` : 컨트롤러가 스프링 빈으로 자동 등록된 이유도 컴포넌트 스캔 떄문이다. 
- `메인 에플리케이션`의 `패키지 하위` 스캔
* 참고 : 스프링은 스프링 컨테이너에 스프링 빈을 등록할 때, 기본으로 싱글톤으로 등록한다.(유일하게 하나만 등록해서 공유한다.)
 `즉 하나의 컨트롤러에 하나의 서비스 하나의 레포지토리를 스캔`
 
 *참고 : DI에는 필드주입, Setter주입, 생성자 주입 3가지 방법. 의존관계가 실행중에 동적으로 변하는 경우는 거의 없으므로 생성자 주입을 권장
 *참고 : `@Autowired`를 통한 DI는 `helloController`,`MemberService`등과 같이 스프링이 관리하는 개체에서 동작한다. 스프링빈으로 등록하지 않고 내가 직접 생성한 객체에서는 동작하지 않는다.
 
## Contributor
- [YOONSANG CHO](https://github.com/Maitan21)     
- Univ. : KyungPook National University 
- Major : Computer Science Advanced Computer      
## Reference
- inflearn : [스프링-입문-스프링부트(김영한)](https://www.inflearn.com/course/%EC%8A%A4%ED%94%84%EB%A7%81-%EC%9E%85%EB%AC%B8-%EC%8A%A4%ED%94%84%EB%A7%81%EB%B6%80%ED%8A%B8/dashboard)
