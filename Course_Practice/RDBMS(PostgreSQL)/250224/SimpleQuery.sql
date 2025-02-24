CREATE TABLE my_friend(
	fnum int NOT NULL,
	name VARCHAR(30) NOT NULL,
	gender CHAR(1) NOT NULL
);

INSERT INTO my_friend VALUES(1,'홍길동', 1);
INSERT INTO my_friend VALUES(2,'김길동', 0);

SELECT fnum, name, gender FROM my_friend;

ALTER TABLE my_friend RENAME to friend;

SELECT fnum, name, gender FROM friend;

DROP TABLE friend;

SELECT emp_id, emp_name FROM employee WHERE dept_id='SYS';
SELECT * FROM department;

SELECT emp_id, emp_name, dept_id FROM employee WHERE emp_id='S0001';
SELECT dept_id, dept_name, unit_id FROM department WHERE dept_id='SYS';
SELECT * FROM unit WHERE unit_id='A';

SELECT * FROM employee WHERE salary > 7000;
SELECT * FROM employee WHERE hire_date >= '2019-02-28';
SELECT * FROM employee WHERE dept_id <> 'SYS';

SELECT * FROM employee WHERE emp_name LIKE '%국%';
SELECT * FROM employee WHERE emp_name LIKE '%국';
SELECT * FROM employee WHERE emp_name LIKE '김__';
SELECT * FROM employee WHERE email LIKE '____@%';
SELECT * FROM employee WHERE email LIKE 'a%';
SELECT * FROM employee WHERE email NOT LIKE 'a%';
SELECT * FROM employee WHERE email SIMILAR to '_(am|ah)%';
SELECT * FROM employee WHERE email SIMILAR to '[amohs]%';
SELECT * FROM employee WHERE email SIMILAR to '[a-c]%';

SELECT * FROM employee WHERE salary > 5000 AND hire_date <= '2020-12-31';
SELECT * FROM employee
WHERE dept_id = 'SYS' OR dept_id = 'MKT' OR dept_id = 'GEN';

SELECT * FROM employee WHERE phone NOT LIKE '010%';

SELECT * FROM employee WHERE salary >= 5000 AND salary <= 8000;
SELECT * FROM employee WHERE salary BETWEEN 5000 and 8000;
SELECT * FROM employee WHERE salary NOT BETWEEN 5000 and 8000;

SELECT * FROM employee where (dept_id = 'SYS' OR dept_id = 'MKT' OR dept_id = 'GEN');
SELECT * FROM employee where dept_id in ('SYS', 'MKT', 'GEN');
SELECT * FROM employee where dept_id NOT in ('SYS', 'MKT', 'GEN');



