INSERT INTO profile (email, nickname, gender, attraction, passion) VALUES ('josep@tecnocampus.cat', 'josep', 2, 3, 0);
INSERT INTO profile (email, nickname, gender, attraction, passion) VALUES ('jordi@tecnocampus.cat', 'jordi', 0, 3, 0);
INSERT INTO profile (email, nickname, gender, attraction, passion) VALUES ('maria@tecnocampus.cat', 'maria', 1, 0, 0);
INSERT INTO profile (email, nickname, gender, attraction, passion) VALUES ('marta@tecnocampus.cat', 'marta', 1, 0, 0);
INSERT INTO profile (email, nickname, gender, attraction, passion) VALUES ('pepe@tecnocampus.cat', 'pepeillo', 0, 3, 0);
INSERT INTO profile (email, nickname, gender, attraction, passion) VALUES ('sonia@tecnocampus.cat', 'sonia', 1, 3, 0);


INSERT INTO role(name) VALUES ('ROLE_USER');
INSERT INTO role(name) VALUES ('ROLE_MODERATOR');
INSERT INTO role(name) VALUES ('ROLE_ADMIN');

INSERT INTO user_lab (email, username, password) VALUES ('josep@tecnocampus.cat', 'josep', '{bcrypt}$2a$10$fVKfcc47q6lrNbeXangjYeY000dmjdjkdBxEOilqhapuTO5ZH0co2');
INSERT INTO user_lab (email, username, password) VALUES ('jordi@tecnocampus.cat', 'jordi', '{bcrypt}$2a$10$fVKfcc47q6lrNbeXangjYeY000dmjdjkdBxEOilqhapuTO5ZH0co2');
INSERT INTO user_lab (email, username, password) VALUES ('maria@tecnocampus.cat', 'maria', '{bcrypt}$2a$10$fVKfcc47q6lrNbeXangjYeY000dmjdjkdBxEOilqhapuTO5ZH0co2');


INSERT INTO user_roles (USER_ID, ROLE_ID) VALUES (1, 1);
INSERT INTO user_roles (USER_ID, ROLE_ID) VALUES (2, 3);
INSERT INTO user_roles (USER_ID, ROLE_ID) VALUES (3, 1);
INSERT INTO user_roles (USER_ID, ROLE_ID) VALUES (3, 3);