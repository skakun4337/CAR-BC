FROM java:8
EXPOSE 8080
ADD target/carbc-0.0.1-jar-with-dependencies.jar carbc.jar
ENTRYPOINT ["java","-jar","carbc.jar", "--help"]