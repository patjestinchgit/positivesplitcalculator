CREATE DATABASE IF NOT EXISTS positive_calculator;

DROP TABLE IF EXISTS run_record;

DELETE SEQUENCE IF EXISTS hibernate_sequence;

CREATE SEQUENCE IF NOT EXISTS hibernate_sequence START WITH 1 INCREMENT BY 1;

CREATE TABLE run_record (
  id BIGINT NOT NULL,
   name VARCHAR(255),
   distance DOUBLE PRECISION,
   total_time TIME WITHOUT TIME ZONE,
   split_distance DOUBLE PRECISION,
   split_times BYTEA,
   CONSTRAINT pk_runrecord PRIMARY KEY (id)
);