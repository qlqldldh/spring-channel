# Notes to use Spring framework effectively

1. @Bean v.s. @Component의 차이점
  - https://galid1.tistory.com/494
2. @Qualifier / @Resource를 사용하는 이유
  - 같은 Interface를 구현하는 클래스가 여러 개 있는 경우, 어떤 구현 클래스를 써야할지 IoC Container가 결정하지 못함
  - @Qualifier에서 빈 이름 설정 시 구현 관련 정보가 포함되지 않도록 유의해야 함 / 대신  역할, 사용목적, 용도를 이름으로 명명하는 것이 좋음
  
