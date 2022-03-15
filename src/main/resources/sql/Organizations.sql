
DROP TABLE organizations;

CREATE TABLE organizations (
	id					INT PRIMARY KEY IDENTITY NOT NULL,
	name				VARCHAR(100) NOT NULL
);

SELECT * FROM organizations;

INSERT INTO organizations VALUES 
	('Deborah Pinheiro Arquitetura'),
	('Kaju Sistemas de Informação'),
	('Maria Jesus, Pastel e Caldo de cana');