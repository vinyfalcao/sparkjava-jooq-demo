CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE "store"(
"uuid" uuid PRIMARY KEY DEFAULT uuid_generate_v4(),
"name" VARCHAR(200)
);