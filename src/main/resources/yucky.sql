CREATE TABLE users
(
  username varchar(50) NOT NULL,
  password varchar(50) NOT NULL,
  enabled boolean NOT NULL DEFAULT true,
  role varchar NOT NULL,
  CONSTRAINT users_pkey PRIMARY KEY (username)
);

CREATE TABLE coffees(
  coffee_id serial,
  name varchar(50) NOT NULL,
  price double precision NOT NULL,
  enabled boolean DEFAULT true,
  CONSTRAINT coffees_pkey PRIMARY KEY (coffee_id),
  CONSTRAINT unique_coffee_name UNIQUE (name)
);

CREATE TABLE condiments
(
  condiment_id serial,
  name varchar(50) NOT NULL,
  price double precision NOT NULL DEFAULT 0,
  enabled boolean DEFAULT true,
  CONSTRAINT condiments_pkey PRIMARY KEY (condiment_id),
  CONSTRAINT unique_condiment_name UNIQUE (name)
);

CREATE TABLE orders
(
  order_id serial,
  username varchar(50),
  purchase_time timestamp without time zone NOT NULL,
  total double precision NOT NULL DEFAULT 0,
  CONSTRAINT orders_pkey PRIMARY KEY (order_id),
  CONSTRAINT orders_username_fkey FOREIGN KEY (username)
      REFERENCES users (username) MATCH SIMPLE
      ON UPDATE CASCADE ON DELETE RESTRICT
);

CREATE TABLE cups
(
  cup_id serial,
  order_id integer NOT NULL,
  coffee_id integer NOT NULL,
  condiments varchar(50),
  size varchar(20) NOT NULL,
  price double precision NOT NULL DEFAULT 0,
  CONSTRAINT cups_pkey PRIMARY KEY (cup_id),
  CONSTRAINT cups_coffee_id_fkey FOREIGN KEY (coffee_id)
      REFERENCES coffees (coffee_id) MATCH SIMPLE
      ON UPDATE CASCADE ON DELETE RESTRICT,
  CONSTRAINT cups_order_id_fkey FOREIGN KEY (order_id)
      REFERENCES orders (order_id) MATCH SIMPLE
      ON UPDATE CASCADE ON DELETE RESTRICT
);

-- insert temp data --
INSERT INTO users(username,password,role) VALUES('admin','1111','ROLE_ADMIN');
INSERT INTO users(username,password,role) VALUES('seller','1111','ROLE_SELLER');
INSERT INTO users(username,password,role) VALUES('quyvd','1111','ROLE_ADMIN');
INSERT INTO users(username,password,role) VALUES('tienlv','1111','ROLE_SELLER');

INSERT INTO coffees(name,price) VALUES('Espresso',2.0);
INSERT INTO coffees(name,price) VALUES('Cuppucino',2.0);
INSERT INTO coffees(name,price) VALUES('Americano',1.5);
INSERT INTO coffees(name,price) VALUES('Black Coffee',1.0);

INSERT INTO condiments(name,price) VALUES('Milk',0.0);
INSERT INTO condiments(name,price) VALUES('Chocolate',0.5);
INSERT INTO condiments(name,price) VALUES('Cream',0.5);
INSERT INTO condiments(name,price) VALUES('Sugar',0);
INSERT INTO condiments(name,price) VALUES('Ice',0);