-- 실습

-- 1. 남자 직원의 사번, 이름, 입사일 조회
SELECT emp_id, emp_name, hire_date
FROM employee
WHERE gender = 'M';

-- 2. 동호회 코드(club_id)가 'C01'인 동호회 이름, 시작일, 회비 조회
SELECT club_name, start_date, fee
FROM club
WHERE club_id = 'C01';

-- 3. 강우동(S0003) 직원의 1회 ~ 3회 토익 점수 조회
SELECT emp_id, score01, score02, score03
FROM toeic
WHERE emp_id = 'S0003';

-- 4. 2020년 6월 이전 입사자의 이름, 사번, 부서코드, 성별, 결혼여부, 입사일, 이메일 조회
SELECT emp_name, emp_id, dept_id, gender, marital_yn, hire_date, email
FROM employee
WHERE hire_date < '2020-06-01';

-- 5. 휴가 기간이 5일 이상인 사번, 휴가 시작일, 휴가 사유, 휴가 기간 조회
SELECT emp_id, begin_date, reason, duration
FROM vacation
WHERE duration >= 5;

-- 6. 동호회 회비가 20,000원 이상인 동호회 코드, 동호회 이름, 회비 조회
SELECT club_id, club_name, fee
FROM club
WHERE fee >= 20000;

-- 7. 첫 번째 토익 점수가 850 이상인 사번, 1회 ~ 3회 토익 점수 조회
SELECT emp_id, score01, score02, score03
FROM toeic
WHERE score01 >= 850;

-- 8. 전화번호가 010으로 시작하지 않는 직원 정보 조회
SELECT *
FROM employee
WHERE phone NOT LIKE '010%';

-- 9. 2022년부터 입사한 SYS 부서 직원 정보 조회
SELECT *
FROM employee
WHERE hire_date >= '2022-01-01' AND dept_id = 'SYS';

-- 10. SYS 부서 직원 중에서 급여를 6,000 이상 받는 직원 정보 조회
SELECT *
FROM employee
WHERE dept_id = 'SYS' AND salary >= 6000;

-- 11. SYS 부서 직원 중에서 결혼한 직원 정보 조회
SELECT *
FROM employee
WHERE dept_id = 'SYS' AND marital_yn = 'Y';

-- 12. 첫 번째 토익 점수가 800 이상, 900 미만인 직원의 1회 ~ 5회 토익 점수 조회
SELECT emp_id, score01, score02, score03, score04, score05
FROM toeic
WHERE score01 BETWEEN 800 AND 899;

-- 13. 2019년도에 입사한 정보시스템, 영업팀 직원 정보 조회
SELECT *
FROM employee
WHERE hire_date BETWEEN '2019-01-01' AND '2019-12-31'
AND dept_id IN ('SYS', 'MKT');

-- 14. 2019년 ~ 2020년에 입사한 연봉이 6,000 ~ 7,000인 근무 중인 직원 정보 조회
SELECT *
FROM employee
WHERE hire_date BETWEEN '2019-01-01' AND '2020-12-31'
AND salary BETWEEN 6000 AND 7000
AND retire_date IS NULL;

-- 15. 홍길동(S0001), 일지매(S0002), 강우동(S0003)이 2017년 ~ 2018년에 동호회에 가입한 정보 조회
SELECT emp_id, club_id, join_date
FROM club_join
WHERE emp_id IN ('S0001', 'S0002', 'S0003')
AND join_date BETWEEN '2017-01-01' AND '2018-12-31';
