Gralde Practice with Spring Boot
----------------------------------------------------------
Java:
  1. apply plugin: 'java'
  2. now can run: gradle build 
----------------------------------------------------------
Gradle Wrapper:  
  *  Benefits:   
     * 不用安裝 gradle 也能運行 gradle
     * 所有人使用相同的 gradle 版本
  *  Step:
    1. Add Task:
        ```groovy
       task wrapper(type: Wrapper) {
           gradleVersion = '4.4.1'
       }
        ```
    2. run: gradle wrapper 
       - 這三個文件（夾）都需要提交到代碼庫中！如此在沒有安裝 Gradle 時，也可以透過 gradlew buiild 來進行專案建置。
       - 如此持續集成（CI）的CI機器也沒有必要安裝 Gradle 了。
       - 此時所有人都是使用的相同版本的 gradle，進而避免了由於版本不同所帶來的問題。
----------------------------------------------------------
Spring Boot:
  1. Setting:
     ```groovy
      buildscript {
          repositories {
              jcenter()
          }
          dependencies {
              classpath("org.springframework.boot:spring-boot-gradle-plugin:1.5.9.RELEASE")
          }
      }
      
      repositories {
          jcenter()
      }
      
      apply plugin: 'org.springframework.boot'
      
      sourceCompatibility = 1.8
      targetCompatibility = 1.8
      
      dependencies {
          compile("org.springframework.boot:spring-boot-starter-web")
          testCompile("org.springframework.boot:spring-boot-starter-test")
      }
     ``` 
  2. run: gradle booRun
 3. invoke http://localhost:8080/[path]
----------------------------------------------------------
Code Coverage: jacoco
1. apply plugin: "jacoco"
2. set config:
    ```groovy
    jacoco {
        toolVersion = "0.7.9" // version of jacoco library
        reportsDir = file("$buildDir/customJacocoReportDir") // where to store reports
    }
    
    jacocoTestReport{
        reports{
            xml.enabled false
            csv.enabled false
            html.enabled true
            html.destination "${buildDir}/jacocoHtml"
            xml.destination "${buildDir}/jacocoXml.xml"
            csv.destination "${buildDir}/jacocoCsv.csv"
        }
    }
    ```
3. run: clean test
4. run: jacocoTestReport
5. See the testing result: [your path of project]/build/customJacocoReportDir/test/html/index.html

----------------------------------------------------------
## References:
1. [Chapter 65. The JaCoCo Plugin](https://docs.gradle.org/current/userguide/jacoco_plugin.html)
2. [gradle複習(6)-深入Jacoco](https://www.kancloud.cn/digest/itfootball-gradle/105819)
3. [用Gradle构建Spring Boot项目](http://www.cnblogs.com/davenkin/p/gradle-spring-boot.html)