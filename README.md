# CrudOperation
# Project Setup Instructions
 # 1. Prerequisites
Install Java Development Kit (JDK) 17 or higher.
Install Maven for project build management.
Install MySQL Server (8.x or higher).
Install an IDE (e.g.,spring tool suit) for development.

# Configure the Database
Open MySQL Workbench or any database client.
Create a new database named usersdtls:
# sql query
CREATE DATABASE usersdtls;

# Set Up the application.properties File
Navigate to src/main/resources/application.properties.
Add the following configuration:
properties
spring.application.name=UserDtls
spring.datasource.url=jdbc:mysql://localhost:3306/usersdtls
spring.datasource.username=root
spring.datasource.password=root
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
spring.jpa.show-sql=true
server.port=8084

# Build and Run the Project
Open a terminal in the project directory.
Build the project using Maven:
mvn clean install

Run the application:
mvn spring-boot:run

# 3. Database Setup and Configuration
Ensure MySQL Server is running on localhost and listening on port 3306.
Use the following credentials to connect:
Username: root
Password: root
The spring.jpa.hibernate.ddl-auto=update configuration ensures the database schema matches the Users entity. Tables will be automatically created or updated.

# API Documentation
Base URL
The API is hosted at http://localhost:8084/api/entity.

Endpoints
# 1. Create a User
Method: POST
Endpoint: /api/entity
Description: Creates a new user in the database.
Request Body (JSON):

{
        "name": "shambhavi",
        "mobileNumber": 9030017704,
        "email": "shambhavi@gmail.com",
        "address": "mumbai"
}
Response (JSON):


{
  "id": 1,
   "name": "shambhavi",
   "mobileNumber": 9030017704,
   "email": "shambhavi@gmail.com",
   "address": "mumbai"
}

# 2. Get All Users
Method: GET
Endpoint: /api/entity
Description: Fetches a list of all users from the database.
Response (JSON):

{
        "id": 1,
        "name": "shambhavi",
        "mobileNumber": 9030017704,
        "email": "shambhavi@gmail.com",
        "address": "mumbai"
    },
    {
        "id": 2,
        "name": "priynka",
        "mobileNumber": 8830017704,
        "email": "priya@gmail.com",
        "address": "pune"
    }
    {
        "id": 52,
        "name": "dipak",
        "mobileNumber": 9900989978,
        "email": "dipak@gmail.com",
        "address": "kohlapur"
    }
]
    
# 3. Get User by ID
Method: GET
Endpoint: /api/entity/{id}
Description: Fetches a user by their ID.
Path Variable: id (integer) - ID of the user.
Response (JSON):

{
        "id": 1,
        "name": "shambhavi",
        "mobileNumber": 9030017704,
        "email": "shambhavi@gmail.com",
        "address": "mumbai"
}

# 4. Update a User
Method: PUT
Endpoint: /api/entity/{id}
Description: Updates user details by their ID.
Path Variable: id (integer) - ID of the user.
Request Body (JSON):

{
        {
    "name": "dipali",
    "mobileNumber": "9900989978",
    "email": "dipali@gmail.com",
    "address": "kohlapur"
}
Response (JSON):
{
    "id": 52,
    "name": "dipali",
    "mobileNumber": 9900989978,
    "email": "dipali@gmail.com",
    "address": "kohlapur"
}


# 5. Delete a User
Method: DELETE
Endpoint: /api/entity/{id}
Description: Deletes a user by their ID.
Path Variable: id (integer) - ID of the user.
Response:

User with ID 1 has been deleted successfully.
Error Handling
If a user is not found for a given ID, the API throws:
Response Status: 404 Not Found
Message: User not found with ID: {id}
