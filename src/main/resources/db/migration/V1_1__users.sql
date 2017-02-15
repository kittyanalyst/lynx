DROP TABLE IF EXISTS LYNX_USER;

CREATE TABLE LYNX_USER (
        USER_ID SERIAL PRIMARY KEY,
        USER_NAME VARCHAR(25) NOT NULL UNIQUE,
        PASSWORD VARCHAR(100) NOT NULL,
        EMAIL VARCHAR(100) NOT NULL,
        CREATED_BY VARCHAR(25) DEFAULT CURRENT_USER,
        CREATED_DATE TIMESTAMP  DEFAULT CURRENT_TIMESTAMP,
        LAST_UPDATED_BY VARCHAR(25) DEFAULT CURRENT_USER,
        LAST_UPDATED_DATE TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


INSERT INTO LYNX_USER (USER_NAME, PASSWORD, EMAIL) VALUES ('rama','password','rchalasani@innovatis.com');