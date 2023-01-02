drop database if exists db_positive_split_calculator;

create database positive_calculator;

-- create sequences

create sequence pk_run_record_id_seq
    start with
        1 increment by 1;

create sequence pk_split_record_id_seq start with
    1 increment by 1;

create sequence pk_type_curve_id_seq start with
    1 increment by 1;


-- create tables

create table run_records
(
    pk_run_record_id   BIGINT not null default nextval('pk_run_record_id_seq') primary key,
    name_run_record    VARCHAR(255),
    distance           DOUBLE precision,
    total_time_seconds INT,
    fk_type_curve_id   BIGINT not null
);


create table split_records
(
    pk_split_record_id BIGINT not null default nextval('pk_split_record_id_seq') primary key,
    distance           DOUBLE precision
);

create table type_curves
(
    pk_type_curve_id BIGINT not null default nextval('pk_type_curve_id_seq') primary key,
    name_type_curve  VARCHAR(255),
    formula          VARCHAR(255)
);

create table run_split_records
(
    fk_run_record_id   BIGINT,
    fk_split_record_id BIGINT,
    time_split_seconds INT not null
);

-- create foreign keys


alter table run_records
    add constraint fk_type_curve_id foreign key (fk_type_curve_id) references type_curves (pk_type_curve_id);

alter table run_split_records
    add constraint fk_run_record_id foreign key (fk_run_record_id) references run_records (pk_run_record_id);

alter table run_split_records
    add constraint fk_split_record_id foreign key (fk_split_record_id) references split_records (pk_split_record_id);

ALTER TABLE public.run_records DROP CONSTRAINT fk_type_curve_id;
ALTER TABLE public.run_records ADD CONSTRAINT fk_type_curve_id FOREIGN KEY (fk_type_curve_id) REFERENCES public.type_curves(pk_type_curve_id) ON DELETE SET NULL;



