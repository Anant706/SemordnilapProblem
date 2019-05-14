plugins {
  java
  pmd
  jacoco
  application
}       

repositories {
	mavenCentral()
}

dependencies {
  testCompile("org.junit.jupiter:junit-jupiter-api:5.2.0")
  testRuntime("org.junit.jupiter:junit-jupiter-engine:5.2.0")
  testRuntime("org.junit.platform:junit-platform-console:1.2.0")
  testCompile("org.mockito:mockito-core:1.+")
  implementation("com.google.code.gson:gson:2.8.5") 
}
 
sourceSets {
  main {
    java.srcDirs("SampleProject/src")
    resources.srcDirs("SampleProject/src")
  }
  test {
    java.srcDirs("SampleProject/test")
  }
}

val test by tasks.getting(Test::class) {
	useJUnitPlatform {}
}

tasks {
  val treatWarningsAsError =
    listOf("-Xlint:unchecked", "-Xlint:deprecation", "-Werror")

  getByName<JavaCompile>("compileJava") {
    options.compilerArgs = treatWarningsAsError      
  }

  getByName<JavaCompile>("compileTestJava") {
    options.compilerArgs = treatWarningsAsError
  }

    getByName<JacocoReport>("jacocoTestReport") {
    afterEvaluate {
      getClassDirectories().setFrom(files(classDirectories.files.map {
        fileTree(it) { exclude("**/SemordnilapApplication.class") }
      }))
    }
  }
}

tasks {
    getByName<JacocoReport>("jacocoTestReport") {
        afterEvaluate {
            setClassDirectories(files(classDirectories.files.map {
                fileTree(it) { exclude("**/ui/**") }
            }))
        }
    }
} 

pmd {
  ruleSets = listOf()
  ruleSetFiles = files("conf/pmd/ruleset.xml")
}

application {
  mainClassName = "exam.SemordnilapApplication"
  
}

defaultTasks("clean", "test", "jacocoTestReport", "pmdMain")
