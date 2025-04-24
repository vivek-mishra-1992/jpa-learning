FROM openjdk:11
ADD ./target/jpalearning-1.0.jar jpalearning-1.0.jar
ENTRYPOINT ["java","-jar","/jpalearning-1.0.jar"]
