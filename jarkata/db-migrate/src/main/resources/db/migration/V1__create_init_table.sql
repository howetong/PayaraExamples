
create table if not exists person
(
    id bigint not null generated by default as identity (increment 1 start 1 minvalue 1 maxvalue 9223372036854775807 cache 1),
    name character varying(255) collate pg_catalog."default", -- use current setting to sort data
    address character varying(255) collate pg_catalog."default",
    constraint person_pk primary key (id)
);