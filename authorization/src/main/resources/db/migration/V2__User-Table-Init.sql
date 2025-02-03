$2a$10$GrAs7DFUTbO2cXTBn96S7Oj4pLA5T8u2fZ5D1GlizbxQfEeN2CbHG

CREATE TABLE "users" (
  "id" bigint GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
  "username" varchar(50) UNIQUE NOT NULL,
  "email" varchar(50) UNIQUE NOT NULL,
  "password" varchar(72) NOT NULL,
  "role" enum('ROOT','ADMIN','USER') NOT NULL
);

INSERT INTO "users" ("username", "email", "password", "role")
VALUES ('bill', 'bill@mail.com', '$2a$10$GrAs7DFUTbO2cXTBn96S7Oj4pLA5T8u2fZ5D1GlizbxQfEeN2CbHG', 'ROOT');