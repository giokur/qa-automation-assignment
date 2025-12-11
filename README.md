# QA Automation Test Suite

# Prerequisites
- Java 11+
- Maven 3.6+
- Chrome browser
# How to Run
## Run all tests
```
mvn clean test
```
## Run only API tests
```
mvn test -Dgroups="api"
```
## Run only UI tests
```
mvn test -Dgroups="ui"
```
## Run only Integration tests
```
mvn test -Dgroups="integration"
```
## Open Allure report
```
mvn allure:serve
```
## Test Strategy
Prioritized API tests because their number should be much more then UI

## Challenges & Solutions
UI controls on the test page is a nightmare

## What I Would Add With More Time
Finalize Integration tests to use API for data retrieval for UI tests.
Implement reporting with Aspects.
