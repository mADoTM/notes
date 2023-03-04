CREATE TABLE note
(
    id SERIAL,
    text VARCHAR NOT NULL,
    CONSTRAINT note_pk PRIMARY KEY (id)
);