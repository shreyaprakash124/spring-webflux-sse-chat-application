
-- Table: public.messages

-- DROP TABLE public.messages;

CREATE TABLE public.messages
(
    message_id bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 2 MINVALUE 2 MAXVALUE 23357888888348 CACHE 1 ),
    sender character varying COLLATE pg_catalog."default",
    receiver character varying COLLATE pg_catalog."default",
    message character varying COLLATE pg_catalog."default",
    channel_id character varying COLLATE pg_catalog."default",
    CONSTRAINT messages_pkey PRIMARY KEY (message_id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.messages
    OWNER to postgres;