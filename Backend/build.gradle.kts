
plugins {
    kotlin("jvm") version "1.6.21"
    id("org.springframework.boot") version "2.7.0"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("plugin.spring") version "1.6.21"
    kotlin("plugin.allopen") version "1.4.32"
    id ("org.jetbrains.kotlin.plugin.noarg") version "1.6.21"
    id ("org.jetbrains.kotlin.plugin.jpa") version "1.6.21"
    application
}
noArg {

}
allOpen {
    annotation("javax.persistence.Entity")
    annotation("javax.persistence.Embeddable")
    annotation("javax.persistence.MappedSuperclass")
}

group = "padas.group1"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":Shared"))
    implementation("org.springframework.boot:spring-boot-starter-security")
    testImplementation(kotlin("test"))
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    implementation("org.springframework.boot:spring-boot-configuration-processor")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-actuator-autoconfigure:2.7.0")
    implementation("org.springframework.boot:spring-boot-starter-validation:2.7.0")

    //db
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:2.7.0")
    implementation("org.xerial:sqlite-jdbc:3.32.3.2")
    implementation("com.github.gwenn:sqlite-dialect:0.1.0")

    implementation("io.swagger.core.v3:swagger-core:2.2.0")
}

application {
    mainClass.set("default.MainKt")
}
