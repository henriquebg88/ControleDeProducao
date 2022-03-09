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
	organizationId INT FOREIGN KEY REFERENCES organizations(id) NOT NULL,
	UNIQUE (username, organizationId)
);

CREATE TABLE projects (
	id INT PRIMARY KEY IDENTITY NOT NULL,
	name VARCHAR(100) NOT NULL,
	organizationId INT FOREIGN KEY REFERENCES organizations(id) NOT NULL
);

CREATE TABLE phases (
	id INT PRIMARY KEY IDENTITY NOT NULL,
	name VARCHAR(100) NOT NULL,
	projectId INT FOREIGN KEY REFERENCES projects(id) NOT NULL
);

CREATE TABLE activities (
	id INT PRIMARY KEY IDENTITY NOT NULL,
	short_description VARCHAR(50) NOT NULL,
	details VARCHAR(255) DEFAULT NULL,
	activity_start DATE NOT NULL,
	activity_end DATE DEFAULT NULL,
	phaseId INT FOREIGN KEY REFERENCES phases(id) NOT NULL,
	username VARCHAR(45) FOREIGN KEY REFERENCES users(username) NOT NULL
);
	