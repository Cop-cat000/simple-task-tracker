CREATE USER authorization WITH PASSWORD 'authorization';
CREATE DATABASE authorization_db WITH OWNER authorization;
GRANT ALL PRIVILEGES ON DATABASE authorization_db TO authorization;

CREATE USER root WITH PASSWORD 'root';
CREATE DATABASE root_db WITH OWNER root;
GRANT ALL PRIVILEGES ON DATABASE root_db TO root;
