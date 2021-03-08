# Shopping Cart Service
This is a microservice application for shopping cart (create cart, order ...).

## The software development principles, patterns & practices
1. Using CommonsRequestLoggingFilter of spring boot & HandleInterceptor to log all request.
2. RequestBodyAdviceAdapter to log all request body if any.
3. All request logs are saved in database using async method to keep track the activity of users.
4. Apply Spring Cloud Sleuth for distributed tracing. 
5. Using Jpa Audit.
6. Using RestTemplate to demo the communication with Product Service

## Code folder structure, libs & framework
### Define package based on uses.
For example:

com.nab.assignment.shoppingcart: root package.

com.nab.assignment.shoppingcart.config.requestlog: group all classes related for request log config.

### Some key libs & framework
1. Spring boot starter web.
2. Spring boot starter jpa.
3. Spring boot starter logging.
4. Spring boot starter validation.
5. Spring boot starter test.
6. Spring boot configuration processor.
7. Lombok.
8. Apache common libs: lang3 & collections4.
9. Gson.

## Development
### Required environment
1. JDK 8.
2. Maven 3.
4. PostgreSQL server.

### Start application on local computer
#### Requirement
1. Install PostgreSQL server on local computer.
2. Create database nab_product.
3. Change database config from application-local.yml. For example: 
```
  datasource:
    url: jdbc:postgresql://localhost:5432/nab_shoppingcart
    username: postgres
    password: 2020
```
#### Run application in local:
```$xslt
mvn spring-boot:run -Dspring-boot.run.profiles=local
```
Root path: http://localhost:8082/api

#### All CURL commands
Get info of application
```$xslt
curl --location --request GET 'localhost:8082/api/about-us/info'
```

Get shopping cart details
```$xslt
curl --location --request GET 'localhost:8082/api/cart/1c5601f6-d752-4cc4-9437-501a14e28439'
```

Create shopping cart
```$xslt
curl --location --request POST 'http://localhost:8082/api/cart/create'
```

Add new item to cart
```$xslt
curl --location --request POST 'localhost:8082/api/cart/add-new-item' \
--header 'Content-Type: application/json' \
--data-raw '{
    "cart_id": "1c5601f6-d752-4cc4-9437-501a14e28439",
    "product_id": "9ccd5440-f22e-42c4-9be3-6ea36874d9f8"
}'
```

Update item in cart
```$xslt
curl --location --request POST 'localhost:8082/api/cart/update-item' \
--header 'Content-Type: application/json' \
--data-raw '{
    "cart_id": "1c5601f6-d752-4cc4-9437-501a14e28439",
    "product_id": "9ccd5440-f22e-42c4-9be3-6ea36874d9f8",
    "quantity": 1
}'
```
















