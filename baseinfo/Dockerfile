# Use AdoptOpenJDK for base image.
FROM registry.cn-hangzhou.aliyuncs.com/knative-sample/openjdk:8-alpine

# Copy the jar to the production image from the builder stage.
COPY  target/baseinfo-*.jar /app/baseinfo.jar

# Run the web service on container startup.
CMD ["java", "-Dserver.port=${PORT}", "-jar","/app/baseinfo.jar"]
