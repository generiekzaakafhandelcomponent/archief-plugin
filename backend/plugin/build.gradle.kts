val kotlinLoggingVersion: String by project
val mockitoKotlinVersion: String by project

dockerCompose {
    setProjectName("archief")
    isRequiredBy(project.tasks.integrationTesting)

    tasks.integrationTesting {
        useComposeFiles.addAll("$rootDir/docker-resources/docker-compose-base-test.yml", "docker-compose-override.yml")
    }
}

dependencies {
    compileOnly("com.ritense.valtimo:case")
    compileOnly("com.ritense.valtimo:core")
    compileOnly("com.ritense.valtimo:contract")
    compileOnly("com.ritense.valtimo:process-document")
    compileOnly("com.ritense.valtimo:plugin-valtimo")
    compileOnly("com.ritense.valtimo:notificaties-api")
    compileOnly("com.ritense.valtimo:zaken-api")

    compileOnly("io.github.oshai:kotlin-logging:$kotlinLoggingVersion")
    compileOnly("org.springframework.boot:spring-boot-starter")
    compileOnly("org.springframework.boot:spring-boot-starter-data-jpa")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.mockito.kotlin:mockito-kotlin:$mockitoKotlinVersion")
    testImplementation("org.mockito:mockito-core")
    testImplementation("org.junit.jupiter:junit-jupiter")
}

apply(from = "gradle/publishing.gradle")
