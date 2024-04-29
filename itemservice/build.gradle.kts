import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "3.2.5"
    id("io.spring.dependency-management") version "1.1.4"
    kotlin("jvm") version "1.9.23"
    kotlin("plugin.spring") version "1.9.23"
}
val springCloudVersion by extra("2023.0.1")

group = "org.msa"
version = "0.1"

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
}

dependencyManagement {
    imports {
        //mavenBom("org.springframework.cloud:spring-cloud-dependencies:2022.0.0")
    }
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.jetbrains.kotlin:kotlin-reflect:1.6.21")

    implementation(group = "org.mariadb.jdbc", name = "mariadb-java-client", version = "3.1.2")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation(group = "org.springdoc", name = "springdoc-openapi-starter-webmvc-ui", version = "2.0.2")
    //implementation("org.springframework.cloud:spring-cloud-starter-config")
    //implementation("org.springframework.cloud:spring-cloud-starter-bootstrap")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    //implementation("org.springframework.cloud:spring-cloud-starter-netflix-eureka-client")
    implementation("org.json:json:20200518")
    implementation(group = "io.micrometer", name = "micrometer-tracing-bridge-brave", version = "1.1.1")
    implementation(group = "io.zipkin.reporter2", name = "zipkin-reporter-brave", version = "2.16.3")
    //implementation("org.springframework.cloud:spring-cloud-starter-openfeign")
    implementation(group = "org.springframework.boot", name = "spring-boot-starter-activemq", version = "3.1.0")
    implementation(group = "org.apache.activemq", name = "activemq-broker", version = "5.18.1")
    implementation("org.springframework.kafka:spring-kafka")
    //implementation("io.github.resilience4j:resilience4j-spring-boot2")

    compileOnly("org.projectlombok:lombok")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
    annotationProcessor("org.projectlombok:lombok")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs += "-Xjsr305=strict"
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
