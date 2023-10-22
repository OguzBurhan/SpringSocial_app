plugins {
	java
	id("org.springframework.boot") version "3.1.5"
	id("io.spring.dependency-management") version "1.1.3"
}

group = "com.example.gbc_springsocial54"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-mongodb")
	implementation("org.springframework.boot:spring-boot-starter-web")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	implementation ("org.projectlombok:lombok:1.18.22")
	annotationProcessor ("org.projectlombok:lombok:1.18.22")
	testCompileOnly ("org.projectlombok:lombok:1.18.22")

}

tasks.withType<Test> {
	useJUnitPlatform()
}
