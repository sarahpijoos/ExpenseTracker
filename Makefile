.PHONY: clean build test compile run

clean:
	@mvn clean

build:
	@mvn clean install package


test:
	@mvn test

compile:
	@mvn compile

run: build
	@java -jar target/*.jar