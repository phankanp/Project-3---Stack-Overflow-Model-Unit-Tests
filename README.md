Added unit tests to existing Java models to ensure that a application called Stack Overboard is functioning as intended.

# Steps

- Create a new Test Fixture for the User model in a separate but same package test directory structure. Use JUnit4.
- Write a test to ensure that the questioner&#39;s reputation goes up by 5 points if their question is upvoted.
- Write a test to assert that the answerer&#39;s reputation goes up by 10 points if their answer is upvoted.
- Write a test that proves that having an answer accepted gives the answerer a 15 point reputation boost
- Using a test, ensure that voting either up or down is not allowed on questions or answers by the original author, you know to avoid gaming the system. Ensure the proper exceptions are being thrown.
- Write a test to make sure that only the original questioner can accept an answer. Ensure the intended messaging is being sent to back to the caller.

- Create additional objects which can be shared across tests.
