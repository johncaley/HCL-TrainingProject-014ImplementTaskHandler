CREATE TABLE task (
	id INT NOT NULL,
	name VARCHAR(32),
	startDate DATE,
	endDate DATE,
	severity VARCHAR(32),
	description VARCHAR(128),
	userId INT NOT NULL,
	PRIMARY KEY(id),
	FOREIGN KEY (userId) REFERENCES User(id)
);