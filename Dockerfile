# FROM azul/zulu-openjdk:11-latest
FROM azul/zulu-openjdk-alpine:11-latest
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar

# EXPOSE 8080 #npm으로 연결
ENTRYPOINT ["java","-jar","/app.jar"]
# ENTRYPOINT ["java","-jar","-Dspring.profiles.active=prod","/app.jar"] #프로파일 설정
# => 설정파일(properties)을 분리해서 사용할 때
# java -jar -Dspring.profiles.active=prod app.jar