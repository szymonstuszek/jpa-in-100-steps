insert into COURSES(id, COURSE_NAME, created_date, last_updated_date) values (10001, 'JPA in 50 Steps', sysdate(), sysdate());
insert into COURSES(id, COURSE_NAME, created_date, last_updated_date) values (10002, 'Spring in 150 Steps', sysdate(), sysdate());
insert into COURSES(id, COURSE_NAME, created_date, last_updated_date) values (10003, 'Maven in 250 Steps', sysdate(), sysdate());

insert into PASSPORTS(id, number) values(40001,'E123456');
insert into PASSPORTS(id, number) values(40002,'N123456');
insert into PASSPORTS(id, number) values(40003,'W123456');

insert into STUDENTS(id, name, passport_id) values(20001,'Ranga', 40001);
insert into STUDENTS(id, name, passport_id) values(20002,'Adam' , 40002);
insert into STUDENTS(id, name, passport_id) values(20003,'Jane' , 40003);

insert into REVIEWS(id, rating, description, course_id) values(50001,'5', 'Great course', 10001);
insert into REVIEWS(id, rating, description, course_id) values(50002,'4', 'Incredible course', 10001);
insert into REVIEWS(id, rating, description, course_id) values(50003,'5', 'I wish all courses would be like this one', 10001);
insert into REVIEWS(id, rating, description, course_id) values(50004,'3', 'Awesome course', 10003);

insert into STUDENT_COURSE(STUDENT_ID, COURSE_ID) values(20001, 10001);
insert into STUDENT_COURSE(STUDENT_ID, COURSE_ID) values(20002, 10001);
insert into STUDENT_COURSE(STUDENT_ID, COURSE_ID) values(20003, 10001);
insert into STUDENT_COURSE(STUDENT_ID, COURSE_ID) values(20001, 10003);
