plugins {
    java
}

allprojects {

    apply {
        plugin("java")
    }

    group = "ru.relex"
    version = "1.0-SNAPSHOT"

    configure<JavaPluginConvention> {
        sourceCompatibility = JavaVersion.VERSION_11
    }

    repositories {
        mavenCentral()
    }
}


dependencies {
    implementation(project(":data"))
    implementation("org.springframework.boot:spring-boot-starter-web:2.2.5.RELEASE")
    testCompile("junit", "junit", "4.12")
}
