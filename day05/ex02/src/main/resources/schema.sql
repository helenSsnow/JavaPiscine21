CREATE TABLE IF NOT EXISTS users (
    id INTEGER PRIMARY KEY,
    login varchar(20) NOT NULL UNIQUE,
    password varchar(20) NOT NULL
);

CREATE TABLE IF NOT EXISTS chats (
    id INTEGER PRIMARY KEY,
    name varchar(20) NOT NULL UNIQUE,
    userId INTEGER NOT NULL
);

CREATE TABLE IF NOT EXISTS messages (
    id INTEGER PRIMARY KEY,
    authorId INTEGER NOT NULL,
    chatId  INTEGER NOT NULL,
    text text,
    date TIMESTAMP
);

ALTER TABLE chats
    ADD FOREIGN KEY (userId)
        REFERENCES users(id);

ALTER TABLE messages
    ADD FOREIGN KEY (authorId)
        REFERENCES users(id);

ALTER TABLE messages
    ADD FOREIGN KEY (chatId)
        REFERENCES chats(id);

ALTER USER postgres WITH LOGIN PASSWORD '7V3ydasi120495/'