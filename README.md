# Shopping Basquet

Backend service Shopping Basket.

## Running the application from the command line using Maven

1. In the base directory (containing pom.xml)
* mvn clean install
* mvn spring-boot:run 

## Running just the application test from the command line using Maven

1. In the base directory (containing pom.xml)
* mvn test

## Running application without tests (in case tests are failing)

1. In the base directory (containing pom.xml)
* mvn -Dmaven.test.skip=true install
