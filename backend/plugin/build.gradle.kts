val kotlinLoggingVersion: String by project
val mockitoKotlinVersion: String by project

dockerCompose {
    setProjectName("archief")
    isRequiredBy(project.tasks.integrationTesting)

    tasks.integrationTesting {
        useComposeFiles.addAll("$rootDir/docker-resources/docker-compose-base-test.yml")
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

    // Testing
    testImplementation("com.ritense.valtimo:building-block")
    testImplementation("com.ritense.valtimo:contract")
    testImplementation("com.ritense.valtimo:core")
    testImplementation("com.ritense.valtimo:plugin")
    testImplementation("com.ritense.valtimo:temporary-resource-storage")
    testImplementation("com.ritense.valtimo:test-utils-common")

    testImplementation("org.springframework.boot:spring-boot-starter-test")

    testImplementation("org.postgresql:postgresql")

    testImplementation("com.ritense.valtimo:case")
    testImplementation("com.ritense.valtimo:process-document")
    testImplementation("com.ritense.valtimo:plugin-valtimo")
    testImplementation("com.ritense.valtimo:notificaties-api")
    testImplementation("com.ritense.valtimo:zaken-api")
}

apply(from = "gradle/publishing.gradle")
