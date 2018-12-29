CREATE SEQUENCE public.sn_user_id_seq
  INCREMENT 1
  START 155
  MINVALUE 1
  MAXVALUE 9223372036854775807
  CACHE 1;

ALTER SEQUENCE public.sn_user_id_seq
  OWNER TO postgres;
CREATE TABLE public.sn_user
(
  id                         bigint NOT NULL             DEFAULT nextval('sn_user_id_seq' :: regclass),
  firstname                  character varying(50) COLLATE pg_catalog."default",
  middlename                 character varying(50) COLLATE pg_catalog."default",
  lastname                   character varying(50) COLLATE pg_catalog."default",
  email                      character varying(100) COLLATE pg_catalog."default",
  password                   character varying(60) COLLATE pg_catalog."default",
  role_code                  character varying(10) COLLATE pg_catalog."default",   
  mobileno                   character varying(30) COLLATE pg_catalog."default",
  address                    text COLLATE pg_catalog."default",
  city                       character varying(100) COLLATE pg_catalog."default",
  state                      character varying(100) COLLATE pg_catalog."default",
  country                    character varying(100) COLLATE pg_catalog."default",
  zipcode                    character varying(20) COLLATE pg_catalog."default",
  ssn                        character varying(20) COLLATE pg_catalog."default", 
  position                   character varying(100) COLLATE pg_catalog."default",  
  register_date              timestamp without time zone DEFAULT now(),
  last_login_date            timestamp without time zone DEFAULT now(),
  status                     integer                     DEFAULT 0,
  CONSTRAINT pk_sn_user PRIMARY KEY (id)
)
WITH (
OIDS = FALSE
)
TABLESPACE pg_default;

