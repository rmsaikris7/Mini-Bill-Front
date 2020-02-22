# Mini Bill Front

This project is a maven built java project which calculates financed amount, financed amount for each invoice and remaining credit limit of a customer based on the invoices and the credit limit of the customer.

## Requirements
Mini Bill Front requires [Java 8](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html) and [Maven 3+](https://maven.apache.org/pom.html).

## Execution

### Eclipse

Import the project as maven project in eclipse and run the application as plain java application.

### Using JAR

Execute the following maven command which run the JUNIT tests and packages the application.

```sh
$ mvn package
```

Go to the target folder and execute the following command to run the jar file.

```sh
$ java -jar bill-front-0.0.1-SNAPSHOT-jar-with-dependencies.jar
```

