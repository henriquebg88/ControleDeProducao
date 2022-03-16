USE controleProducao;
GO

DROP TABLE projects;

CREATE TABLE projects (
	id INT PRIMARY KEY IDENTITY NOT NULL,
	name VARCHAR(100) NOT NULL,
	organization_id INT FOREIGN KEY REFERENCES organizations(id) ON DELETE CASCADE NOT NULL
);

INSERT INTO projects VALUES 
	('Stein',1),
	('Pararia Luciano', 1),
	('Apartamento Luciano',1),
	('Controle de produção',2);

SELECT organizations.name as organização, projects.name as projeto FROM organizations
	INNER JOIN projects ON organization_id = organizations.id;

SELECT * FROM organizations;
SELECT * FROM projects;

DELETE FROM projects WHERE id=1;
GO
DBCC CHECKIDENT (projects, RESEED, 0);
GO

