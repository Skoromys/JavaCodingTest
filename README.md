# Java Coding Test

### Car workshops
You could run and check controllers work at  [swagger page](http://localhost:8080/swagger-ui/)

### TODO
* create _directories_ (enum) for city, postal code, country and add they to User, Workshop and Appointment.
* add verification 
* create tests


### Task
Write a Spring based web application which allows to make an appointment in a car workshop. It is
    not necessary to create a UI frontend. All Operations should be available over a Rest API. For the data
    storage you can use a simple in memory storage (List, Map etc.). But it should be easy to replace the
    in-memory storage later with a real database. The following functions should be available:
* Create a user with the following fields:
  *  Username (unique)
  *  Email (unique)
  *  City
  *  Postal code
  *  Country
* Delete an existent user
* Create a car workshop with the following fields:
  *  Company Name (unique)
  *  Car trademarks specializes in (example BMW, VW)
  *  City
  *  Postal code
  *  Country
* Delete an existent car workshop
* Search for all car workshop in a specific city
* Create an appointment between a user and a car workshop. An appointment should have
    the following fields:
  *  Username
  *  Users car trademark
  *  Company name
  *  Date and time
* Change the date and time of an existent appointment
* Delete an existent appointment


