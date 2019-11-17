# Use AdoptOpenJDK for base image.
FROM registry.cn-hangzhou.aliyuncs.com/knative-sample/openjdk:8-alpine

# Copy the jar to the production image from the builder stage.
COPY  target/contactinfo-*.jar /app/contactinfo.jar

# Run the web service on container startup.
# CMD ["java","-Djava.security.egd=file:/dev/./urandom","-Dserver.port=${PORT}","-jar","/app/contactinfo.jar"]
CMD ["java", "-Dserver.port=${PORT}","-jar", "/app/contactinfo.jar"]
