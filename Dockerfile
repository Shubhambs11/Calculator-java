FROM alpine/java:22-jdk

WORKDIR app/

COPY . .

EXPOSE 8080

RUN javac Calculator.java

CMD ["java", "Calculator"]
