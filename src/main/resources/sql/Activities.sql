USE controleProducao;
GO

DROP TABLE activities;

CREATE TABLE activities (
	id					INT PRIMARY KEY IDENTITY NOT NULL,
	short_description	VARCHAR(50)		NOT NULL,
	details				VARCHAR(255)	DEFAULT NULL,
	activity_start		DATETIME		DEFAULT NULL,
	activity_end		DATETIME		DEFAULT NULL,
	phase_id			INT FOREIGN KEY REFERENCES phases(id) ON DELETE SET NULL,
);


INSERT INTO activities VALUES 
	('Planta baixa do piso superior','Inserção de legendas e cotas','2021-12-24 10:00:00', '2021-12-24 19:30:00',1),
	('Planta baixa do subsolo','Inserção de legendas e cotas',		'2021-12-25 09:10:00', '2021-12-25 19:00:00',1),
	('Vistas','Especificação de materiais',							'2021-12-26 10:10:00', '2021-12-26 13:00:00',1),
	('Cortes A e B','Cotas, legendas, ajuste de desenhos',			'2021-12-26 14:30:00', '2021-12-26 20:00:00',1),
	('Cortes C e D','Criação do corte',								'2021-12-27 10:00:00', '2021-12-27 19:00:00',1),
	('Especificação de materiais','Todos os pavimentos',			'2021-12-28 09:40:00', '2021-12-28 19:10:00',2),
	('Visita ao local','As built',									'2021-12-29 10:00:00', '2021-12-29 13:00:00',2),
	('Correções','Ajustes de acordo com as-built',					'2021-12-29 14:10:00', '2021-12-29 19:00:00',2),
	('Projetos complementares','Esgoto e Elétrica',					'2021-12-30 09:30:00', '2021-12-30 18:00:00',2),
	('Projetos complementares','Esgoto e Elétrica',					'2021-12-31 08:00:00', '2021-12-31 16:00:00',2);
		
SELECT * FROM activities;

SELECT	phases.name AS Etapas, 
		activities.short_description AS resumo, 
		activities.details AS Detalhes, 
		activities.activity_start AS Início,
		activities.activity_end AS Fim
			FROM phases
			INNER JOIN activities ON activities.phase_id = phases.id;



