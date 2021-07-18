FROM openjdk:11-jre

WORKDIR ficha-tecnica-api

COPY target/*.jar /ficha-tecnica-api/app.jar

EXPOSE 8080

CMD java -XX:+UseContainerSupport -Xmx512m -jar app.jar --server.port=$PORT

