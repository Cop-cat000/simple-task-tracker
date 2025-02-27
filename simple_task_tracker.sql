CREATE TABLE "users" (
  "id" bigint GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
  "username" varchar(50) UNIQUE NOT NULL,
  "email" varchar(50) UNIQUE NOT NULL,
  "password" varchar(72) NOT NULL,
  "role" enum('ROOT','ADMIN','USER') NOT NULL
);

CREATE TABLE "clients" (
  "id" bigint GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
  "client_id" varchar(50) UNIQUE NOT NULL,
  "secret" varchar(72) NOT NULL,
  "scope" varchar(50) NOT NULL,
  "auth_method" varchar(50) NOT NULL,
  "grant_type" varchar(50) NOT NULL,
  "redirect_uri" varchar(256) NOT NULL
);

CREATE TABLE "users_clients" (
  "user_id" bigint NOT NULL,
  "client_id" bigint NOT NULL
);

CREATE TABLE "tasks" (
  "id" bigint GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
  "header" varchar(50) NOT NULL,
  "description" varchar(100),
  "status" enum('PENDING','IN PROGRESS','DONE') NOT NULL,
  "priority" enum('LOW','MEDIUM','HIGH') NOT NULL,
  "comment" varchar(100),
  "author_id" bigint NOT NULL,
  "executor_id" bigint NOT NULL,
  "created_at" timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  "started_at" timestamp ,
  "finished_at" timestamp
);

ALTER TABLE "users_clients" ADD FOREIGN KEY ("user_id") REFERENCES "users" ("id");

ALTER TABLE "users_clients" ADD FOREIGN KEY ("client_id") REFERENCES "clients" ("id");

CREATE TABLE "tasks_users" (
  "tasks_author_id" bigint,
  "users_id" bigint,
  PRIMARY KEY ("tasks_author_id", "users_id")
);

ALTER TABLE "tasks_users" ADD FOREIGN KEY ("tasks_author_id") REFERENCES "tasks" ("author_id");

ALTER TABLE "tasks_users" ADD FOREIGN KEY ("users_id") REFERENCES "users" ("id");


CREATE TABLE "tasks_users(1)" (
  "tasks_executor_id" bigint,
  "users_id" bigint,
  PRIMARY KEY ("tasks_executor_id", "users_id")
);

ALTER TABLE "tasks_users(1)" ADD FOREIGN KEY ("tasks_executor_id") REFERENCES "tasks" ("executor_id");

ALTER TABLE "tasks_users(1)" ADD FOREIGN KEY ("users_id") REFERENCES "users" ("id");

