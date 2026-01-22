plugins {
    java
    id("org.springframework.boot") version "3.4.4"
    id("io.spring.dependency-management") version "1.1.7"
    id("org.sonarqube") version "3.5.0.2730"
    id("jacoco")
}

group = "com.amit.security"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")
    runtimeOnly("org.postgresql:postgresql")
    implementation("io.jsonwebtoken:jjwt-api:0.11.5")
    implementation("io.jsonwebtoken:jjwt-impl:0.11.5")
    implementation("io.jsonwebtoken:jjwt-jackson:0.11.5")
    implementation("dev.samstevens.totp:totp:1.7.1")
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.1.0")

    runtimeOnly("com.h2database:h2")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.security:spring-security-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.test {
    finalizedBy("jacocoTestReport")

    jvmArgs = listOf(
        "--add-opens=java.base/java.lang=ALL-UNNAMED",
        "--add-opens=java.base/java.util=ALL-UNNAMED",
        "--add-opens=java.base/java.lang.reflect=ALL-UNNAMED",
        "--add-opens=java.base/java.text=ALL-UNNAMED",
        "--add-opens=java.desktop/java.awt.font=ALL-UNNAMED"
    )
}

tasks.jacocoTestReport {
    dependsOn("test")

    reports {
        xml.required.set(true)
        html.required.set(true)
        csv.required.set(true)
    }
}


tasks.jacocoTestCoverageVerification {
    violationRules {
        rule {
            enabled = true
            limit {
                minimum = BigDecimal(0.01)
            }
        }
    }
}

tasks.getByName("check") {
    dependsOn("jacocoTestCoverageVerification")
}

sonar {
    properties {
        property("sonar.projectKey", "secure-authentication-be")
        property("sonar.name", "secure-authentication-be")
        property("sonar.token", "sqp_3c04f0e8b7a5c3e4cbfdd2ca3e137552b8e9c74d")
        property("sonar.host.url", "http://sonarqube:9000")
        property("sonar.sources", "src/main/java")
        property("sonar.sources", "src/test/java")
    }
}
