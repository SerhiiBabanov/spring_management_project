Technology : Java, PostgreSQL, H2, Spring (MVC, Data, Security, Spring Boot, Validation, Flyway), Thymeleaf, Maven, Tomcat, Git, JavaScript, HTML

This project implements a simple product management system (various products and their manufacturers). This system assumes 2 types of users: normal user and administrator.
  Ordinary users are provided with the following capabilities:
- view lists of all products and manufacturers,
- search for products or manufacturers either by name or by ID number.
The administrator, in addition to these features, is given the following capabilities:
- add, edit and delete products and manufacturers;
- obtain a list of all users, search by name or ID number, the ability to add, edit and delete users.

For run local use profile "local" and set your url, username and password for datasource. <br>
Before using the program, fill the database using dml.sql.<br>
Application start in port 8085 on default.<br>
For connection use localhost:8085/<br>
For test use test login admin@admin.com and password test. Or create new login and in database add relation beetwen "ROLE_ADMIN" and your login in table userroles.
