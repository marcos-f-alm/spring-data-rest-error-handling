insert into SKILL (UUID, SHORT_NAME, NAME, DESCRIPTION) values ('4e1a5cab-dadf-463b-8c39-040ea4815383', 'JAVA', 'Java (programming language)', 'It is a general-purpose programming language intended to let programmers write once, run anywhere (WORA)');
insert into SKILL (UUID, SHORT_NAME, NAME, DESCRIPTION) values ('127e067e-5362-4bcf-8ab2-bf79c277f51a', 'JS', 'JavaScript', 'It is a programming language that conforms to the ECMAScript specification');
insert into SKILL (UUID, SHORT_NAME, NAME, DESCRIPTION) values ('86dee11f-6a1c-4ce7-a73c-f2f830ca5037', 'PYTHON', 'Python (programming language)', 'It is an interpreted high-level general-purpose programming language.');

insert into DEVELOPER (NICKNAME, EMAIL, DOB) values ('eagle', 'eagle@email.com.br', '1990-05-30');
insert into DEVELOPER (NICKNAME, EMAIL, DOB) values ('mib', 'mib@email.com.br', '2001-07-02');
insert into DEVELOPER (NICKNAME, EMAIL, DOB) values ('deamon', 'deamon@email.com.br', '1985-01-06');

insert into DEVELOPER_SKILLS (DEVELOPER_ID, SKILLS_UUID) values (1, '4e1a5cab-dadf-463b-8c39-040ea4815383');
insert into DEVELOPER_SKILLS (DEVELOPER_ID, SKILLS_UUID) values (1, '127e067e-5362-4bcf-8ab2-bf79c277f51a');
insert into DEVELOPER_SKILLS (DEVELOPER_ID, SKILLS_UUID) values (1, '86dee11f-6a1c-4ce7-a73c-f2f830ca5037');

insert into DEVELOPER_SKILLS (DEVELOPER_ID, SKILLS_UUID) values (2, '4e1a5cab-dadf-463b-8c39-040ea4815383');
insert into DEVELOPER_SKILLS (DEVELOPER_ID, SKILLS_UUID) values (2, '86dee11f-6a1c-4ce7-a73c-f2f830ca5037');

insert into DEVELOPER_SKILLS (DEVELOPER_ID, SKILLS_UUID) values (3, '86dee11f-6a1c-4ce7-a73c-f2f830ca5037');
