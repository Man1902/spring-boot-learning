CREATE TABLE TOPIC_MST(
	ID INT PRIMARY KEY,
	NAME VARCHAR(50) NOT NULL,
    DESCRIPTION VARCHAR(50) NOT NULL
);

CREATE TABLE SUB_TOPIC_MST(
	ID INT PRIMARY KEY,
	NAME VARCHAR(50) NOT NULL,
    DESCRIPTION VARCHAR(50) NOT NULL,
    TOPIC_ID INT NOT NULL,
    foreign key (TOPIC_ID) references TOPIC_MST(ID)
);

-- ALTER TABLE SUB_TOPIC_MST ADD FOREIGN KEY (TOPIC_ID) REFERENCES TOPIC_MST(ID);



