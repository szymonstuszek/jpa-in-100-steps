insert into COURSES(id, COURSE_NAME, created_date, last_updated_date) values (10001, 'JPA in 50 Steps', sysdate(), sysdate());
insert into COURSES(id, COURSE_NAME, created_date, last_updated_date) values (10002, 'Spring in 150 Steps', sysdate(), sysdate());
insert into COURSES(id, COURSE_NAME, created_date, last_updated_date) values (10003, 'Maven in 250 Steps', sysdate(), sysdate());

insert into PASSPORTS(id, number) values(40001,'E123456');
insert into PASSPORTS(id, number) values(40002,'N123456');
insert into PASSPORTS(id, number) values(40003,'W123456');

insert into STUDENTS(id, name, passport_id) values(20001,'Ranga', 40001);
insert into STUDENTS(id, name, passport_id) values(20002,'Adam' , 40002);
insert into STUDENTS(id, name, passport_id) values(20003,'Jane' , 40003);

insert into REVIEWS(id, rating, description) values(50001,'5', 'Great course');
insert into REVIEWS(id, rating, description) values(50002,'4', 'Incredible course');
insert into REVIEWS(id, rating, description) values(50003,'3', 'Awesome course');
