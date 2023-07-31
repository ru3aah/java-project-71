#Makefile

.DEFAULT_GOAL := build-run

clean:
	./gradlew clean

build:
	./gradlew clean build

install:
	./gradlew clean install

run-distJson: #start APP with json default format
	./build/install/app/bin/app file3.json file4.json

run-distYaml: #start APP with yml default format
	./build/install/app/bin/app file3.yml file4.yml

run-distJsonPlain: #start APP with json and Plain result
	./build/install/app/bin/app file3.json file4.json -f plain

run-distYmlJson: #start APP with yml Json format
	./build/install/app/bin/app file3.yml file4.yml -f json

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
