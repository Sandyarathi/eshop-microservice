CREATE KEYSPACE cmpe282project WITH replication = {'class': 'SimpleStrategy', 'replication_factor': '1'}  AND durable_writes = true;

use cmpe282project;

CREATE TABLE customer(customer_id uuid PRIMARY KEY, email text, password text, first_name text, last_name text, created timestamp);

CREATE TABLE pr

CREATE TABLE post(id uuid PRIMARY KEY, headline text, content text, category text, created timestamp, updated timestamp);


CREATE TABLE post_category(id uuid PRIMARY KEY, name text, created timestamp);

CREATE TABLE user_posts(id uuid PRIMARY KEY, user_id text, post_id uuid);

CREATE INDEX user_posts_user_id_idx on cmpe282project.user_posts(user_id);

CREATE INDEX user_posts_post_id_idx on cmpe282project.user_posts(post_id);

CREATE TABLE post_ratings(id uuid PRIMARY KEY, post_id uuid, rating int);

CREATE INDEX post_id_idx on cmpe282project.post_ratings(post_id);

CREATE TABLE user_preferences(id uuid PRIMARY KEY, user_id text, category_id uuid);

CREATE INDEX user_preferences_user_id_idx on cmpe282project.user_preferences(user_id);

CREATE INDEX user_preferences_category_id_idx on cmpe282project.user_preferences(category_id);

INSERT INTO post(id, headline, content, category, created, updated) VALUES (479b384c-1253-11e6-a148-3e1d05defe78, 'Headline-1', 'This is Test-1', 'Category-1', toTimestamp(now()), toTimestamp(now()));
INSERT INTO post(id, headline, content, category, created, updated) VALUES (c025ddb0-125a-11e6-a148-3e1d05defe78, 'Headline-2', 'This is Test-2', 'Category-2', toTimestamp(now()), toTimestamp(now()));

INSERT INTO user(user_id, first_name, last_name, created) VALUES ('john@mail.com', 'John', 'Doe', toTimestamp(now()));
INSERT INTO user(user_id, first_name, last_name, created) VALUES ('mike@mail.com', 'Michael', '', toTimestamp(now()));

INSERT INTO post_category(id, name, created) VALUES (uuid(), 'Sports', toTimestamp(now()));
INSERT INTO post_category(id, name, created) VALUES (uuid(), 'Politics', toTimestamp(now()));
INSERT INTO post_category(id, name, created) VALUES (uuid(), 'Movies', toTimestamp(now()));
INSERT INTO post_category(id, name, created) VALUES (uuid(), 'Music', toTimestamp(now()));

INSERT INTO user_posts(id, user_id, post_id) VALUES (uuid(), 'john@mail.com',479b384c-1253-11e6-a148-3e1d05defe78);
INSERT INTO user_posts(id, user_id, post_id) VALUES (uuid(), 'john@mail.com',c025ddb0-125a-11e6-a148-3e1d05defe78);

INSERT INTO post_ratings(id, post_id, rating) VALUES (uuid(), 479b384c-1253-11e6-a148-3e1d05defe78, 5);
INSERT INTO post_ratings(id, post_id, rating) VALUES (uuid(), 479b384c-1253-11e6-a148-3e1d05defe78, 7);
INSERT INTO post_ratings(id, post_id, rating) VALUES (uuid(), 479b384c-1253-11e6-a148-3e1d05defe78, 4);
INSERT INTO post_ratings(id, post_id, rating) VALUES (uuid(), 479b384c-1253-11e6-a148-3e1d05defe78, 9);

INSERT INTO post_ratings(id, post_id, rating) VALUES (uuid(), c025ddb0-125a-11e6-a148-3e1d05defe78, 9);
INSERT INTO post_ratings(id, post_id, rating) VALUES (uuid(), c025ddb0-125a-11e6-a148-3e1d05defe78, 8);

INSERT INTO user_preferences (id, category_id, user_id) VALUES (uuid(), 4590408a-125b-11e6-a148-3e1d05defe78, 'john@mail.com');
INSERT INTO user_preferences (id, category_id, user_id) VALUES (uuid(), 607c47a4-125b-11e6-a148-3e1d05defe78, 'john@mail.com');
INSERT INTO user_preferences (id, category_id, user_id) VALUES (uuid(), 607c47a4-125b-11e6-a148-3e1d05defe78, 'mike@mail.com');