CREATE USER root WITH PASSWORD 'root';
CREATE DATABASE root WITH OWNER root;
GRANT ALL PRIVILEGES ON DATABASE root TO root;

CREATE DATABASE task_tracker WITH OWNER postgres;