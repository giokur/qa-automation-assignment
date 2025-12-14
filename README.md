# QA Automation Test Suite

# Prerequisites
- Java 21+
- Maven 3.6+
- Chrome browser

# How to Run
## Run from GitHub
There are 2 workflows:
- Triggers automatically all tests on push to 'main'
- Triggered manually for specific subset of tests: api, integration, ui
## Run locally
### Configuration
Make sure there are two env vars exported for User credentials
```
export USERNAME=<username>
export PASSWORD=<password>
```
### Run all tests
```
mvn clean test
```
### Run only API tests
```
mvn test -Dgroups="api"
```
### Run only UI tests
```
mvn test -Dgroups="ui"
```
### Run only Integration tests
```
mvn test -Dgroups="integration"
```
### Open Allure report
```
mvn allure:serve
```
## Test Strategy
Prioritized API tests because their number should be much more than UI

## Challenges & Solutions
UI controls on the test page is a nightmare

## What I Would Add With More Time
Finalize Integration tests to use API for data retrieval for UI tests.
Implement reporting with Aspects.
