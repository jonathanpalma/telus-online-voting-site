name := """telus-online-voting-site"""

version := "1.0-SNAPSHOT"

playJavaSettings

ebeanEnabled := false

libraryDependencies ++= Seq(
    javaJpa.exclude("org.hibernate.javax.persistence", "hibernate-jpa-2.0-api"),
    javaCore,
    javaJpa,
    //Database & persistence
    "org.hibernate" % "hibernate-entitymanager" % "4.3.8.Final",
    "mysql" % "mysql-connector-java" % "5.1.18",
    //Dependency injection
    "javax.inject" % "javax.inject" % "1",
    "org.springframework" % "spring-context" % "4.0.3.RELEASE",
    "org.springframework" % "spring-expression" % "4.0.3.RELEASE",
    "org.springframework.data" % "spring-data-jpa" % "1.7.2.RELEASE",
    "org.springframework" % "spring-orm" % "3.2.8.RELEASE",
    //Migration
    "com.github.tototoshi" %% "play-flyway" % "1.0.4",
    //Crypto
    "org.mindrot" % "jbcrypt" % "0.3m"
)