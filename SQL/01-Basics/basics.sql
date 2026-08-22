CREATE DATABASE college_db;
USE college_db;
TRUNCATE TABLE students;
CREATE TABLE students (
    id INT PRIMARY KEY,
    name VARCHAR(100) NOT NULL, 
    email VARCHAR(150),
    age INT
);
INSERT INTO students (id, name, email, age) 
VALUES
(1, 'Aman', 'aman@gmail.com', 21),
(2, 'Pratham', 'pratham@gmail.com', 21),
(3, 'Nikhil', 'nikhil@gmail.com', 21);
DESCRIBE students;
SELECT * FROM students; 

CREATE TABLE departments (
    id INT PRIMARY KEY,
    name VARCHAR(50) UNIQUE, 
    location VARCHAR(50)
);

INSERT INTO departments (id, name, location)
VALUES
    (1, 'CSE', 'Jaipur'),
    (2, 'ECE', 'Jaipur'),
    (3, 'CCE', 'Delhi'),
    (4, 'ME', 'Mumbai');

SELECT * FROM departments;


DROP DATABASE test_db;