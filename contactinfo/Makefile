all: v1 v2

MVN_HOME := "${HOME}/.m2"
jar-v1: 
	@echo "build v1 jar"
	cp -f `pwd`/data/v1/contact.json `pwd`/src/main/resources/
	docker run -it --rm --entrypoint=sh -v `pwd`:/app -v ${MVN_HOME}:/root/.m2 registry.cn-hangzhou.aliyuncs.com/knative-sample/maven:3.6.1-jdk-8-alpine -c 'cd /app && /usr/local/bin/mvn-entrypoint.sh mvn -DskipTests=true package '

jar-v2: 
	@echo "build v2 jar"
	cp -f `pwd`/data/v2/contact.json `pwd`/src/main/resources/
	docker run -it --rm --entrypoint=sh -v `pwd`:/app -v ${MVN_HOME}:/root/.m2 registry.cn-hangzhou.aliyuncs.com/knative-sample/maven:3.6.1-jdk-8-alpine -c 'cd /app && /usr/local/bin/mvn-entrypoint.sh mvn -DskipTests=true package '

v1: jar-v1
	@echo "build docker image"
	./build-image.sh cms-contactinfo

v2: jar-v2
	@echo "build docker image"
	./build-image.sh cms-contactinfo
