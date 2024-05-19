plugins {
    kotlin("jvm")
}

dependencies {
    implementation(libs.result4k)
    implementation(libs.tuples4k)
    
    testImplementation(libs.bundles.junit)
}
