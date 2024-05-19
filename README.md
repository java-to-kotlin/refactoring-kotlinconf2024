# Exercises for the Mastering Kotlin Refactoring workshop

* [Luhn Validation](exercises/luhn): Refactor an unnecessarily verbose collection pipeline, with hints from IntelliJ
* [Gilded Rose](exercises/gilded-rose): plenty of refactoring opportunities in an extended version of the Gilded Rose refactoring kata featured on Duncan's YouTube channel
* [Conference Signup](exercises/signup): refactor from mutable "bean" to algebraic data type and functions
* [Cycle Race Leaderboard](exercises/leaderboard): refactoring Kotlin code & database schema, requiring multiple expand/contract deployments to apply the change without downtime
* [Boat Maintenance Log](exercises/boatlog): refactor serialised classes, requiring a strategy to cope with different versions of the data


# Prerequisites

Before the workshop...

Install the following:

 * IntelliJ
 * Kotlin 1.9.2 or above
 * JDK 17

To avoid disappointment on the day if there is limited wifi bandwidth, run the following command to download all the dependencies before the workshop:

```shell
./gradlew initDbs test
```
