-- 실습

-- 홍길동의 2019년 ~2020년 휴가 일수 합계 조회
SELECT e.emp_id, e.emp_name, SUM(v.duration) AS total_vacation
FROM vacation v
INNER JOIN employee e
ON v.emp_id = e.emp_id
WHERE e.emp_name = '홍길동'
AND v.begin_date BETWEEN '2019-01-01' AND '2020-12-31'
GROUP BY e.emp_id, e.emp_name;

-- 급여 크기를 상/중/하로 구분해 근무 중인 직원 조회
SELECT emp_id, emp_name, salary,
	CASE
		WHEN salary >= 7000 THEN '상'
		WHEN salary >= 5000 THEN '중'
		WHEN salary IS NULL THEN 'null'
		ELSE '하'
	END AS salary_level
FROM employee
WHERE retire_date IS NULL
ORDER BY salary DESC;

-- 1회차 토익 최고, 최저, 평균 점수 조회
SELECT
	MAX(score01) AS max_score, 
	MIN(score01) AS min_score, 
	AVG(score01) AS avg_score
FROM toeic;

-- 최종 토익 점수 평균 조회
SELECT AVG(
	COALESCE(score10, score09, score08, score07, score06, 
			score05, score04, score03, score02, score01, 0)
) AS final_score_avg
FROM toeic;

-- 결혼 여부별 근무 중인 직원의 급여 합, 급여 평균 조회
-- 단, 급여가 NULL이면 3,500 으로 대체
SELECT 
	marital_yn AS 결혼여부,
	SUM(COALESCE(salary, 3500)) AS total_salary,
	AVG(COALESCE(salary, 3500)) AS avg_salary
FROM employee
WHERE retire_date IS NULL
GROUP BY marital_yn;

-- 2020년 휴가일수 합이 5가 넘는 직원의 사번과 휴가일수 합 조회
SELECT v.emp_id, e.emp_name, SUM(v.duration) AS total_vacation
FROM vacation v
JOIN employee e
ON v.emp_id = e.emp_id
WHERE v.begin_date BETWEEN '2020-01-01' AND '2020-12-31'
GROUP BY v.emp_id, e.emp_name
HAVING SUM(v.duration) > 5
ORDER BY total_vacation DESC;

-- 직원 이름 다음에 본부 이름을 표시하도록 다음 쿼리문 수정

-- SELECT e.emp_id, e.emp_name, v.begin_date, v.end_date, v.reason, v.duration
-- 	FROM employee AS e
-- 	INNER JOIN vacation AS v ON e.emp_id = v.emp_id
-- 	WHERE e.hire_date BETWEEN '2020-01-01' AND '2020-12-31'
-- 		AND retire_date IS NULL
-- 	ORDER BY e.emp_id ASC;

SELECT 
    e.emp_id, 
    CONCAT(e.emp_name, ' (', u.unit_name, ')') AS emp_with_unit,
    v.begin_date, v.end_date, v.reason, v.duration
FROM employee AS e
INNER JOIN vacation AS v ON e.emp_id = v.emp_id
LEFT JOIN department AS d ON e.dept_id = d.dept_id
LEFT JOIN unit AS u ON d.unit_id = u.unit_id
WHERE e.hire_date BETWEEN '2020-01-01' AND '2020-12-31'
AND e.retire_date IS NULL
ORDER BY e.emp_id ASC;
