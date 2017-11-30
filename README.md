streaming-pipeline
==================

Http API application thats consumes the requests and puts into any kind 
stream.

Getting Started
---------------

1. start `sbt`
2. `sbt> compile`
3. `sbt> run`
4. Use the api

```bash
curl -XPOST -H "Content-Type: application/json" http://localhost:9191/ingest -d '{ "name": "some new package" }'
{
  "status": "Ok"
}
```

```bash
curl -XGET http://localhost:9191/events
[{
  "name": "application started"
}, {
  "name": "some new package"
}]
```

Technologies Used
-----------------

```
Akka HTTP
Scala 2.12.4
Sbt 0.13.0
```


References
----------

http://doc.akka.io/docs/akka-stream-and-http-experimental/1.0-M2/scala/http/

http://doc.akka.io/docs/akka/2.4.7/scala/http/
