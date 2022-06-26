
-- 01. 직원정보 테이블 구조(스키마) 조회

desc emp;

-- 02. 부서 테이블 구조(스키마 조회)

desc dept;

-- 03. 전체직원의 모든정보 조회

select * from emp;

-- 04. 전체부서의 모든정보 조회

select * from dept;

-- 05. 전체직원의 사번, 이름, 급여, 상여, 입사일 정보를 조회

select empno, ename, sal, comm, hiredate
from emp;

-- 06. 컬럼에 대한 별명 사용해서 조회
-- 출력제목 : Employee No, Name, Salary, COMMISION, Hire Date

select empno as "Employee No", ename as NAME, sal as Salary, comm as COMMISION, hiredate as "Hire Date"
from emp;

-- 07. 정렬 조회
-- 출력제목 : 부서번호, 사번, 이름, 급여, 수당
-- 정렬기준 : 급여(높은순서), 부서번호(낮은순서)
-- 정렬기준 : 부서번호(낮은순서), 급여(높은순서)

select deptno as 부서번호, empno as 사번, ename as 이름, sal as 급여, comm as 수당
from emp
order by sal desc, deptno asc;

select deptno as 부서번호, empno as 사번, ename as 이름, sal as 급여, comm as 수당
from emp
order by deptno asc, sal desc;

-- 08. 중복행 제거 조회 : distinct
-- 직원의 직무 종류 조회
-- 정렬기준 : 직무 올림차순

select distinct job
from emp
order by job asc;

-- 09. 각부서의 해당 부서원의 직무 종류 조회
-- 출력정보 : 부서번호, 직무
-- 정렬기준 : 부서번호 올림, 직무 올림

select distinct deptno, job
from emp
order by deptno asc, job asc;

-- 10. 조건 조회
-- 출력정보 : 사번, 이름, 급여
-- 조회조건 : 급여가 3000이상인 직원

select empno, ename, sal
from emp
where sal >= 3000;

-- 11. 사원번호가 7788 사원의 이름 및 부서번호를 출력

select ename, deptno
from emp
where empno = 7788;

-- 12. 10번 부서원중에서 급여가 3000이상인 직원

select * from emp
where deptno = 10 and sal >= 3000;

-- 13. 출력정보 : 부서번호, 사번, 이름, 직무
-- 조회조건 : 직무가 manager 인 직원

select deptno, empno, ename, job
from emp
where job = 'MANAGER';

-- 14. 출력정보 : 부서번호, 사번, 이름, 직무
-- 조회조건 : 직무가 SALESMAN이 아닌 직원

select deptno, empno, ename, job
from emp
where job != 'SALESMAN';

-- 15. 급여가 1500이상 ~ 2850이하의 범위에 속하는 사원의 이름 및 급여를 조회

select ename, sal
from emp
where sal >= 1500 and sal <= 2850;

-- 16. 급여가 1500이상 ~ 2850이하의 범위에 속하지 않는 사원의 이름 및 급여를 조회

select ename, sal
from emp
where sal < 1500 or sal > 2850

-- 17. 출력정보 : 부서번호, 사번, 이름, 급여
-- 조회조건 : 급여가 3000이상이거나, 부서번호 10인 직원

select deptno, empno, ename, sal
from emp
where sal >= 3000 or deptno = 10;

-- 18. 출력정보 : 부서번호, 사번, 이름, 직무
-- 조회조건 : 부서번호가 10, 20 부서원 조회

select deptno, empno, ename, job
from emp
where deptno = 10 or deptno = 20;

-- 19. 10번 및 30번 부서에 속하는 모든 사원의 이름과 부서 번호를 조회하라.
-- 단, 이름을 알파벳순으로 정렬하여 출력하라. 
 
select ename, deptno
from emp
where deptno = 10 or deptno = 30
order by ename asc;

-- 1) 컬럼명 정렬 조회

select ename, deptno
from emp
where deptno in (10, 30)
order by ename asc;

-- 2) alias(별명) 정렬 조회

select ename, deptno, 
case when deptno = 10 then '부서번호 10'
when deptno = 30 then '부서번호 30'
else '그 외 부서번호'
end as deptno_alias
from emp
where deptno = 10 or deptno = 30
order by ename asc;

-- 3) 조회 컬럼명에 대한 인덱스번호로  정렬 조회

select ename, deptno, 
case when deptno = 10 then '부서번호 10'
when deptno = 30 then '부서번호 30'
else '그 외 부서번호'
end as deptno_alias
from emp
where deptno = 10 or deptno = 30
order by 1 asc;


-- ## SQL 비교연산자 조건 검색

-- 20. 사원 이름이 A로 시작 하는 직원 검색

select * from emp
where ename like 'A%';

-- 21. 사원 이름에 A가 들어가는 직원 검색

select * from emp
where ename like '%A%';

-- 22. 사원이름의 3번째 문자가 A인 직원 검색

select * from emp
where ename like '__A%';

-- 23. 이름 5글자인 직원의 정보를 조회

select * from emp
where ename like '_____';

-- 24. 부서가 10번, 20번 직원 검색

select * from emp
where deptno = 10 or deptno = 20;

-- 25. 부서가 10번, 20번이 아닌 직원 검색

select * from emp
where deptno !=10 and deptno != 20;

-- 26. 급여가 1500이상 ~ 2850이하의 범위에 속하는 사원의 이름 및 급여를 조회

select ename, sal
from emp
where sal >= 1500 and sal <= 2850;

-- 27. 급여가 1500이상 ~ 2850이하의 범위에 속하지 않는 사원의 이름 및 급여를 조회

select ename, sal
from emp
where sal < 1500 or sal < 2850;

-- 28. 수당이 없는 직원 검색

select * from emp
where comm is null;

-- 29. 수당이 있는 직원 검색

select * from emp
where comm is not null;

-- 30. 직원 특별상여 = 급여 + 수당 * 20%
-- 수당이 있는 직원은 급여 + 수당 * 0.2 특별 상여
-- 수당이 없는 직원은 급여 * 0.2 특별 상여 
-- 이름 , 급여, 수당, 특별상여 정보 출력

-- 1) 수당이 있는 직원 정보 : 0원 이상인 사람

select ename, sal, comm, (sal+comm)*0.2 as "특별 상여" 
from emp
where comm is not null;

-- 2) 수당이 없는 직원 정보

select ename, sal, comm, sal*0.2 as "특별 상여" 
from emp
where comm is null;

-- 3) 모든 사원에게 특별상여 지급

select ename, sal, comm, nvl2(comm, sal+comm*0.2, sal*0.2) as "특별 상여"
from emp;

-- 31. 사번이 000인 직원의 이름은 000이다

select '사번이' || empno || '인 직원의 이름은' || ename || '이다' from emp;

-- 32. 근무기간에 따른 사원들에 대한 교육을 진행하기로 하였다.
-- 직원들의 사번, 이름, 입사일, 근무기간(년수, 년이하버림)의 정보를 
-- 근무기간이 작은 순서데로 조회하여라.
-- 근무기간 = 현재날짜 - 입사날짜
-- 근무년수가 33년 이상인 직원의 명단을 출력
 
select empno, ename, hiredate, trunc(months_between(sysdate, hiredate)/12) as "근무기간"
from emp
where trunc(months_between(sysdate, hiredate)/12) >=33
order by trunc(months_between(sysdate, hiredate)/12) asc;

-- 현재날짜 = sysdate
-- 현재 날짜 조회
select sysdate
from dual;

SYSDATE
--------
14/09/05
14/09/05

