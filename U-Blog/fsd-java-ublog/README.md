The details of the folders inside the project are as follows

com.upgrad.ublog.dao: This folder contains classes which will be responsible for interacting with the database. This folder is the database layer for your application.

com.upgrad.ublog.db: This folder contains just one class which will be used to establish a connection with the database. This folder also contains the 'setup.sql' file which contains SQL queries to set up your database.

com.upgrad.ublog.dtos: This folder contains two classes which will be used to transfer data between different layers of your application.

com.upgrad.ublog.exceptions: This folder contains four custom exception classes, which will be used for exception handling in your application.

com.upgrad.ublog.services: This folder contains classes which will be responsible for fetching data from the database layer, process the data and send to the presentation layer. It will also get requests from the presentation layer and save data into the database. This folder is the service layer of your application.

com.upgrad.ublog.utils: This folder contains three classes, which will be used to perform utility tasks for your project.

Application.java file: This file will be responsible for interacting with the users. It will get inputs from the user, process them with help of the service later and display the response back on the console. This file will be part of the presentation layer of your application.