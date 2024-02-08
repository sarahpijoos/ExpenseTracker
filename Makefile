.PHONY: clean build test compile run install dependencies

clean:
	@mvn clean

install:
	@mvn clean install

build:
	@mvn clean package

dependencies:
	@mvn dependency:resolve dependency:resolve-plugins

test:
	@mvn test

compile:
	@mvn compile

run: build
	@java -jar target/*.jar