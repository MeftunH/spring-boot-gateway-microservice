## Gateway microservice

## Endpoints
#### Sign up
```aidl
https://spring-gateway-microservice.herokuapp.com/api/v1/authentication/sign-up
```
request body
```aidl
{
    "username": "demo",
	"password":"demo",
	"name":"demo"
}
```
return json
```aidl
{
	"id": 1,
	"username": "demo",
	"password": "$2a$10$W9aW5rXdUyy9cqXVcqHeeOLUPbXL4A/.3AkFmWXLqEjdnyA2BKCLW",
	"name": "demo",
	"createdAt": "2022-06-29"
}
```


#### Sign in
```aidl
https://spring-gateway-microservice.herokuapp.com/api/v1/authentication/sign-in```
request body
```aidl
{
    "username": "demo",
	"password":"demo"
}
```
return json as a bearer token
```aidl
{
	eyJhbGciOiJSUzUxMiJ9.eyJzdWIiOiJkZW1vIiwidXNlcklkIjoxLCJyb2xlcyI6IlVTRVIiLCJleHAiOjE2NTY1NTk1NDh9.YTVvI_7ZP3GwvszwAf8YXWBSVEaOK3p68RUoB1ISmL-b1xAtw558AAttCqZEGgxQEV-SYFTW_McMf4XKfcN2Q20AhkGvshutnvPsxMt5JSAr2FNDtZXZ6n9vDt2_Zh203MCJ9Non_rC2WyC0SrzQLnCx1BPMOU0aTC-wBndP3Ktl3k7qTvslXMhjBmpzckUZmqqpo3l9vWhzQVR2Cp2ye7MOd-uJaP7CQTcTnZ3i-szq2yNrsplzRT0CUCJ-MDRKfgn2E-_aKp7WQORa67_RYWvELeRZtVr_a0QmbfsOUAAqlH0jkzr4gVYr7mZDaAmumH5p6B6Jo8V5F_9ajvYLxw
}
```
#### Production
```aidl
https://spring-gateway-microservice.herokuapp.com/api/v1/gateway/production
```
#### Transcation
```aidl
https://spring-gateway-microservice.herokuapp.com/api/v1/gateway/transaction
```