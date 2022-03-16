USE controleProducao;
GO

DROP TABLE phases;

CREATE TABLE phases (
	id INT PRIMARY KEY IDENTITY NOT NULL,
	name VARCHAR(100) NOT NULL,
	sort INT NOT NULL,
	project_id INT FOREIGN KEY REFERENCES projects(id) ON DELETE CASCADE NOT NULL
);

INSERT INTO phases VALUES 
	('Estudo preeliminar',1, 2),
	('Anteprojeto',2, 2),
	('Executivo',3, 2),
	('Analisys',1, 1),
	('Design',2, 1),
	('Estudo preeliminar',1, 3),
	('Anteprojeto',2, 3),
	('Levantamento de requisitos',1, 4),
	('Análise de requisitos',2,4);

SELECT projects.name as Projetos, phases.sort as Ordem, phases.name as Etapas FROM projects
	INNER JOIN phases ON project_id = projects.id
	ORDER BY projects.name, phases.sort;

SELECT * FROM phases;

DELETE FROM phases WHERE id=1;
GO
DBCC CHECKIDENT (phases, RESEED, 0);
GO

