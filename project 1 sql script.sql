/*  Expense Validation Application System : Database Operations For Project 1
 *  =========================================================================
 *   @authors Efrain Vila, Adam Shipe
 * 
 *  Database Name   : EVAS
 *  Schema          : Public
 *  Tables          : Employee, Manager, Reimbursement, Reports, Image 
 *  Keys            : PK Employeeid, PK Managerid, PK ReimbursementId, PK ImageId
 * 
 */

/* EVAS : Expense Validation Application System
===============================================
*/

-- Database creation
--------------------
CREATE DATABASE EVAS;

-- EVAS Tables
--------------

-- Employee Table 
-----------------
CREATE TABLE Employee(
    employeeid serial PRIMARY KEY,
    employeelastname varchar(50),
    employeefirstname varchar(50),
    employeeposition varchar(50),
    employeeemail varchar(50) NOT NULL,  -- use as username
    employeepassword varchar(50) NOT NULL -- use as password , both to identify manager from employee
    
);

DROP TABLE Employee CASCADE   -- used to reset

-- Request Table 
----------------
CREATE TABLE Request(
    requestid serial PRIMARY KEY,
    requestvalue NUMERIC (8,2) DEFAULT (0.00),
    requeststatus varchar(20) DEFAULT ('OPEN'),
    requestdate date DEFAULT now(),
    eventdate date DEFAULT NOW(),
    FOREIGN KEY (requestid) REFERENCES Employee(employeeid)
    
);

--ALTER TABLE request
--ADD CONSTRAINT fk_image_Nto1
--FOREIGN KEY (imageid) REFERENCES Image(imageid);

DROP TABLE Request CASCADE   -- used to reset

-- Reimbursement Table
----------------------
CREATE TABLE Reimbursement(
    reimbursementid serial PRIMARY KEY,
    reimbursementamount NUMERIC (8,2) DEFAULT(0.00),
    reimbursementdate date DEFAULT NOW(),
    FOREIGN KEY (reimbursementid) REFERENCES Request(requestid)
);

DROP TABLE reimbursement CASCADE

-- Manager Table 
----------------
CREATE TABLE Manager( -- may need to change to bool and have no PK
    managerid serial PRIMARY KEY,
    managerlevel varchar(20),
    FOREIGN KEY (managerid) REFERENCES Employee(employeeid)
);

--ALTER TABLE Manager
--ADD CONSTRAINT fk_employee_Nto1
--FOREIGN KEY (employeeid) REFERENCES Employee(employeeid);

DROP TABLE Manager CASCADE   -- used to reset

-- Reports Table -- to join employee and manager 
-------------------------------------------------
CREATE TABLE Reports(
    reportid serial PRIMARY KEY,
    managerid integer, -- FK
    employeeid integer, -- FK
    FOREIGN KEY (employeeid) REFERENCES Employee(employeeid),
    FOREIGN KEY (managerid) REFERENCES Manager(managerid)
    
);    

--ALTER TABLE Reports
--ADD CONSTRAINT fk_manager_Nto1
--FOREIGN KEY (managerid) REFERENCES Manager(managerid);

--ALTER TABLE Reports
--ADD CONSTRAINT fk_employee_Nto1
--FOREIGN KEY (employeeid) REFERENCES Employee(employeeid);

DROP TABLE Reports CASCADE -- used to RESET

-- Images table to be upload via SQL statements 
------------------------------------------------
CREATE TABLE Image( 
    imageid serial PRIMARY KEY,
    imagename varchar(50),
    image bytea, -- used to hold image ... need to research escapes, 2gb max per image
    FOREIGN KEY (imageid) REFERENCES Reimbursement(reimbursementid)
    
);

DROP TABLE Image CASCADE   -- used to RESET

                                
--Inserting Values into Tables  (for testing) 
--------------------------------------------
INSERT INTO Employee VALUES
    (DEFAULT, 'Ursa', 'Frank', 'Hardware Developer', 'fursa@evas.com', 'FU9630'),
    (DEFAULT, 'Thomas', 'Greg', 'Software Developer', 'gthomas@evas.com', 'GT8520'),
    (DEFAULT, 'Samson', 'Helen', 'Robotic Engnineer', 'hsamson@evas.com', 'HS7410'),
    (DEFAULT, 'Robinson', 'Izzy', 'Accountant', 'irobinson@evas.com', 'IR75300'),
    (DEFAULT, 'Quientela', 'Jackie', 'Advertising Analyst', 'jquientela@evas.com', 'JQ9510'),
    (DEFAULT, 'Paulson', 'Kenny', 'Mail Clerk', 'kpaulson@evas.com', 'KP8642'),
    (DEFAULT, 'Opal', 'Laura', 'Manager', 'lopal@evas.com', 'LO3159'), -- manager level
    (DEFAULT, 'Nelson', 'Manny', 'Manager', 'mnelson@evas.com', 'MN9357'); -- manager level
 
