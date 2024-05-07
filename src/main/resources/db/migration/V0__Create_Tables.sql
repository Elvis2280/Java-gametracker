
CREATE TABLE game_platform
(
    game_id     INTEGER NOT NULL,
    platform_id INTEGER NOT NULL,
    CONSTRAINT pk_game_platform PRIMARY KEY (game_id, platform_id)
);

CREATE TABLE game_tag
(
    game_id INTEGER NOT NULL,
    tag_id  INTEGER NOT NULL,
    CONSTRAINT pk_game_tag PRIMARY KEY (game_id, tag_id)
);

CREATE TABLE games
(
    id          INTEGER NOT NULL,
    name        VARCHAR(255),
    description VARCHAR(255),
    status      VARCHAR(255),
    image       VARCHAR(255),
    CONSTRAINT pk_games PRIMARY KEY (id)
);

CREATE TABLE platforms
(
    id        INTEGER NOT NULL,
    name      VARCHAR(255),
    icon_name VARCHAR(255),
    CONSTRAINT pk_platforms PRIMARY KEY (id)
);

CREATE TABLE tags
(
    id   INTEGER NOT NULL,
    name VARCHAR(255),
    CONSTRAINT pk_tags PRIMARY KEY (id)
);

CREATE TABLE users
(
    id          INTEGER GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    username    VARCHAR(255),
    email       VARCHAR(255),
    password    VARCHAR(255),
    created_at  TIMESTAMP WITHOUT TIME ZONE,
    update_at   TIMESTAMP WITHOUT TIME ZONE,
    active      BOOLEAN                                  NOT NULL,
    is_verified BOOLEAN                                  NOT NULL,
    CONSTRAINT pk_users PRIMARY KEY (id)
);

ALTER TABLE platforms
    ADD CONSTRAINT uc_platforms_name UNIQUE (name);

ALTER TABLE tags
    ADD CONSTRAINT uc_tags_name UNIQUE (name);

ALTER TABLE game_tag
    ADD CONSTRAINT fk_game_tag_on_game FOREIGN KEY (game_id) REFERENCES games (id);

ALTER TABLE game_tag
    ADD CONSTRAINT fk_game_tag_on_tag FOREIGN KEY (tag_id) REFERENCES tags (id);

ALTER TABLE game_platform
    ADD CONSTRAINT fk_gampla_on_game FOREIGN KEY (game_id) REFERENCES games (id);

ALTER TABLE game_platform
    ADD CONSTRAINT fk_gampla_on_platform FOREIGN KEY (platform_id) REFERENCES platforms (id);