DROP DATABASE IF EXISTS controleProducao;
GO
CREATE DATABASE controleProducao;
GO
USE controleProducao;

CREATE TABLE users (
	username VARCHAR(45) PRIMARY KEY NOT NULL,
	password VARCHAR(68) NOT NULL,
	enabled	 TINYINT NOT NULL,
	email VARCHAR(55) NOT NULL,
	first_name VARCHAR(45) NOT NULL,
	last_name VARCHAR(100) NOT NULL
);

CREATE TABLE authorities (
	username VARCHAR(45) FOREIGN KEY REFERENCES users(username) NOT NULL,
	UNIQUE (username, authority),
	authority VARCHAR(50) NOT NULL
);

CREATE TABLE organizations (
	id INT PRIMARY KEY IDENTITY NOT NULL,
	name VARCHAR(100) NOT NULL
);

CREATE TABLE users_organizations (
	username VARCHAR(45) FOREIGN KEY REFERENCES users(username) NOT NULL,
	organization_id INT FOREIGN KEY REFERENCES organizations(id) NOT NULL,
	UNIQUE (username, organization_id)
);

CREATE TABLE projects (
	id INT PRIMARY KEY IDENTITY NOT NULL,
	name VARCHAR(100) NOT NULL,
	organization_id INT FOREIGN KEY REFERENCES organizations(id) NOT NULL
);

CREATE TABLE phases (
	id INT PRIMARY KEY IDENTITY NOT NULL,
	name VARCHAR(100) NOT NULL,
	sort INT NOT NULL,
	project_id INT FOREIGN KEY REFERENCES projects(id) NOT NULL
);

CREATE TABLE activities (
	id INT PRIMARY KEY IDENTITY NOT NULL,
	short_description VARCHAR(50) NOT NULL,
	details VARCHAR(255) DEFAULT NULL,
	activity_start SMALLDATETIME  NOT NULL,
	activity_end SMALLDATETIME  DEFAULT NULL,
	phase_id INT FOREIGN KEY REFERENCES phases(id) NOT NULL,
	username VARCHAR(45) FOREIGN KEY REFERENCES users(username) NOT NULL
);
	