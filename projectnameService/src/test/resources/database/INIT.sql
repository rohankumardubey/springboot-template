CREATE TABLE message
(
    message_id      BIGSERIAL PRIMARY KEY,
    message_value VARCHAR(255) NOT NULL
);

INSERT INTO message (content) VALUES ('Hello World From Init Script!');
