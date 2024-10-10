\connect mobile_lines_db

create schema if not exists lines;
set search_path to lines;

create table mobile_lines (
    id bigserial not null,
    user_login varchar(36) not null,
    company varchar(36) not null,
    telephone varchar(36) not null unique,
    extension varchar(36) not null unique,
    registration_date date null,
    cancellation_date date null,
    rate varchar(36) null,
    notes text null,
    created_at timestamptz NOT NULL,
    updated_at timestamptz NULL,
    constraint lines_pk primary key (id)
);

-- Should there be a company tables, rate tables, users tables to store some data ????