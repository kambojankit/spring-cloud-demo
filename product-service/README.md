#Accessing Services

Swagger is configured in the project, so the service endpoints can be accessed at: 
[http://localhost:8070/swagger-ui.html](http://localhost:8070/swagger-ui.html)

#Accessing H2 DB

After starting the application, access the link: [http://localhost:8070/h2-console](http://localhost:8070/h2-console), and use below mentioned configs for accessing the In-memory DB:

```
JDBC URL: jdbc:h2:mem:testdb
User Name: sa
Pasword: <leave this empty>
```
