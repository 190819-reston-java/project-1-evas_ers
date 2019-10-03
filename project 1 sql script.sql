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
    employeepassword varchar(50) NOT NULL, -- use as password , both to identify manager from employee
    reportsto integer,   -- just do a self join to combine manager and employee as managers are employees
    FOREIGN KEY (reportsto) REFERENCES Employee
    
);

-- DROP TABLE Employee CASCADE   -- used to reset (DON'T DROP THE TABLE !!!)

-- Request Table 
----------------
CREATE TABLE Request(
    requestid serial PRIMARY KEY,
    requestvalue NUMERIC (8,2) DEFAULT (0.00),
    requeststatus varchar(20) DEFAULT ('OPEN'),
    requestcatagory varchar (50)DEFAULT ('OTHER'),
    requestdescription varchar (200),
    requestdate date DEFAULT now(),
    eventdate date DEFAULT NOW(),
    requestinformation varchar (1000),
    employeerequest integer,
    FOREIGN KEY (employeerequest) REFERENCES Employee(employeeid)
    
);

--ALTER TABLE request
--ADD CONSTRAINT fk_image_Nto1
--FOREIGN KEY (imageid) REFERENCES Image(imageid);

DROP TABLE Request CASCADE   -- used to reset (DO NOT DROP TABLE)

-- Reimbursement Table
----------------------
CREATE TABLE Reimbursement(
    reimbursementid serial PRIMARY KEY,
    reimbursementamount NUMERIC (8,2) DEFAULT(0.00),
    reimbursementdate date DEFAULT NOW(),
    reimbursementstatus varchar(50),
    employeereimbursement integer,
    FOREIGN KEY (employeereimbursement) REFERENCES Employee(employeeid)
);

ALTER TABLE Reimbursement
ADD CONSTRAINT fk_Reimbursement_Nto1
FOREIGN KEY (reimbursementmanager) REFERENCES Employee(employeeid);

-- DROP TABLE reimbursement CASCADE  (DO NOT DROP THE TABLE)

-- Manager Table 
----------------
--CREATE TABLE Manager( -- may need to change to bool and have no PK
--    managerid serial PRIMARY KEY,
--    managerlevel integer,
--    managerlastname varchar(50),
--    managerfirstname varchar(50),
--    FOREIGN KEY (managerlevel) REFERENCES Employee(reportsto)
--);
--
----ALTER TABLE Manager
----ADD CONSTRAINT fk_employee_Nto1
----FOREIGN KEY (employeeid) REFERENCES Employee(employeeid);
--
--DROP TABLE Manager CASCADE   -- used to reset

-- Reports Table -- to join employee and manager 
-------------------------------------------------
--CREATE TABLE Reports(
--    reportid serial PRIMARY KEY,
--    managerid integer, -- FK
--    employeeid integer, -- FK
--    FOREIGN KEY (employeeid) REFERENCES Employee(employeeid),
--    FOREIGN KEY (managerid) REFERENCES Manager(managerid)
--    
--);    
--
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
    (1, 'Vila', 'Efrain', 'Manager', 'ev', '4321'),-- manager level
    (DEFAULT, 'Snipe', 'Adam', 'Employee', 'as', '1234'),
    (DEFAULT, 'Opal', 'Laura', 'Manager', 'lopal@evas.com', 'LO3159'), -- manager level
    (DEFAULT, 'Nelson', 'Manny', 'Manager', 'mnelson@evas.com', 'MN9357'),-- manager level
    (DEFAULT, 'Ursa', 'Frank', 'Hardware Developer', 'fursa@evas.com', 'FU9630'),
    (DEFAULT, 'Thomas', 'Greg', 'Software Developer', 'gthomas@evas.com', 'GT8520'),
    (DEFAULT, 'Samson', 'Helen', 'Robotic Engnineer', 'hsamson@evas.com', 'HS7410'),
    (DEFAULT, 'Robinson', 'Izzy', 'Accountant', 'irobinson@evas.com', 'IR75300'),
    (DEFAULT, 'Quientela', 'Jackie', 'Advertising Analyst', 'jquientela@evas.com', 'JQ9510'),
    (DEFAULT, 'Paulson', 'Kenny', 'Mail Clerk', 'kpaulson@evas.com', 'KP8642')
    
    
 
--INSERT INTO reports VALUES
--    (DEFAULT, DEFAULT),
--    (DEFAULT, DEFAULT),
--    (DEFAULT, DEFAULT),
--    (DEFAULT, DEFAULT),
--    (DEFAULT, DEFAULT),
--    (DEFAULT, DEFAULT),
--    (DEFAULT, DEFAULT),
--    (DEFAULT, DEFAULT);


INSERT INTO Reimbursement VALUES                -- need to resolve null entries at reimbursement table
    (DEFAULT, 56.93, '2019-09-19'),
    (DEFAULT, 24.25, '2019-06-10'),
    (DEFAULT, 50.00, '2019-04-27'),
    (DEFAULT, 36.58, '2019-02-19'),
    (DEFAULT, 25.15, '2019-01-19'),
    (DEFAULT, 5.95, '2019-02-19'),
    (DEFAULT, 90.00, '2019-07-19'),
    (DEFAULT, 2.99, DEFAULT);




--INSERT INTO Manager VALUES  -- if needed values will be added
--    (DEFAULT, DEFAULT),
--    (DEFAULT, DEFAULT),
--    (DEFAULT, DEFAULT),
--    (DEFAULT, DEFAULT),
--    (DEFAULT, DEFAULT),
--    (DEFAULT, DEFAULT),
--    (DEFAULT, DEFAULT),
--    (DEFAULT, DEFAULT);

-- for image table, values may need to be inserted from outside sql
INSERT INTO Image VALUES
     (DEFAULT, DEFAULT, DEFAULT),
     (DEFAULT, DEFAULT, DEFAULT),
     (DEFAULT, DEFAULT, DEFAULT),
     (DEFAULT, DEFAULT, DEFAULT),
     (DEFAULT, DEFAULT, DEFAULT),
     (DEFAULT, DEFAULT, DEFAULT),
     (DEFAULT, DEFAULT, DEFAULT),
     (DEFAULT, DEFAULT, DEFAULT);

-- request table
----------------
INSERT INTO Request VALUES
    (DEFAULT,DEFAULT, 'pending', DEFAULT, DEFAULT),
    (DEFAULT,DEFAULT, 'denied', DEFAULT, DEFAULT),
    (DEFAULT,DEFAULT, 'pending',DEFAULT, DEFAULT),
    (DEFAULT,DEFAULT, 'resolved' , DEFAULT, DEFAULT),
    (DEFAULT,DEFAULT, 'resolved', DEFAULT, DEFAULT),
    (DEFAULT,DEFAULT, 'resolved', DEFAULT, DEFAULT),
    (DEFAULT,DEFAULT, 'pending', DEFAULT, DEFAULT),
    (DEFAULT,DEFAULT, 'denied', DEFAULT, DEFAULT); 
 
-- Queries of Tables
--------------------
SELECT * FROM Employee;

--SELECT * FROM Manager;

SELECT * FROM Reimbursement;

SELECT * FROM Image;

--SELECT * FROM reports;

SELECT * FROM request;


-- Select statements 
----------------------------------------

-- view all info employee  (remove 'fursa@evas.com' and replace with ?)
-------------------------------------------
SELECT * FROM Employee WHERE employeeemail = 'fursa@evas.com' AND employeepassword = 'FU9630';


--view their pending reimbursement requests
-------------------------------------------
SELECT employeelastname, employeefirstname, requeststatus, requestcatagory, requestdate  
FROM employee INNER join request on employeerequest = employee.employeeid WHERE requeststatus = 'pending'; --AND employeeid = 9;


--view their resolved reimbursement requests (remove '7' and replace with ?)
--------------------------------------------
SELECT employeelastname, employeefirstname, requeststatus, requestcatagory, requestdate  
FROM employee INNER join request on employeerequest = employee.employeeid WHERE requeststatus = 'resolved'; --AND employeeid = 9;


--Reports To (This table show employees and the manager they report to)
------------
SELECT concat(e.employeefirstname , ' ', e.employeelastname) "Employee Name", concat(m.employeefirstname , ' ', m.employeelastname) "Reports To" FROM employee e INNER JOIN employee m ON m.employeeid = e.reportsto;

CREATE TABLE reportto AS (SELECT concat(e.employeefirstname , ' ', e.employeelastname) "Employee Name", concat(m.employeefirstname , ' ', m.employeelastname) "Reports To" FROM employee e INNER JOIN employee m ON m.employeeid = e.reportsto);

-- view all employees
----------------------
SELECT * FROM employee;

-- view image(remove '1' and replace with ?) [ till need to test image]
------------------------------------------
SELECT * FROM image WHERE imageid = 1;


--view all pending reimbursement requests
------------------------------------------
SELECT employeelastname, employeefirstname, requeststatus, requestcatagory, requestdate  
FROM employee INNER join request on employeerequest = employee.employeeid WHERE requeststatus = 'pending'

--view all resolved reimbursement requests (WIP) need alias and/or function
-------------------------------------------
SELECT employeelastname, employeefirstname, requeststatus, requestcatagory, requestdate  
FROM employee INNER join request on employeerequest = employee.employeeid WHERE requeststatus = 'resolved'


-- view reimbursement requests from a single Employee 
-----------------------------------------------------
SELECT employeelastname, employeefirstname, requeststatus, requestcatagory, requestdate  
FROM employee INNER join request on employeerequest = employee.employeeid WHERE employeeid = 5;


-- submittting a reimbursement
------------------------------
--INSERT INTO request VALUES (DEFAULT, ?,?,?,?,?,?);
INSERT INTO request VALUES (DEFAULT, 9.99, 'food', DEFAULT, 'lunch at site', '2019-09-10', '2019-09-08', 5, 'lunch was not provided');

-- Updating tables (WIP)
-------------------
--INSERT INTO image VALUES (DEFAULT, ?,?);
--
UPDATE employee SET employelastname=?, employeefirstname=?, employeeposition=?, employeeemail=?, employeepassword=? WHERE employeeid = ?;
--
INSERT INTO image VALUES (DEFAULT, 'testimage', 'C:\Users\Slimebow\Desktop\rtdwebicon.jpg');
--
--UPDATE request SET requestvalue=50.00, requeststatus='pending', requestcatagory = 'Travel', requestdescription = 'Work-related', requestdate='2019-09-19', eventdate='2019-08-19', requestinformation = 'need money' WHERE requestid = 9;
--UPDATE request SET requestvalue= ?, requeststatus = ?, requestcatagory = ?, requestdescription = ?, requestdate = ?, eventdate = ?, requestinformation = ? WHERE requestid = ?
--SELECT * FROM reimbursement WHERE reimbursementid = 2;
SELECT requestid, requestvalue, reimbursementamount, employeereimbursement, requeststatus, reimbursementstatus
FROM request INNER JOIN reimbursement on request.employeerequest = reimbursement.employeereimbursement;

SELECT requestdescription, requestvalue, requeststatus, employeerequest, employeereimbursement, reimbursementstatus, reimbursementamount FROM request INNER JOIN reimbursement ON request.employeerequest = reimbursement.employeereimbursement;


UPDATE reimbursement SET reimbursementamount = request.requestvalue FROM request WHERE reimbursement.employeereimbursement= request.employeerequest ;
-- need to test uploading an image to sql database
-- need to adjust the fields for the needs of the project


------------------------
INSERT INTO public.request (requestvalue,requeststatus,requestcatagory,requestdescription,requestdate,eventdate,requestinformation,employeerequest) VALUES 
(2.99,'pending','Supplies','Pens','2019-09-30','2019-09-30','Site had no pens', 5)
,(9.99,'resolved','Travel','Work-related','2019-09-19','2019-08-19','need money',6)
,(9.99,'resolved','Food','lunch at site','2019-09-10','2019-09-08','lunch was not provided',6)
,(12.55,'resolved','Food','Lunch','2019-09-30','2019-09-30','Location charges for food', 7)
,(29.25,'resolved','Fuel','Home','2019-09-28','2019-10-01','Short trip',9)
,(19.99,'denied','OTHER','Shirt replacement','2019-09-30','2019-09-30','Shirt was damaged on site',5)
,(12.25,'denied','Fuel','Travel to Site','2019-09-30','2019-09-30','It was far',5)
,(10.50,'resolved','Fuel','Travel to Site','2019-09-30','2019-09-30','Long distance work Site',9)
,(2.75,'resolved','Travel','Public Transit','2019-09-30','2019-09-30','Going to Work Site', 9)
,(5.50,'resolved','Travel','Public Transit','2019-09-30','2019-09-30','Going to Work Site', 9)
;
----------------------------
INSERT INTO public.reportto ("Employee Name","Reports To") VALUES 
('Laura Opal','Efrain Vila')
,('Manny Nelson','Laura Opal')
,('Frank Ursa','Manny Nelson')
,('Greg Thomas','Manny Nelson')
,('Helen Samson','Manny Nelson')
,('Izzy Robinson','Laura Opal')
,('Jackie Quientela','Laura Opal')
,('Adam Snipe','Efrain Vila')
,('Java Spring','Laura Opal')
;
-----------------------------
INSERT INTO public.reimbursement (reimbursementamount,reimbursementdate,reimbursementstatus,employeereimbursement,reimbursementmanager) VALUES 
(19.99,'2019-02-19','pending',5,2)
,(12.25,'2019-01-19','pending',5,3)
,(2.99,'2019-02-19','pending',5,2)
,(2.75,'2019-09-19','resolved',9,3)
,(5.50,'2019-09-30','resolved',9,2)
,(10.50,'2019-07-19','resolved',9,1)
,(29.25,'2019-06-10','resolved',9,2)
,(9.99,'2019-06-10','resolved',6,3)
,(9.99,'2019-09-19','resolved',6,3)
,(12.55,'2019-04-27','resolved',7,2)
;
------------------------------------
INSERT INTO public.image (imagename,image) VALUES 
(NULL,NULL)
,(NULL,NULL)
,(NULL,NULL)
,(NULL,NULL)
,(NULL,NULL)
,(NULL,NULL)
,(NULL,NULL)
,(NULL,NULL)
,(NULL,NULL)
,(NULL,NULL)
;
-------------------------------------
INSERT INTO public.employee (employeelastname,employeefirstname,employeeposition,employeeemail,employeepassword,reportsto) VALUES 
('Vila','Efrain','Manager','ev','4321',NULL)
,('Opal','Laura','Manager','lopal@evas.com','LO3159',1)
,('Nelson','Manny','Manager','mnelson@evas.com','MN9357',3)
,('Ursa','Frank','Hardware Developer','fursa@evas.com','FU9630',4)
,('Thomas','Greg','Software Developer','gthomas@evas.com','GT8520',4)
,('Samson','Helen','Robotic Engnineer','hsamson@evas.com','HS7410',4)
,('Robinson','Izzy','Accountant','irobinson@evas.com','IR75300',3)
,('Quientela','Jackie','Advertising Analyst','jquientela@evas.com','JQ9510',3)
,('Snipe','Adam','Employee','as','1234',1)
,('Spring','Java','Coder','jspring@evas.com','js9876',3)
;
--------------------------------------------------------
SELECT r.reimbursementid, r.reimbursementamount, r.reimbursementdate, r.reimbursementstatus, (e.employeefirstname, e.employeelastname) AS "Employee Name" FROM reimbursement r, employee e WHERE r.employeereimbursement = e.employeeid
INNER JOIN e ON r.reimbursementmanager = e.employeeid    

DROP VIEW "employee_with_manager";
CREATE OR REPLACE VIEW "employee_with_manager" AS
SELECT e.employeeid, concat(e.employeefirstname , ' ', e.employeelastname) "Employee Name", e.employeeposition, concat(m.employeefirstname , ' ', m.employeelastname) "Reports To" FROM employee e INNER JOIN employee m ON m.employeeid = e.reportsto;

SELECT * FROM employee_with_manager;

SELECT * FROM reimbursement WHERE employeereimbursement = 5;
----------------------------


DROP VIEW "request_with_manager";

CREATE OR REPLACE VIEW "request_with_manager" AS
SELECT r.employeerequest "Employee Id", concat(e.employeefirstname , ' ', e.employeelastname) "Employee Name", r.requestvalue "Requested Amount", r.requestcatagory "Catagory", r.requestdescription "Description", r.requestinformation "Information", concat(m.employeefirstname , ' ', m.employeelastname) "Manager" FROM request r INNER join employee e ON r.employeerequest = e.employeeid INNER JOIN employee m ON m.employeeid = e.reportsto;

SELECT * FROM request_with_manager;

---------------

