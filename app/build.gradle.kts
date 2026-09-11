import java.util.Properties

plugins {
    id("io.github.supermonster003.autojs6-native-alignment")
    id("org.autojs.build.utils")
    id("org.autojs.build.versions")
    id("org.autojs.build.signs")
    id("org.autojs.build.jvm-convention")
    id("com.android.application")
}

val globalApplicationId = "io.github.supermonster003.autojs6.plugin.pinyin4j"

var isSignsValid = false

android {
    namespace = globalApplicationId
    compileSdk = versions.sdkVersionCompile

    defaultConfig {
        applicationId = globalApplicationId

        minSdk = versions.sdkVersionMin
        targetSdk = versions.sdkVersionTarget

        versionCode = versions.appVersionCode
        versionName = versions.appVersionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        resValue("string", "app_name", "Pinyin4j")
        resValue("string", "plugin_author", "SuperMonster003")
        resValue("string", "plugin_id", "pinyin4j")
        resValue("string", "plugin_engine", "pinyin4j")
        resValue("string", "plugin_variant", "default")
        resValue("string", "plugin_version_date", utils.getDateString("MMM d, yyyy", "GMT+08:00"))
    }

    signingConfigs {
        val props = Properties().also { props ->
            File("${project.rootDir}/sign.properties").takeIf { it.exists() }?.let { file ->
                file.inputStream().use { props.load(it) }
                isSignsValid = props.isNotEmpty()
            }
        }
        if (isSignsValid) {
            create("release") {
                storeFile = props["storeFile"]?.let { file(it as String) }
                keyPassword = props["keyPassword"] as String
                keyAlias = props["keyAlias"] as String
                storePassword = props["storePassword"] as String
            }
        }
    }

    buildTypes {
        val niceSigningConfig = takeIf { isSignsValid }?.let {
            signingConfigs.getByName("release")
        }
        debug {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro",
            )
            niceSigningConfig?.let { signingConfig = it }
        }
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro",
            )
            niceSigningConfig?.let { signingConfig = it }
        }
    }

    buildFeatures {
        aidl = true
        resValues = true
    }

}

dependencies {
    implementation(files("$rootDir/libs/common-plugin-api.aar"))
    implementation(files("$rootDir/libs/pinyin4j-api.aar"))
    implementation(libs.pinyin4j)

    testImplementation(libs.junit)

    androidTestImplementation(libs.test.ext.junit)
    androidTestImplementation(libs.test.runner)
}

tasks {
    withType(JavaCompile::class.java) {
        options.encoding = "UTF-8"
    }

    val benchmarkPinyin4j = register<JavaExec>("benchmarkPinyin4j") {
        group = "verification"
        description = "Runs the non-gating Pinyin4j JVM throughput baseline."
        dependsOn("compileDebugUnitTestKotlin")
        mainClass.set("io.github.supermonster003.autojs6.plugin.pinyin4j.Pinyin4jBenchmark")
    }
    project.afterEvaluate {
        val debugUnitTests = named<Test>("testDebugUnitTest").get()
        benchmarkPinyin4j.configure {
            classpath(debugUnitTests.classpath, debugUnitTests.testClassesDirs)
        }
    }
}

// Reject accidental native dependencies on every ABI.
nativeAlignment { expectNoNativeLibraries.set(true) }
