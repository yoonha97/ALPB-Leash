SELECT * FROM employee WHERE retire_date IS NOT NULL;
SELECT * FROM employee WHERE retire_date IS NULL;

SELECT emp_name, COALESCE(eng_name,'') as eng_name FROM employee;

SELECT CONCAT(emp_name, ' (', eng_name, ')') AS name FROM employee;
SELECT CONCAT(emp_name, ' (', emp_id, ')') AS name FROM employee;

-- 오름차순 : ASC, 내림차순 : DESC
-- 정렬에 직접적으로 영향을 주는 null 처리는 order by 이후에 넣어야 인식됨. 그 앞에 쓰는건 표현만 바꿈.
SELECT CONCAT(emp_name, ' (', emp_id, ')') AS name, COALESCE(salary, 0) FROM employee
ORDER BY COALESCE(salary, 0) ASC;

-- offset은 제외시킬 인원. LIMIT 5 OFFSET 5면 상위 5명 제외하고 그 다음 5명.
SELECT CONCAT(emp_name, ' (', emp_id, ')') AS name, salary FROM employee
WHERE retire_date IS NULL
ORDER BY salary DESC
LIMIT 5 OFFSET 5;

SELECT CONCAT(emp_name, ' (', emp_id, ')') AS name,
	CASE WHEN gender = 'M' THEN '남자'
		WHEN gender = 'F' THEN '여자'
		ELSE '그외'
	END AS gender
FROM employee;

-- 중복 제거
SELECT dept_id FROM employee WHERE retire_date IS NULL;
SELECT DISTINCT dept_id FROM employee WHERE retire_date IS NULL;

SELECT SUM(salary) AS total_salary
FROM employee
WHERE retire_date IS NULL;

SELECT COUNT(*) AS emp_count
FROM employee
WHERE retire_date IS NULL;

SELECT MAX(salary) AS max_salary,
		MIN(salary) AS min_salary,
		MAX(salary) - MIN(salary) AS diff_salary
FROM employee
WHERE retire_date IS NULL;

SELECT AVG(salary) AS average_salary
FROM employee
WHERE retire_date IS NULL;

SELECT dept_id, COUNT(*) AS emp_count
FROM employee
WHERE retire_date IS NULL
GROUP BY dept_id
HAVING COUNT(*) >= 3
ORDER BY emp_count DESC;

-- 휴가 시작일 기준 내림차순 정렬하여 직원 휴가 현황 조회
SELECT * FROM vacation
ORDER BY begin_date desc;

-- 동호회 탈퇴일 대신에 활동/탈퇴로 구분해 동호회 가입 정보 조회
SELECT emp_id, club_id, CASE
	WHEN cancel_date IS NULL THEN '활동'
	ELSE '탈퇴'
	END AS cancel_date FROM club_join;

-- 동호회별 현재 활동 중인 직원 수 조회
SELECT club_id, COUNT(*) AS cnt
FROM club_join
WHERE cancel_date IS NULL
GROUP BY club_id;

SELECT dept_id, string_agg(emp_name, ','), sum(salary)
FROM employee
GROUP BY dept_id;

SELECT * FROM department;

INSERT INTO department (dept_id, dept_name, unit_id, start_date)
	VALUES ('PRD', '상품', 'A', '2022-10-01');

INSERT INTO department
	VALUES ('PRD', '상품', 'A', '2022-10-01'),
			('DBA', 'DB 관리', 'A', '2022-10-01');

DROP TABLE IF EXISTS retired_employee;

CREATE TABLE retired_employee (
	emp_id char(5) NOT NULL,
	emp_name varchar(8) NOT NULL,
	gender char(1) NOT NULL,
	hire_date date NOT NULL,
	retired_date date NOT NULL,
	phone char(13) NOT NULL,
	email varchar(50) NOT NULL
);

SELECT * FROM retired_employee;

INSERT INTO retired_employee
	SELECT emp_id, emp_name, gender, hire_date, retire_date, phone, email
		FROM employee
		WHERE retire_date IS NOT NULL;

SELECT * FROM employee WHERE emp_id='S0001';

UPDATE employee
	SET phone = '010-1234-5678'
	WHERE emp_id='S0001';

SELECT * FROM vacation 	WHERE end_date <= '2017-12-31';

DELETE FROM vacation
	WHERE end_date <= '2017-12-31';

SELECT current_date AS TEST;

SELECT emp_name, emp_id, gender, dept_id, hire_date, salary,
	RANK() OVER(ORDER BY salary DESC) as rank
FROM employee
WHERE retire_date IS NULL AND salary IS NOT NULL;

SELECT emp_name, emp_id, gender, dept_id, hire_date, salary,
	DENSE_RANK() OVER(PARTITION BY gender ORDER BY salary DESC) as rank
FROM employee
WHERE retire_date IS NULL AND salary IS NOT NULL;

SELECT emp_id, emp_name, dept_id, phone, email
FROM employee
WHERE retire_date IS NULL;

-- 부서 이름 출력
SELECT e.emp_id, e.emp_name,
	e.dept_id, d.dept_name,
	e.phone, e.email
FROM employee as e
INNER JOIN department as d
ON e.dept_id = d.dept_id
WHERE retire_date IS NULL;

SELECT e.emp_id, e.emp_name,
	e.dept_id, d.dept_name, u.unit_name,
	e.phone, e.email
FROM employee as e
INNER JOIN department as d
ON e.dept_id = d.dept_id
INNER JOIN unit as u
ON d.unit_id = u.unit_id
WHERE retire_date IS NULL;

SELECT e.emp_id, e.emp_name, v.begin_date, v.end_date, v.duration
FROM employee as e
INNER JOIN vacation as v
ON e.emp_id = v.emp_id
ORDER BY e.emp_id ASC;

-- 휴가 안간 사람도 우선 다 출력
SELECT e.emp_id, e.emp_name, v.begin_date, v.end_date, v.duration
FROM employee as e
LEFT JOIN vacation as v
ON e.emp_id = v.emp_id
ORDER BY e.emp_id ASC;

-- 휴가 일수를 직원별로 출력
SELECT e.emp_id, e.emp_name, SUM(v.duration) AS total_duration
FROM employee AS e
INNER JOIN vacation AS v
ON e.emp_id = v.emp_id
GROUP BY e.emp_id, e.emp_name
ORDER BY SUM(v.duration) ASC;

SELECT u.unit_id, u.unit_name, d.dept_id, d.dept_name
FROM unit AS u
RIGHT OUTER JOIN department AS d
on u.unit_id = d.unit_id;

SELECT v.emp_id, d.dept_name, v.begin_date, v.duration
FROM vacation AS v
INNER JOIN employee AS e
ON v.emp_id = e.emp_id
INNER JOIN department AS d
ON e.dept_id = d.dept_id
WHERE e.retire_date IS NULL
ORDER BY v.emp_id ASC, v.begin_date DESC;
