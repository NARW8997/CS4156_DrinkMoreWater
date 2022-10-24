# DrinkMoreWater project
* Our team decided to do a server which contains database of restaurants, dishes, user reviews and order information. These information potentially benefits applications for both customers and restaurant owners, with appropriote frontend functions our serve could support functionality of reviewing and rating, ordering, advertising and etc.*

## 1. Documented API
* Right now we have basic API calls for all of the services we support, below we provide an example of API calls with User*
* ___Users___
      * `GET /users`
         * Description: This endpoint retrieves all users that match the template given in the query parameters. No parameters are required.
         * Sample Request: localhost:8080/users
         * Request Parameters:
            * `user_id` (Type: Integer)
            * `first_name` (Type: String)
            * `last_name` (Type: String)
            * `email` (Type: String)
            * `phone` (Type: String)
            * `type` (Type: Integer)
      * `GET /users/{id}`
         * Description: This endpoint retrieves a specific user that match the template given in the query parameters.
         * Sample Request: localhost:8080/users/1
         * Request Parameters:
            * `user_id` (Type: Integer)
            * `first_name` (Type: String)
            * `last_name` (Type: String)
            * `email` (Type: String)
            * `phone` (Type: String)
            * `type` (Type: Integer)
      * `POST /users`
         * Description: This endpoint receives the details of a user to newly create. The parameters in the request body must have fields exactly identical to those which are shown in the sample below.
         * Sample Request Body:
            * `{ "userId": 1, "firstName": "James", "lastName": "Cann", "email": "jcann@gmail.com", "phone": "900-001-0012", "type": 1 }`
      * `PUT /users`
         * Description: This endpoint receives the details of a user to update. The parameters in the request body must have fields exactly identical to those which are shown in the sample below.
         * Sample Request Body:
            * `{ "userId": 2, "firstName": "James", "lastName": "Cann", "email": "jcann@gmail.com", "phone": "900-001-0012", "type": 1 }`
      * `DELETE /users/{id}`
         * Description: This endpoint receives a userId to delete.
         * Request Parameters:
            * `userId` (Type: Integer)
            
## 2. System Tests Corresponding to API

## 3. Unit Tests
  * The unit tests are located in src/test/java/drinkmorewater.

## 4. Style Compliant


## 5. Build, Run, Test Instructions

-------------------------------------------------------------------------------------------------------------------------------------------------------------------

## 1. Client

## 2. Continuous Integration

## 3. Coverage

## 4. Bug Finder

