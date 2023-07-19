#Makefile

.DEFAULT_GOAL := build-run

clean:
	./gradlew clean

build:
	./gradlew clean build

install:
	./gradlew clean install

run-distJson: #start APP with json
	./build/install/app/bin/app file3.json file4.json

run-distYaml: #start APP with yml
	./build/install/app/bin/app file1.yml file2.yml

run:
	./gradlew run

test:
	./gradlew test

report:
	./gradlew jacocoTestReport

lint:
	./gradlew checkstyleMain checkstyleTest

update-deps:
	./gradlew useLatestVersions

build-run: build run

.PHONY: build

.PHONY: app
