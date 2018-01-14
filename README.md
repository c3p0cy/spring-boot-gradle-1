Gralde Practice with Spring Boot
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
5. See the testing result: <your path of project>/build/customJacocoReportDir/test/html/index.html

----------------------------------------------------------
## References:
1. [Chapter 65. The JaCoCo Plugin](https://docs.gradle.org/current/userguide/jacoco_plugin.html)
2. [gradle複習(6)-深入Jacoco](https://www.kancloud.cn/digest/itfootball-gradle/105819)
3. [用Gradle构建Spring Boot项目](http://www.cnblogs.com/davenkin/p/gradle-spring-boot.html)