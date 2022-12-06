# DrinkMoreWater project
* Our team decided to do a server which contains database of restaurants, dishes, user reviews and order information. These information potentially benefits applications for both customers and restaurant owners, with appropriote frontend functions our serve could support functionality of reviewing and rating, ordering, advertising and etc.

## 1. Documented API
* Right now we have basic API calls for all of the services we support, below we provide an example of API calls with User.
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
  * We used postman as an API testing tool, the raw export of our tests is located at src/java/PostmanSystemTests, the result has been published on postman with the following link: https://documenter.getpostman.com/view/24117254/2s8YKCHiWs  
## 3. Unit Tests
  * The unit tests are located in src/test001/java/drinkmorewater.

## 4. Style Compliant
  * We can use or CheckStyle-IDEA or SonarLint IDEA plugin for Style checking.

## 5. Build, Run, Test Instructions
  * The installation of Maven is required for running this project
  * run **mvn install** to install all the dependencies needed for building this project
  * run **mvn spring-boot:run** to start the application, the application will run on port 8080
  * run **mvn test** to run our test scripts for the project

-------------------------------------------------------------------------------------------------------------------------------------------------------------------

## 1. Client
* The three different types of clients that can use our service are listed below:  
* 1. Application for customers who want to rate and write reviews for restaurants they have visited can access our bookmark and review database, and utilize the functionality of our API calls to save their favorite restaurants, to write and update their reviews and give likes and dislikes to certain restaurants. A real life example of such an application would be Yelp, an app where people post reviews and share their dining experience of certain restaurants.   
  https://github.com/NARW8997/CS4156_client_service
* 2. Applications for food ordering services who’d like to allow people make orders and also keep track of ordering information can access our orderProfile and orderDish databases, which contains orders of restaurants and of users, and specific dishes ordered in one order and total spending. A real life example would be Uber eats, a platform for food ordering services.
* 3. restaurant owners who want to advertise their restaurants and be informed about their bestsellers and serving qualities can access our restaurant, review, orderProfile and orderDish databases and get the order and dish selling information corresponding to their restaurant id, which may allow them to change their serving plans and logistics to make more profit. A real life example of this type of application is Plate IQ, which allow companies to keep track of their selling informations.
    


## 2. Continuous Integration
  * We are currently using github action workflow as the CI option, for running the tests we chose to use the surefire maven plugin. Sample test reports generated from surefire reports can be view in CS4156_DrinkMoreWater/CIResults folder.
## 3. Coverage
  * We are using the Built-in Intellij IDEA tools along with JaCoCo for coverage display. 
## 4. Bug Finder
  * We are using SpotBugs github actions for our static code bug finder, currently we do not have fatal bugs, although we still have a few warnings but we've decided that we'd prefer our current design over the suggestions given from SpotBugs. The bug reports of each of our commited push can be viewed in the Action details in our repository.  
  
  
