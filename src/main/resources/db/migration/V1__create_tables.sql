CREATE TABLE producers
(
    id   UUID         NOT NULL,
    name VARCHAR(255) NOT NULL,
    CONSTRAINT pk_producers PRIMARY KEY (id)
);

CREATE TABLE products
(
    id          UUID         NOT NULL,
    name        VARCHAR(255) NOT NULL,
    price       DECIMAL(10, 2),
    producer_id UUID,
    CONSTRAINT pk_products PRIMARY KEY (id)
);

CREATE TABLE roles
(
    id   UUID         NOT NULL,
    role VARCHAR(255) NOT NULL,
    CONSTRAINT pk_roles PRIMARY KEY (id)
);

CREATE TABLE userRoles
(
    role_id UUID NOT NULL,
    user_id UUID NOT NULL,
    CONSTRAINT pk_userroles PRIMARY KEY (role_id, user_id)
);

CREATE TABLE users
(
    id        UUID         NOT NULL,
    email     VARCHAR(255) NOT NULL,
    firstName VARCHAR(255),
    lastName  VARCHAR(255),
    CONSTRAINT pk_users PRIMARY KEY (id)
);

ALTER TABLE roles
    ADD CONSTRAINT uc_roles_role UNIQUE (role);

ALTER TABLE users
    ADD CONSTRAINT uc_users_email UNIQUE (email);

ALTER TABLE products
    ADD CONSTRAINT FK_PRODUCTS_ON_PRODUCER FOREIGN KEY (producer_id) REFERENCES producers (id);

ALTER TABLE userRoles
    ADD CONSTRAINT fk_userroles_on_role_dao FOREIGN KEY (role_id) REFERENCES roles (id);

ALTER TABLE userRoles
    ADD CONSTRAINT fk_userroles_on_user_dao FOREIGN KEY (user_id) REFERENCES users (id);
