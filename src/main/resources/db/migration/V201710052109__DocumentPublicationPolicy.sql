CREATE EXTENSION pgcrypto;
CREATE TABLE IF NOT EXISTS document_publication_policies(
  id SERIAL PRIMARY KEY,
  document_id integer NOT NULL REFERENCES documents ON DELETE CASCADE,
  token uuid NOT NULL DEFAULT gen_random_uuid(),
  exipires_datetime TIMESTAMP NOT NULL,
  created_datetime TIMESTAMP NOT NULL
)