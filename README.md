## 브랜치 정보
- v.1.0.1 : MVC and Template Tutorial
- v.1.0.2 : What is API : RequestBody (JSON)
- v.1.0.3 : Create Repository and Test case

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

##Contributor
- [YOONSANG CHO](https://github.com/Maitan21)     
- Univ. : KyungPook National University 
- Major : Computer Science Advanced Computer      
##Reference
- inflearn : [스프링-입문-스프링부트(김영한)](https://www.inflearn.com/course/%EC%8A%A4%ED%94%84%EB%A7%81-%EC%9E%85%EB%AC%B8-%EC%8A%A4%ED%94%84%EB%A7%81%EB%B6%80%ED%8A%B8/dashboard)
