CREATE TABLE IF NOT EXISTS documents(
  id SERIAL PRIMARY KEY,
  user_id integer NOT NULL REFERENCES users ON DELETE CASCADE,
  title VARCHAR(128) NOT NULL,
  body text NOT NULL,
  updated_datetime TIMESTAMP NOT NULL,
  created_datetime TIMESTAMP NOT NULL
)
