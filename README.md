# 쇼핑몰 REST API
> 상품정보와 회원로그인,회원가입등을 제공하는 SpringBoot Rest API 입니다. 
----------------------------------------
### 서비스
전체 상품조회
- ~/api/v1/posts/listall 


-------------------------------------
# application-real-db.properties 파일을 별도로 추가하여 DB와 연결
spring.jpa.hibernate.dd1-auto=none
spring.datasource.url=jdbc:mariadb://
spring.datasource.username=
spring.datasource.password=
spring.datasource.drive-class-name=org.mariadb.jdbc.Driver