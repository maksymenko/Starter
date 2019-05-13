## Starter API app

### Quick start
```
$ gradle bootRun  --debug-jvm
$ curl http://localhost:8080/books/ ; echo $line;
```

### cmd helper
```
./gradlew build && java -jar build/libs/gs-spring-boot-0.1.0.jar
 kill -9 $(ps -ef | grep gradle | grep -v grep | awk '{print $2}')
```

### db helper
```
mysql>  create user 'dev'@'localhost' identified by 'dev';
mysql>  GRANT ALL PRIVILEGES ON *.* To 'dev'@'localhost';
mysql>  CREATE DATABASE starter;
```

### OAuth 2.0
* Setup OAuth project  `https://console.developers.google.com/`
```
"Credentials" > "Create Credentials" > "OAuth Client ID"
```
** Setup redirect URL


### Resources:
  * https://spring.io/guides/tutorials/spring-boot-oauth2/
  * https://www.baeldung.com/spring-security-oauth-principal-authorities-extractor
  * https://www.baeldung.com/get-user-in-spring-security
  * https://docs.spring.io/spring-security/site/docs/current/reference/html/jc.html


### TODO:
* add unit tests
* test configuration for db
* add OAuth
* add REST client
* add UI client