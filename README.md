# Java Automation UI + API Project

## Description

Automation Maven infrastructure in Java using Selenium and TestNG framework. 
Different browsers Automated UI tests based on properties file, REST-assured API tests based on JSON Server from a batch file. 
Logs based on log4j.configuration file, run in the console, and save to "logs.txt" file.
No need to update browsers drivers - it happens automatically by WebDriverManager.

- UI tests based on site: [90min site](www.90min.com/)
- API tests based on local JSON Server

## Installation

- Download the project to your local computer.
- Run JSON Server with "createJSONServer.bat" in src/resource (If Server does not run API Tests failed in execution).
- Make sure Chrome and Edge are installed for a run on different browsers. 

## Usage

Run testng.xml to execute all tests (UI + API).
- Can run UI Tests from the "UITest" class (choose a browser from config.properties file).
- Can run API Tests from the "APITest" class (run "createJSONServer.bat" before it).

## What's included

/JavaAutomationUI+API    
├── src   
│---├── pages  
│-------├── Arsenal.java  
│-------├── ContactUs.java  
│-------├── HomePage.java  
│---├── resources  
│-------├── createJSONServer.bat  
│-------├── db.json  
│-------├── dbRecover.json  
│---├── tests  
│-------├── APITests.java  
│-------├── UITests.java  
│---├── utills  
│-------├── Base.java  
│-------├── HttpMethods.java  
│-------├── PrepareAPITests.java  
│-------├── PrepareUITests.java  
│-------├── ReadPropertyFile.java  
│-------├── UIActions.java  
├── config.properties  
├── log4j.properties  
├── logs.txt  
├── pom.xml  
├── testng.xml  
