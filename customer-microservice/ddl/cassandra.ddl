CREATE KEYSPACE cmpe282project WITH replication = {'class': 'SimpleStrategy', 'replication_factor': '1'}  AND durable_writes = true;

use cmpe282project;

CREATE TABLE customer(customer_id uuid PRIMARY KEY, email text, password text, first_name text, last_name text, created timestamp);
CREATE INDEX ON customer (email);

