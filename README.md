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

-------------------------------------------------------------------------------------------------------------------------------------------------------------------

## 1. Client
    * The three different types of clients that can use our service are listed below:  
    * 1. customers who want to rate and write reviews for restaurants they have visited can access our restaurant and review database, and utilize the functionality  
    of our calls such as add/review or add/rating. A real life example of such an application would be Yelp, an app where people post reviews and share their   
    dining experience of certain restaurants.   
    * 2. customers who’d like to check the meals served by a restaurant and order food can access our restaurant, orderProfile and orderDish database, which   
    contains information of dishes and serving time. Customers can either look at the menu and get the restaurant number to order through phone calls, or they   
    can order online with the frontend services provided by the application they are using. A real life example would be Uber eats, where people look for their  
    desired food from different restaurants and make orders.  
    * 3. restaurant owners who want to advertise their restaurants and be informed about their bestsellers and serving qualities can access our restaurant, review,  
    orderProfile and orderDish database and get the dish selling information corresponding to their restaurant id, which may allow them to change their market plan  
    to attract more customers and exposures, especially with our restaurant recommendation algorithm (which can be retrieved with GET restaurant/popular). A real   
    life example of this type of application is Google maps, which contains functionality as I described above when you get in their “restaurant” feature.  
    


## 2. Continuous Integration
  * We can useTravis CI with Github, or TeamCity with Intellij IDEA
## 3. Coverage
  * We can use JUnit or Built-in Intellij IDEA tools along with JaCoCo for coverage display. 
  * We can use JUnit for covering test001 runs.
## 4. Bug Finder
  * We can use FindBugs-IDEA or SpotBugs IDEA plugin for Style checking.
