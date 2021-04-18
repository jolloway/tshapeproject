DROP TABLE IF EXISTS TICKETS;

CREATE TABLE TICKETS (
                         id BIGINT AUTO_INCREMENT  PRIMARY KEY,
                         AUTHOR VARCHAR(250) NOT NULL,
                         TITLE VARCHAR(250) NOT NULL,
                         STATUS VARCHAR(250) NOT NULL,
                         DESCRIPTION VARCHAR(1023) NOT NULL,
                         LAST_EDITED DATE DEFAULT NULL
);