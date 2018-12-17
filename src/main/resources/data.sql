INSERT INTO users
(user_id, name)
 VALUES
(1, 'John');

INSERT INTO users
(user_id, name)
 VALUES
(2, 'Jack');

INSERT INTO
    users
    (user_id, name)
 VALUES
(3, 'Mark');

INSERT INTO
    subscribers
    (user_id, subscriber_user_id)
 VALUES
(3, 2);

--UPDATE
--    HIBERNATE_SEQUENCES
--SET NEXT_VAL = 3
--WHERE SEQUENCE_NAME = 'default';
INSERT INTO
    HIBERNATE_SEQUENCES
        (SEQUENCE_NAME, NEXT_VAL)
VALUES
        ('default', 5);

