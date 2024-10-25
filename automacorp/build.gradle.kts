plugins {
	java
	id("org.springframework.boot") version "3.3.4"
	id("io.spring.dependency-management") version "1.1.6"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa") // libs to use JPA in your project
	implementation("com.h2database:h2") // libs to use a H2 database
	implementation ("org.springframework.boot:spring-boot-starter-data-jpa")
	testImplementation ("org.springframework.boot:spring-boot-starter-test")
	testImplementation ("org.assertj:assertj-core:3.22.0")
	implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.2.0")
	testImplementation ("org.hamcrest:hamcrest:2.2")
	implementation ("io.springfox:springfox-boot-starter:3.0.0")
	testImplementation ("org.testng:testng:7.7.0")
	testImplementation ("org.hamcrest:hamcrest:2.2")
	testImplementation ("org.mockito:mockito-core:4.3.1")
	testImplementation ("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
