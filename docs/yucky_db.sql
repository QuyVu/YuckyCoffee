CREATE DATABASE yucky
    ENCODING = 'UTF8';

DROP TABLE if exists users CASCADE;
CREATE TABLE users
(
  username varchar(50) NOT NULL,
  password varchar(50) NOT NULL,
  enabled boolean NOT NULL DEFAULT true,
  role varchar(50) NOT NULL,
  CONSTRAINT pkey_users PRIMARY KEY (username)
);

DROP TABLE IF EXISTS coffees CASCADE;
CREATE TABLE coffees(
  coffee_id serial NOT NULL,
  name varchar(50) NOT NULL,
  price double precision NOT NULL,
  enabled boolean NOT NULL DEFAULT true,
  CONSTRAINT pkey_coffees PRIMARY KEY (coffee_id),
  CONSTRAINT unique_coffee_name UNIQUE (name)
);

DROP TABLE IF EXISTS condiments CASCADE;
CREATE TABLE condiments
(
  condiment_id serial NOT NULL,
  name varchar(50) NOT NULL,
  price double precision NOT NULL,
  enabled boolean NOT NULL DEFAULT true,
  CONSTRAINT condiments_pkey PRIMARY KEY (condiment_id),
  CONSTRAINT unique_condiment_name UNIQUE (name)
);

DROP TABLE IF EXISTS orders CASCADE;
CREATE TABLE orders
(
  order_id serial NOT NULL,
  username varchar(50) NOT NULL,
  purchase_time timestamp without time zone NOT NULL,
  total double precision NOT NULL,
  CONSTRAINT pkey_orders PRIMARY KEY (order_id),
  CONSTRAINT fkey_order_of_user FOREIGN KEY (username)
      REFERENCES users (username) MATCH SIMPLE
      ON UPDATE CASCADE ON DELETE RESTRICT
);

DROP TABLE IF EXISTS cups CASCADE;
CREATE TABLE cups
(
  cup_id serial NOT NULL,
  order_id integer NOT NULL,
  coffee_id integer NOT NULL,
  size varchar(20) NOT NULL,
  condiments varchar(50),
  price double precision NOT NULL DEFAULT 0,
  CONSTRAINT pkey_cups PRIMARY KEY (cup_id),
  CONSTRAINT fkey_cup_of_coffee FOREIGN KEY (coffee_id)
      REFERENCES coffees (coffee_id) MATCH SIMPLE
      ON UPDATE CASCADE ON DELETE RESTRICT,
  CONSTRAINT fkey_cup_of_order FOREIGN KEY (order_id)
      REFERENCES orders (order_id) MATCH SIMPLE
      ON UPDATE CASCADE ON DELETE RESTRICT
);

-- default admin --
INSERT INTO users(username,password,role) VALUES('admin','1111','ROLE_ADMIN');