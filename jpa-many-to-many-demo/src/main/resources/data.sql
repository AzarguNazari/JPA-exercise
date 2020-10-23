
INSERT INTO POSTS (ID, CONTENT, DESCRIPTION, LAST_UPDATED_AT, POSTED_AT, TITLE) VALUES
(1, 'post 1 content', 'description for post 1', '2020-11-10', '2020-11-09', 'Title for Post 1'),
(2, 'post 2 content', 'description for post 2', '2020-11-10', '2020-11-09', 'Title for Post 2');

INSERT INTO TAGS (ID, NAME) VALUES
(1, 'java'),
(2, 'php');

INSERT INTO POST_TAGS(POST_ID, TAG_ID) VALUES
(1, 1),
(1, 2),
(2, 1),
(2, 2);
