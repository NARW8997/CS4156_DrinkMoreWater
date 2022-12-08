# Second assessment Part 1B
* This is the github branch for CS4156 Second individual assessment part 1B

## Refactoring steps
  * Decided to seperate the responsibility of ReviewController class along with its services using a bottom-up refactoring sequence
  * Refactored the mapper by creating a new mapper **"AdvancedReviewMapper"** with the SQL query for two functions "selectUserRestReviewByUserId" and "selectUserRestReviewByRestId" in main/java/com.cs4256.drinkmorewater/mapper.
  * Refactored the service by creating a new service **"AdvancedReviewServiceImpl"** which imports the new AdvancedReviewMapper and two functions "selectUserRestReviewByUserId" and "selectUserRestReviewByRestId" in main/java/com.cs4256.drinkmorewater/services/impl
  * Refactored the controller by creating a new controller **"AdvancedReviewController"** which imports the new AdvancedReviewServiceImpl and wrote the two corresponding functions in main/java/com.cs4256.drinkmorewater/controllers
  * Refactored the tests in test/java/com.cs4256.drinkmorewater, a new **AdvancedReviewTests"** is added, and the corresponding tests for the two functions have been moved to the new test class with approporiate imports.
