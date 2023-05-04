## trace-demo
### Purpose
- Dynatrace integration

### Through gateway API call test
```shell
> curl \
-H 'Content-Type: application/json' \
http://localhost:8900/trace

{
  "user-agent" : "curl/7.86.0",
  "accept" : "*/*",
  "content-type" : "application/json",
  "forwarded" : "proto=http;host=\"localhost:8900\";for=\"127.0.0.1:65377\"",
  "x-forwarded-for" : "127.0.0.1",
  "x-forwarded-proto" : "http",
  "x-forwarded-port" : "8900",
  "x-forwarded-host" : "localhost:8900",
  "host" : "localhost:8902",
  "content-length" : "0"
}
```