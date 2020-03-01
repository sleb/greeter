FROM openjdk:13-alpine
COPY . /
RUN ./gradlew installDist
EXPOSE 8000
CMD ./build/install/greeter/bin/greeter
