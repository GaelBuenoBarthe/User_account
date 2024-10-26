# User Account Management

## Clone the repository

```bash
git clone https://github.com/GaelBuenoBarthe/User_account.git
cd User_account
```

## Technology Stack

- Java 11
- Spring Boot
- Spring Rest
- MongoDB

## Task Description

The account user interface allows retrieving commerce catalog data. Catalog items include:  

- Categories
- Products
- SKUs
- Dynamic Attributes

Dynamic Attributes can be joined for Products and SKUs. The user (seller) must have the opportunity to add their items as SKUs based on the general SKU from the product catalog. This means the product catalog must be the same for all registered users. Each registered user can choose items from the Product Catalog, fill up all necessary fields defined by the Site Administrator, and then save their instance of the item to the common list of SKUs in their company/seller profile.  

## Technical Implementation

The architecture for all the components in the project has strict rules and requirements. Below is the list of components that must be implemented:

- **Repository for seller SKUs**
- **Seller SKU object** must have a list of paths to store image URLs.
- **Service for managing seller SKUs (SKUs)**, including dependency management between relations in objects. We use MongoDB and mostly the @DBRef annotation to make relations between objects.
- 
**Example**

EmbeddedBean
 ```java
public class EmbeddedBean {
    private String id; // e.g., "prod123"
    private String name; // e.g., "Test Product"
    private String repositoryName; // e.g., "profileRepository"

    // Getters and Setters
}
```
SellerSKU
```java
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Document(collection = "seller_skus")
public class SellerSKU {
    @Id
    private String id;
    private String name;
    private String description;
    private Set<String> imageUrls; // List of paths to store image URLs

    @DBRef
    private Set<EmbeddedBean> fallIntoProfiles;

    // Getters and Setters
}
```
Profile
```java
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Document(collection = "profiles")
public class Profile {
    @Id
    private String id;
    private String companyName;
    private String description;

    @DBRef
    private Set<SellerSKU> skus;

    // Getters and Setters
}
```
## Running the Application

1- Clone the repository:
```bash
git clone <repository-url>
cd <repository-directory>
```
2- Build the project:
```bash
mvn clean install
```
3- Run the application:
```bash
mvn spring-boot:run
```
## Application struture:
    
```bash
src
└── main
├── java
│   └── diginamic
│       └── m052024
│           └── user_account
│               ├── UserAccountApplication.java
│               ├── config
│               │   └── MongoConfig.java
│               ├── controller
│               │   ├── ProfileController.java
│               │   ├── SellerSKUController.java
│               │   └── UserController.java
│               ├── model
│               │   ├── DatabaseSequence.java
│               │   ├── EmbeddedBean.java
│               │   ├── Profile.java
│               │   ├── SellerSKU.java
│               │   └── User.java
│               ├── repository
│               │   ├── ProfileRepository.java
│               │   ├── SellerSKURepository.java
│               │   └── UserRepository.java
│               └── service
│                   ├── ProfileService.java
│                   ├── SellerSKUService.java
│                   ├── SequenceGeneratorService.java
│                   └── UserService.java
└── resources
├── application.properties
├── static
└── templates
└── index.html
``` 


## API Endpoints

The application provides the following RESTful APIs:

- **/api/seller_skus**: for the seller SKU operations
  - POST /api/seller_skus: Create a new seller SKU
  - GET /api/seller_skus: Retrieve all seller SKUs
  - GGET /api/seller_skus/{id}: Retrieve a seller SKU by ID
  - DELETE /api/seller_skus/{id}: Delete a seller SKU by ID

- **/api/profiles**: for the profile operations
  - POST /api/profiles: Create a new profile
  - GET /api/profiles: Retrieve all profiles
  - GET /api/profiles/{id}: Retrieve a profile by ID
  - DELETE /api/profiles/{id}: Delete a profile by ID

- **/api/users**: for the user operations
- POST /api/users: Create a new user
- GET /api/users: Retrieve all users
- GET /api/users/{id}: Retrieve a user by ID
- DELETE /api/users/{id}: Delete a user by ID
- GET /api/users/email: Retrieve a user by email


## Database Schema

The application uses MongoDB collections with the following schemas:

**users Collection**
```json
{
    "_id": ObjectId,
    "id": Integer,
    "name": String,
    "email": String
}
```
**seller_skus Collection**
```json
{
  "_id": ObjectId,
  "id": String,
  "name": String,
  "description": String,
  "imageUrls": [String],
  "fallIntoProfiles": [
    {
      "id": String,
      "name": String,
      "repositoryName": String
    }
  ]
}
```
**profiles Collection**
```json
{
  "_id": ObjectId,
  "id": String,
  "companyName": String,
  "description": String,
  "skus": [
    {
      "id": String,
      "name": String,
      "description": String,
      "imageUrls": [String],
      "fallIntoProfiles": [
        {
          "id": String,
          "name": String,
          "repositoryName": String
        }
      ]
    }
  ]
}
```
## Running the Tests

To run the tests, execute the following command:
```bash
mvn test
```
## Postman Collection

You can use Postman to test the API endpoints. Import the following JSON collection into Postman:

```bash
{
    "info": {
        "name": "User Account Management",
        "schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json"
    },
    "item": [
        {
            "name": "Create SellerSKU",
            "request": {
                "method": "POST",
                "header": [
                    {
                        "key": "Content-Type",
                        "value": "application/json"
                    }
                ],
                "body": {
                    "mode": "raw",
                    "raw": "{\n    \"name\": \"Sample SKU\",\n    \"description\": \"Sample SKU Description\",\n    \"imageUrls\": [\"http://example.com/image1.jpg\"],\n    \"fallIntoProfiles\": [\n        {\n            \"id\": \"prod123\",\n            \"name\": \"Test Product\",\n            \"repositoryName\": \"profileRepository\"\n        }\n    ]\n}"
                },
                "url": {
                    "raw": "http://localhost:8080/api/seller_skus",
                    "protocol": "http",
                    "host": [
                        "localhost"
                    ],
                    "port": "8080",
                    "path": [
                        "api",
                        "seller_skus"
                    ]
                }
            }
        },
        {
            "name": "Get All SellerSKUs",
            "request": {
                "method": "GET",
                "url": {
                    "raw": "http://localhost:8080/api/seller_skus",
                    "protocol": "http",
                    "host": [
                        "localhost"
                    ],
                    "port": "8080",
                    "path": [
                        "api",
                        "seller_skus"
                    ]
                }
            }
        },
        {
            "name": "Get SellerSKU by ID",
            "request": {
                "method": "GET",
                "url": {
                    "raw": "http://localhost:8080/api/seller_skus/generated-id",
                    "protocol": "http",
                    "host": [
                        "localhost"
                    ],
                    "port": "8080",
                    "path": [
                        "api",
                        "seller_skus",
                        "generated-id"
                    ]
                }
            }
        },
        {
            "name": "Delete SellerSKU",
            "request": {
                "method": "DELETE",
                "url": {
                    "raw": "http://localhost:8080/api/seller_skus/generated-id",
                    "protocol": "http",
                    "host": [
                        "localhost"
                    ],
                    "port": "8080",
                    "path": [
                        "api",
                        "seller_skus",
                        "generated-id"
                    ]
                }
            }
        }
    ]
}
```
## Conclusion

This project demonstrates a user account management system using Spring Boot and MongoDB. It ensures unique email addresses and provides RESTful APIs for user operations.

## License

This project is licensed under the MIT License - see the LICENSE file for details.

## Contact

For any queries, reach out to me at gaelbueno@aol.com
