# Notes to use Spring framework effectively

1. @Bean v.s. @Component의 차이점
  - https://galid1.tistory.com/494
2. @Qualifier / @Resource를 사용하는 이유
  - 같은 Interface를 구현하는 클래스가 여러 개 있는 경우, 어떤 구현 클래스를 써야할지 IoC Container가 결정하지 못함
  - @Qualifier에서 빈 이름 설정 시 구현 관련 정보가 포함되지 않도록 유의해야 함 / 대신  역할, 사용목적, 용도를 이름으로 명명하는 것이 좋음
  
3. spring의 DataSource
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
4. Spring JDBC를 사용하기 전 기본 세팅
  - odbc6.jar (Maven을 통해 해소)
  - spring-jdbc in Maven
  - jdbcTemplate에 내장된 메소드가 가끔 없는 취급 당한다면 -> 다른 버전의 spring-jdbc를 
5. 자바 기반 설정을 사용하고 싶다면 (@Configuration)
  - cglib in Maven
