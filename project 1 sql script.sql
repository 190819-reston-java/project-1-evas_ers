/*  Expense Validation Application System : Database Operations For Project 1
 *  =========================================================================
 *   @authors Efrain Vila, Adam Shipe
 * 
 *  Database Name   : EVAS
 *  Schema          : Public
 *  Tables          : Employee, Manager, Reimbursement, Image 
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
CREATE TABLE Employee(
    employeeid serial PRIMARY KEY,
    employeelastname varchar(50),
    employeefirstname varchar(50),
    employeeposition varchar(50),
    employeedepartment varchar(50),
    employeeemail varchar(50) NOT NULL,
    employeepassword varchar(50) NOT NULL
    
);

--DROP TABLE Employee CASCADE   -- used to reset

CREATE TABLE Reimbursement(
    reimbursementid serial PRIMARY KEY,
    employeeid integer, -- FK
    imageid integer, -- FK, binary array type for image, to store on DB; need to ask Adam(trainer)
    requestnumber serial NOT NULL,
    requeststatus varchar(20),
    FOREIGN KEY (employeeid) REFERENCES Employee(employeeid)
    
);

ALTER TABLE reimbursement
ADD CONSTRAINT fk_image_Nto1
FOREIGN KEY (imageid) REFERENCES Image(imageid);

DROP TABLE Reimbursement CASCADE   -- used to reset

-- may not need if self join to employee table
----------------------------------------------
CREATE TABLE Manager(
    managerid serial PRIMARY KEY
    
);

-- DROP TABLE Manager CASCADE   -- used to reset

-- may not need if images are local hosted
-----------------------------------------
CREATE TABLE Image( 
    imageid serial PRIMARY KEY,
    imagename varchar(50),
    image bytea, -- used to hold image
    reimbursementid integer, -- FK
    FOREIGN KEY (reimbursementid) REFERENCES Reimbursement(reimbursementid)
    
);

--DROP TABLE Image CASCADE   -- used to RESET

                                
--Inserting Values into Tables   
------------------------------
INSERT INTO Employee VALUES
    (DEFAULT, 'Ursa', 'Frank', 'Hardware Developer', 'Information Technology', 'fursa@evas.com', 'FU9630'),
    (DEFAULT, 'Thomas', 'Greg', 'Software Developer', 'Information Technology', 'gthomas@evas.com', 'GT8520'),
    (DEFAULT, 'Samson', 'Helen', 'Robotic Engnineer', 'Research and Development', 'hsamson@evas.com', 'HS7410'),
    (DEFAULT, 'Robinson', 'Izzy', 'Accountant', 'Payroll', 'irobinson@evas.com', 'IR75300'),
    (DEFAULT, 'Quientela', 'Jackie', 'Advertising Analyst', 'Marketing', 'jquientela@evas.com', 'JQ9510'),
    (DEFAULT, 'Paulson', 'Kenny', 'Mail Clerk', 'Shipping and Recieving', 'kpaulson@evas.com', 'KP8642'),
    (DEFAULT, 'Opal', 'Laura', 'Senior Manager', 'Payroll', 'lopal@evas.com', 'LO3159'), -- manager level
    (DEFAULT, 'Nelson', 'Manny', 'Junior Manager', 'Marketing', 'mnelson@evas.com', 'MN9357'); -- manager level
 
INSERT INTO Reimbursement VALUES                        -- need to resolve null entries at reimbursement table
    (DEFAULT, DEFAULT, DEFAULT, DEFAULT, 'pending'),
    (DEFAULT, DEFAULT, DEFAULT, DEFAULT, 'resolved'),
    (DEFAULT, DEFAULT, DEFAULT, DEFAULT, 'rejected'),
    (DEFAULT, DEFAULT, DEFAULT, DEFAULT, 'pending'),
    (DEFAULT, DEFAULT, DEFAULT, DEFAULT, 'pending'),
    (DEFAULT, DEFAULT, DEFAULT, DEFAULT, 'resolved');



INSERT INTO Manager VALUES  -- if needed values will be added
    (DEFAULT);

-- for image table, values may need to be inserted from outside sql
INSERT INTO Image VALUES
     (DEFAULT, DEFAULT, DEFAULT, DEFAULT);


 
 
-- Queries of Tables
--------------------
SELECT * FROM Employee;

SELECT * FROM Manager;

SELECT * FROM Reimbursement;

SELECT * FROM Image;

-- Select statements used for Java code
----------------------------------------
SELECT * FROM Employee WHERE username = 'fursa@evas.com' -- remove 'fursa@evas.com' and replace with ?

-- SELECT * FROM Employee FULL JOIN Reimbursement ON employee.employeeid = reimbursement.reimbursementid 

-- Updating balance
-------------------

    