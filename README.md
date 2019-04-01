## Starter API app

### Quick start
```
$ gradle bootRun  --debug-jvm
$ curl http://localhost:8080/ ; echo $line;
```

Helper commands
```
 kill -9 $(ps -ef | grep gradle | grep -v grep | awk '{print $2}')
```