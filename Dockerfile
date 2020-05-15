FROM openjdk:11-jdk as warBuilder
WORKDIR /api
COPY ./api .
RUN ./gradlew bootWar


FROM tomcat:9.0.35-jdk11-openjdk
#COPY ./web/static /usr/local/tomcat/webapps/ROOT
COPY --from=warBuilder /api/build/libs/pihd-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/pihd.war