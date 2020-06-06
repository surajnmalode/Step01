/*
create table person
(
id integer not null,
name varchar(255) not null,
location varchar(255),
birth_date timestamp,
primary key(id)
);
*/
INSERT INTO PERSON 
     (ID, NAME, LOCATION, BIRTHDATE)
VALUES (10001, 'Suraj', 'Bangalore', sysdate());

INSERT INTO PERSON 
     (ID, NAME, LOCATION, BIRTHDATE)
VALUES (10002, 'Sagar', 'Harihar', sysdate());

INSERT INTO PERSON 
     (ID, NAME, LOCATION, BIRTHDATE)
VALUES (10003, 'Sheethal', 'Bangalore', sysdate());

INSERT INTO PERSON 
     (ID, NAME, LOCATION, BIRTHDATE)
VALUES (10004, 'Sheethal D Malode', 'Bangalore', sysdate());

