[![CircleCI](https://circleci.com/gh/cshinoc/SpringBoot-PetClinic.svg?style=svg)](https://circleci.com/gh/cshinoc/SpringBoot-PetClinic)

# SpringBoot-PetClinic
This is a Spring Boot Pet Clinic Web Application which based on traditional Spring MVC structure. In this project, for Data persistence layer, I used Spring-Data-JPA and Hibernate to provide Object-Relational Mapping solution with the help of H2 and MySQL database to implement data persistence. Also, CRUD class is created in the project for better abstraction. As for the controller layer, I used Spring Boot Actuator for monitoring the whole project and WebDataBinder to translate clients' requests. Meanwhile, for the view layer, I used Thymeleaf as the template engine and render the web pages. 

The Pet Clinic web application is developed using Test_Driven Development. I used JUnit 5 combined with Mockito to do a huge amount of complete and automated tests.

To optimize and simple my code, I used Lombok to make all codes light and easy-to-read. On the other hand, the project used Maven for dependencies management and Circle CI for continuous integration.
web applications.

# License
The Spring PetClinic sample application is released under version 2.0 of the [Apache License](http://www.apache.org/licenses/LICENSE-2.0)
