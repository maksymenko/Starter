## Starter API app

### Quick start
```
$ gradle bootRun  --debug-jvm
$ curl http://localhost:8080/ ; echo $line;
```

### cmd helper
```
./gradlew build && java -jar build/libs/gs-spring-boot-0.1.0.jar
 kill -9 $(ps -ef | grep gradle | grep -v grep | awk '{print $2}')
```

### db helper
```
mysql> create user 'dev'@'localhost' identified by 'dev';
mysql>  GRANT ALL PRIVILEGES ON *.* To 'dev'@'localhost';
mysql> CREATE DATABASE starter;
```

### TODO:
* add logger
* add unit tests
* test configuration for db
* add OAuth
* add REST client
* add UI client