INSERT INTO Reimbursement VALUES                -- need to resolve null entries at reimbursement table
    (DEFAULT, DEFAULT, DEFAULT, DEFAULT),
    (DEFAULT, DEFAULT, DEFAULT, DEFAULT),
    (DEFAULT, DEFAULT, DEFAULT, DEFAULT),
    (DEFAULT, DEFAULT, DEFAULT, DEFAULT),
    (DEFAULT, DEFAULT, DEFAULT, DEFAULT),
    (DEFAULT, DEFAULT, DEFAULT, DEFAULT),
    (DEFAULT, DEFAULT, DEFAULT, DEFAULT),
    (DEFAULT, DEFAULT, DEFAULT, DEFAULT);

INSERT INTO reports VALUES
    (DEFAULT, DEFAULT),
    (DEFAULT, DEFAULT),
    (DEFAULT, DEFAULT),
    (DEFAULT, DEFAULT),
    (DEFAULT, DEFAULT),
    (DEFAULT, DEFAULT),
    (DEFAULT, DEFAULT),
    (DEFAULT, DEFAULT);


INSERT INTO Manager VALUES  -- if needed values will be added
    (DEFAULT, DEFAULT),
    (DEFAULT, DEFAULT),
    (DEFAULT, DEFAULT),
    (DEFAULT, DEFAULT),
    (DEFAULT, DEFAULT),
    (DEFAULT, DEFAULT),
    (DEFAULT, DEFAULT),
    (DEFAULT, DEFAULT);

-- for image table, values may need to be inserted from outside sql
INSERT INTO Image VALUES
     (DEFAULT, DEFAULT, DEFAULT, DEFAULT),
     (DEFAULT, DEFAULT, DEFAULT, DEFAULT),
     (DEFAULT, DEFAULT, DEFAULT, DEFAULT),
     (DEFAULT, DEFAULT, DEFAULT, DEFAULT),
     (DEFAULT, DEFAULT, DEFAULT, DEFAULT),
     (DEFAULT, DEFAULT, DEFAULT, DEFAULT),
     (DEFAULT, DEFAULT, DEFAULT, DEFAULT),
     (DEFAULT, DEFAULT, DEFAULT, DEFAULT);

-- request table
----------------
INSERT INTO Request VALUES
    (DEFAULT,DEFAULT, DEFAULT, 'pending', ),
    (DEFAULT,DEFAULT, DEFAULT),
    (DEFAULT,DEFAULT, DEFAULT),
    (DEFAULT,DEFAULT, DEFAULT),
    (DEFAULT,DEFAULT, DEFAULT),
    (DEFAULT,DEFAULT, DEFAULT),
    (DEFAULT,DEFAULT, DEFAULT),
    (DEFAULT,DEFAULT, DEFAULT); 
 
-- Queries of Tables
--------------------
SELECT * FROM Employee;

SELECT * FROM Manager;

SELECT * FROM Reimbursement;

SELECT * FROM Image;

SELECT * FROM reports;

SELECT * FROM request;

-- Select statements 
----------------------------------------
SELECT * FROM Employee WHERE employeeemail = 'fursa@evas.com' AND employeepassword = 'FU9630';-- remove 'fursa@evas.com' and replace with ?

SELECT * FROM Employee FULL JOIN Manager ON employee.employeeid = manager.managerid WHERE employeepassword = 'LO3159' ;

SELECT employeelastname AS "Manager Last Name", employeefirstname AS "Manager First Name" FROM employee INNER JOIN manager ON employee.employeeid = manager.managerid WHERE employeepassword = 'LO3159'

SELECT * FROM reimbursement INNER JOIN employee ON reimbursementid = employee.employeeid;



-- Updating tables
-------------------


-- need to test uploading an image to sql database
-- need to adjust the fields for the needs of the project
-- need to re-do the select, insert, update statement based on what is asked
    