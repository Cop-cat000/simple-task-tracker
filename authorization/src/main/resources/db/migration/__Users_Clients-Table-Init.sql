CREATE TABLE "users_clients" (
  "user_id" bigint NOT NULL,
  "client_id" bigint NOT NULL
);

ALTER TABLE "users_clients" ADD FOREIGN KEY ("user_id") REFERENCES "users" ("id");

ALTER TABLE "users_clients" ADD FOREIGN KEY ("client_id") REFERENCES "clients" ("id");