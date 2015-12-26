# SpringBoot
spring boot example

## 内嵌Tomcat启动

```
   <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
   </dependency>

   <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-actuator</artifactId>
   </dependency>
```

## 独立部署

```
   <dependency>
       <groupId>org.springframework.boot</groupId>
       <artifactId>spring-boot-starter-web</artifactId>
       <exclusions>
            <exclusion>
                 <groupId>org.springframework.boot</groupId>
                 <artifactId>spring-boot-starter-tomcat</artifactId>
            </exclusion>
       </exclusions>
   </dependency>
   <dependency>
       <groupId>org.apache.tomcat</groupId>
       <artifactId>tomcat-servlet-api</artifactId>
       <version>7.0.42</version>
       <scope>provided</scope>
   </dependency>
```
