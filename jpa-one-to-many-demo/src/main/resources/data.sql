
INSERT INTO POSTS (ID, CREATED_AT, UPDATED_AT, CONTENT, DESCRIPTION, TITLE) VALUES
(1, '2020-05-9', '2020-05-9', 'This is content for post 1', 'this is description for post 1', 'Post 1'),
(2, '2020-05-9', '2020-05-9', 'This is content for post 2', 'this is description for post 2', 'Post 2');

INSERT INTO COMMENTS (ID, CREATED_AT, UPDATED_AT, TEXT, POST_ID) VALUES
(1, '2020-05-9', '2020-05-9', 'this is comment 1 for post 1', 1),
(2, '2020-05-9', '2020-05-9', 'this is comment 1 for post 2', 1);
