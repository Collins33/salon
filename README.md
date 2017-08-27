# SALON
Salon is an online salon management system that allows owners
of salons to manage their employees and clients and assign
clients to employees,view assigned clients,keep track of clients and employees and delete cients and employees who are no longer part of the team.

# AUTHOR
COLLINS NJAU MURU
collinsnjau39@gmail.com

# TECHNOLOGY USED
  - HTML,CSS,BOOTSTRAP
  - JAVA -SPARK FRAMEWORK
  - POSTGRESQL

# INSTALLATION!

  - git clone https://github.com/Collins33/salon
  - cd salon
  - gradle build
  - In PSQL:
CREATE DATABASE hair_salon;
CREATE TABLE clients (id serial PRIMARY KEY, name varchar, stylistId int);
CREATE TABLE stylist (id serial PRIMARY KEY, name varchar);
 -gradle run

License
----

MIT


**Free Software**
