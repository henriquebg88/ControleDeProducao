
DROP TABLE organizations;

CREATE TABLE organizations (
	id					INT PRIMARY KEY IDENTITY NOT NULL,
	name				VARCHAR(100) NOT NULL
);

INSERT INTO organizations VALUES 
	('Deborah Pinheiro Arquitetura'),
	('Kaju Sistemas de Informação'),
	('Maria Jesus, Pastel e Caldo de cana');

SELECT * FROM organizations;

DELETE FROM organizations WHERE id=id;
GO
DBCC CHECKIDENT (organizations, RESEED, 0);
GO