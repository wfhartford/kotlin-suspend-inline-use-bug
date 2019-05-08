import org.jetbrains.kotlin.gradle.dsl.KotlinCompile
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions

plugins {
  id("org.jetbrains.kotlin.jvm").version("1.3.31")
  application
}

tasks.withType<KotlinCompile<KotlinJvmOptions>> {
  kotlinOptions {
    jvmTarget = "1.8"
  }
}
repositories {
  jcenter()
}

dependencies {
  implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
  implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.2.1")
}

application {
  mainClassName = "ca.cutterslade.kotlin.bug.suspendinlineuse.AppKt"
}
