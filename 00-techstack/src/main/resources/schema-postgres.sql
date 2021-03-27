DROP TABLE IF EXISTS subscription;
CREATE TABLE subscription (
   id serial PRIMARY KEY,
   email VARCHAR (80) UNIQUE NOT NULL
);