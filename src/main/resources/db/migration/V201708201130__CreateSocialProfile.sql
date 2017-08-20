CREATE TABLE IF NOT EXISTS social_profiles(
  id SERIAL PRIMARY KEY,
  user_id integer NOT NULL REFERENCES users ON DELETE CASCADE,
  uid VARCHAR(32) NOT NULL,
  provider VARCHAR(30) NOT NULL,
  auth JSON NOT NULL,
  updated_datetime TIMESTAMP NOT NULL,
  created_datetime TIMESTAMP NOT NULL,
  UNIQUE (provider, uid)
)