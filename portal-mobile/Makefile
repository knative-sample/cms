all: jar image

MVN_HOME := "${HOME}/.m2"
jar:
	@echo "build jar"
	docker run -it --rm --entrypoint=sh -v `pwd`:/app -v ${MVN_HOME}:/root/.m2 registry.cn-hangzhou.aliyuncs.com/knative-sample/maven:3.6.1-jdk-8-alpine -c 'cd /app && /usr/local/bin/mvn-entrypoint.sh mvn -DskipTests=true package '

image:
	@echo "build docker image"
	./build-image.sh cms-portal-mobile

