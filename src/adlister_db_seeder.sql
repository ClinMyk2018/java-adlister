USE adlister_db;

TRUNCATE ads;
TRUNCATE users;

INSERT INTO users ( username, email, password)
VALUES ('Willis', 'willis@live.com', 'codeup');

INSERT INTO ads ( user_id, title, description)
VALUES ( 2, 'Bongos', 'All About Bongos');

SELECT * FROM ads;
SELECT * FROM users;