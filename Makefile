.PHONY: clean build test compile run install dependencies format lint

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

format:
	@mvn spotless:apply

lint:
	@mvn spotless:check

compile:
	@mvn compile

run: build
	@java -jar target/*.jar