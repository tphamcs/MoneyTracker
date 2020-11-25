# MoneyTracker

# Product description
This application is a budget management app. It allow user to create a tracking list by adding product items as well as remove, update and retrieve their information. 

This application was created using: Java 8, JDBC, Servlets, Tomcat 8.5, PostgreSQL, JUnit, Maven, AWS RDS....

# Endpoints

## POST /login
  Authentication based on username and password.
  
## GET /logout
  Removing session 'user' and redirect back to login.jsp

## POST /insertProduct
  Insert items into 'product' table.  
  productService.insertProduct(uid, "Burger", "Food", "11/22/2020", 10)
  
## POST /deleteProduct
  Delete items from 'product' table.  
  productService.deleteProduct(pid);
  
## GET /listProduct
  Retriving all items belong to current user.  
  productService.getAllProduct(uid);
  
# How to Startup the Application

## Prerequisites
You will have to download the following in order to set up the app locally:
- maven
- tomcat
- jdk8
- Running PostgreSQL DB

Make sure you have the following environment variables configured (usually you could also link to official guides/ website):
- JAVA_HOME
- CATALINA_HOME
- MAVEN_HOME
- M2_HOME
- DB_URL = connection string for postgresql jdbc drier
- DB_USERNAME = user name for db
- DB_PASSWORD = password for user for PG DB
Notice! This app should use the above environment variables for the DB.... but we happen to have hardcoded it in this current version.

## Setup

1. clone the application from repository

> git clone https://github.com/tphamcs/MoneyTracker.git

2. Pre-populate the db using the `schema.txt` file that is provided

1. setup tomcat

- Manually:
    - package into a war with maven:
        > mvn clean package
    - deploy to tomcat by copying the war to the `webapps` folder in Tomcat Directory
    - run startup.sh/startup.bat in tomcat folder
    - navigate to {URL}
- IDE:
    - setup tomcat to run virtually within your ide
    - startup tomcat and navigate to {URL}
