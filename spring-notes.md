# Notes to use Spring framework effectively

## @Bean v.s. @Component의 차이점
  - https://galid1.tistory.com/494
## @Qualifier / @Resource를 사용하는 이유
  - 같은 Interface를 구현하는 클래스가 여러 개 있는 경우, 어떤 구현 클래스를 써야할지 IoC Container가 결정하지 못함
  - @Qualifier에서 빈 이름 설정 시 구현 관련 정보가 포함되지 않도록 유의해야 함 / 대신  역할, 사용목적, 용도를 이름으로 명명하는 것이 좋음
  
## spring의 DataSource
> application이 DB에 접근하기 위한 추상화된 연결 방식

  - application module이 제공하는 DataSource
```
Commons DBCP or Tomcat JDBC Connection Pool등을 등록해서 사용하는 방식<br>
DB 접속 정보를 application이 직접 관리하고 DataSource에 설정해야 함
```
  - application Server 제공하는 DataSource
```
application server가 정의한 DataSource를 JNDI를 통해 가져와서 사용하는 방식<br>
DB 접속 정보를 application server에서 관리 -> application으로부터 DB 관련 정보 분리 & application server가 제공하는 각종 관리 기능도 활용할 수 있다는 장점
```
  - 내장형 DB를 사용하는 DataSource
```
사전에 DB 준비 필요 없이 application 기동할 때 DataSource 설정과 생서이 자동으로 이루어짐<br>
프로토타입용 or 각종 지원툴이나 관리 툴 성격의 application 개발에 많이 활용. (mission-critical한 환경에선느 사용X)
```
## Spring JDBC를 사용하기 전 기본 세팅
  - odbc6.jar (Maven을 통해 해소)
  - spring-jdbc in Maven
  - jdbcTemplate에 내장된 메소드가 가끔 없는 취급 당한다면 -> 다른 버전의 spring-jdbc를 
## 자바 기반 설정을 사용하고 싶다면 (@Configuration)
  - cglib in Maven
## spring jdbc를 유연하게 사용하고 싶다면
  - spring version -> 5.2.6
## spring jdbc -- rowmapper를 lambda식으로 표현하려면 Java SE 1.8 이상이어야 함
## spring을 활용한 validation 방법
  - https://parkwonhui.github.io/spring/2019/04/22/spring-valid-bindingresult.html
  
## Java에서 Annotation을 작성하는 방법
  - https://elfinlas.github.io/2017/12/14/java-custom-anotation-01/

## 예외 처리
  - 예외 종류
```
1. 시스템 예외 : 처리를 계속 할 수 없는 예외.
(application 자체 버그, 의존 라이브러리 버그, 하드웨어 고장, 시스템 리소스 고갈, 네트워크 장애 등)
2. 잘못된 요청 예외 : 잘못된 요청으로 발생하는 예외
(존재하지 않는 경로 요청, 바인딩 오류, 입력값 검사 오류 등)
3. 애플리케이션 예외 : 비즈니스 규칙을 위반했을 때 발생하는 예외
(사용자 등록 시 ID 중복 오류, 재고 부족 오류 등)
```

  - 예외 발생 장소
```
Servlet Filter, DispatcherServlet, Application(Controller,Repository etc), View(JSP etc)
```

  - Exception Handler given by Spring MVC
  : https://cheese10yun.github.io/spring-guide-exception/
  
## RESTful Service
> reference 'REST' package

## Spring Test
> not completed yet
