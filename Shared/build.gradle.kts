import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.6.21"
    id("org.springframework.boot") version "2.7.0"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("plugin.spring") version "1.6.21"
}


group = "tutorial.shared"
version = "1.0"

repositories {
    mavenCentral()
}
buildscript {
    repositories {
        maven {
            url = uri("https://plugins.gradle.org/m2/")
        }
    }
    dependencies {
        classpath("org.openapitools:openapi-generator-gradle-plugin:6.0.0")
    }
}

apply(plugin = "org.openapi.generator")
dependencies {
    implementation("jakarta.annotation:jakarta.annotation-api:2.1.0")
    implementation("io.swagger.core.v3:swagger-core:2.2.0")
    testImplementation(kotlin("test"))
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-validation:2.7.0")
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-security:2.7.0")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    implementation("org.springdoc:springdoc-openapi:1.6.9")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "17"
    }
}


tasks.withType<Test> {
    useJUnitPlatform()
}

java.sourceSets["main"].java {
    srcDir("$buildDir/kotlin/src/main/kotlin")
}

tasks.create<org.openapitools.generator.gradle.plugin.tasks.GenerateTask>("buildKotlinSpring"){
    generatorName.set("kotlin-spring")
    inputSpec.set("$projectDir/specs/basic.yml")
    outputDir.set("$buildDir/kotlin")
    apiPackage.set("gen.api")
    modelPackage.set("gen.model")
    configOptions.put("delegatePattern", "true")

}

tasks.withType<JavaCompile> {
    dependsOn(
        //if Shared should be rebuild after each Compile
        //leads to a slower start
        // I prefer to start it manual
        tasks.getByName("buildKotlinSpring"),
    )
}