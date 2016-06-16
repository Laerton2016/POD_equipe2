
CREATE TABLE Person (
 id int NOT NULL UNIQUE,
 name character varying(100) NOT NULL,
 PRIMARY KEY (id)
);

CREATE TABLE Product (
 id int NOT NULL UNIQUE,
 name character varying(100) NOT NULL,
 PRIMARY KEY (id)
);


CREATE TABLE Salesman (
 personid int NOT NULL UNIQUE,
 phone character varying(50) NOT NULL,
PRIMARY KEY (personid)
 
);


CREATE TABLE Order1 (
 id character varying(20) NOT NULL UNIQUE,
 salesmanid int NOT NULL,
productid int  NOT NULL,
quantity int  NOT NULL,
 PRIMARY KEY (id)
);