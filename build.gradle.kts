import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    java
    id("org.springframework.boot") version "2.2.5.RELEASE"
    id("online.colaba.docker") version "0.1.4"
}

allprojects {

    apply {
        plugin("java")
    }

    group = "org.example"
    version = "1.0-SNAPSHOT"

    configure<JavaPluginConvention> {
        sourceCompatibility = JavaVersion.VERSION_11
    }

    repositories {
        mavenCentral()
    }

    dependencies {
        implementation("ru.relex:library-commons:1.0")
    }
}


dependencies {
    implementation(project(":services"))
    implementation(project(":security"))
    implementation("org.springframework.boot:spring-boot-starter-web:2.2.5.RELEASE")
    testCompile("junit", "junit", "4.12")
}

springBoot {
    mainClassName = "ru.relex.library.rest.LibraryApp"
}


val bootJar: BootJar by tasks

bootJar.apply {
    launchScript()
}

