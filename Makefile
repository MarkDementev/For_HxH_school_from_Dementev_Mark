build:
	./gradlew clean
	./gradlew installDist
test:
	./gradlew test
lint:
	./gradlew checkstyleMain
	./gradlew checkstyleTest
run:
	./build/install/For_HxH_school_from_Dementev_Mark/bin/For_HxH_school_from_Dementev_Mark

.PHONY: build