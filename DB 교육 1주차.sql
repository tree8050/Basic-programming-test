
-- 01. �������� ���̺� ����(��Ű��) ��ȸ

desc emp;

-- 02. �μ� ���̺� ����(��Ű�� ��ȸ)

desc dept;

-- 03. ��ü������ ������� ��ȸ

select * from emp;

-- 04. ��ü�μ��� ������� ��ȸ

select * from dept;

-- 05. ��ü������ ���, �̸�, �޿�, ��, �Ի��� ������ ��ȸ

select empno, ename, sal, comm, hiredate
from emp;

-- 06. �÷��� ���� ���� ����ؼ� ��ȸ
-- ������� : Employee No, Name, Salary, COMMISION, Hire Date

select empno as "Employee No", ename as NAME, sal as Salary, comm as COMMISION, hiredate as "Hire Date"
from emp;

-- 07. ���� ��ȸ
-- ������� : �μ���ȣ, ���, �̸�, �޿�, ����
-- ���ı��� : �޿�(��������), �μ���ȣ(��������)
-- ���ı��� : �μ���ȣ(��������), �޿�(��������)

select deptno as �μ���ȣ, empno as ���, ename as �̸�, sal as �޿�, comm as ����
from emp
order by sal desc, deptno asc;

select deptno as �μ���ȣ, empno as ���, ename as �̸�, sal as �޿�, comm as ����
from emp
order by deptno asc, sal desc;

-- 08. �ߺ��� ���� ��ȸ : distinct
-- ������ ���� ���� ��ȸ
-- ���ı��� : ���� �ø�����

select distinct job
from emp
order by job asc;

-- 09. ���μ��� �ش� �μ����� ���� ���� ��ȸ
-- ������� : �μ���ȣ, ����
-- ���ı��� : �μ���ȣ �ø�, ���� �ø�

select distinct deptno, job
from emp
order by deptno asc, job asc;

-- 10. ���� ��ȸ
-- ������� : ���, �̸�, �޿�
-- ��ȸ���� : �޿��� 3000�̻��� ����

select empno, ename, sal
from emp
where sal >= 3000;

-- 11. �����ȣ�� 7788 ����� �̸� �� �μ���ȣ�� ���

select ename, deptno
from emp
where empno = 7788;

-- 12. 10�� �μ����߿��� �޿��� 3000�̻��� ����

select * from emp
where deptno = 10 and sal >= 3000;

-- 13. ������� : �μ���ȣ, ���, �̸�, ����
-- ��ȸ���� : ������ manager �� ����

select deptno, empno, ename, job
from emp
where job = 'MANAGER';

-- 14. ������� : �μ���ȣ, ���, �̸�, ����
-- ��ȸ���� : ������ SALESMAN�� �ƴ� ����

select deptno, empno, ename, job
from emp
where job != 'SALESMAN';

-- 15. �޿��� 1500�̻� ~ 2850������ ������ ���ϴ� ����� �̸� �� �޿��� ��ȸ

select ename, sal
from emp
where sal >= 1500 and sal <= 2850;

-- 16. �޿��� 1500�̻� ~ 2850������ ������ ������ �ʴ� ����� �̸� �� �޿��� ��ȸ

select ename, sal
from emp
where sal < 1500 or sal > 2850

-- 17. ������� : �μ���ȣ, ���, �̸�, �޿�
-- ��ȸ���� : �޿��� 3000�̻��̰ų�, �μ���ȣ 10�� ����

select deptno, empno, ename, sal
from emp
where sal >= 3000 or deptno = 10;

-- 18. ������� : �μ���ȣ, ���, �̸�, ����
-- ��ȸ���� : �μ���ȣ�� 10, 20 �μ��� ��ȸ

select deptno, empno, ename, job
from emp
where deptno = 10 or deptno = 20;

-- 19. 10�� �� 30�� �μ��� ���ϴ� ��� ����� �̸��� �μ� ��ȣ�� ��ȸ�϶�.
-- ��, �̸��� ���ĺ������� �����Ͽ� ����϶�. 
 
select ename, deptno
from emp
where deptno = 10 or deptno = 30
order by ename asc;

-- 1) �÷��� ���� ��ȸ

select ename, deptno
from emp
where deptno in (10, 30)
order by ename asc;

-- 2) alias(����) ���� ��ȸ

select ename, deptno, 
case when deptno = 10 then '�μ���ȣ 10'
when deptno = 30 then '�μ���ȣ 30'
else '�� �� �μ���ȣ'
end as deptno_alias
from emp
where deptno = 10 or deptno = 30
order by ename asc;

-- 3) ��ȸ �÷��� ���� �ε�����ȣ��  ���� ��ȸ

select ename, deptno, 
case when deptno = 10 then '�μ���ȣ 10'
when deptno = 30 then '�μ���ȣ 30'
else '�� �� �μ���ȣ'
end as deptno_alias
from emp
where deptno = 10 or deptno = 30
order by 1 asc;


-- ## SQL �񱳿����� ���� �˻�

-- 20. ��� �̸��� A�� ���� �ϴ� ���� �˻�

select * from emp
where ename like 'A%';

-- 21. ��� �̸��� A�� ���� ���� �˻�

select * from emp
where ename like '%A%';

-- 22. ����̸��� 3��° ���ڰ� A�� ���� �˻�

select * from emp
where ename like '__A%';

-- 23. �̸� 5������ ������ ������ ��ȸ

select * from emp
where ename like '_____';

-- 24. �μ��� 10��, 20�� ���� �˻�

select * from emp
where deptno = 10 or deptno = 20;

-- 25. �μ��� 10��, 20���� �ƴ� ���� �˻�

select * from emp
where deptno !=10 and deptno != 20;

-- 26. �޿��� 1500�̻� ~ 2850������ ������ ���ϴ� ����� �̸� �� �޿��� ��ȸ

select ename, sal
from emp
where sal >= 1500 and sal <= 2850;

-- 27. �޿��� 1500�̻� ~ 2850������ ������ ������ �ʴ� ����� �̸� �� �޿��� ��ȸ

select ename, sal
from emp
where sal < 1500 or sal < 2850;

-- 28. ������ ���� ���� �˻�

select * from emp
where comm is null;

-- 29. ������ �ִ� ���� �˻�

select * from emp
where comm is not null;

-- 30. ���� Ư���� = �޿� + ���� * 20%
-- ������ �ִ� ������ �޿� + ���� * 0.2 Ư�� ��
-- ������ ���� ������ �޿� * 0.2 Ư�� �� 
-- �̸� , �޿�, ����, Ư���� ���� ���

-- 1) ������ �ִ� ���� ���� : 0�� �̻��� ���

select ename, sal, comm
from emp
where comm is not null;

-- 2) ������ ���� ���� ����

select ename, sal, comm from emp
where comm is null;

-- 3) ��� ������� Ư���� ����

select ename, sal, comm, nvl2(comm, sal+comm*0.2, sal*0.2) as "Ư�� ��"
from emp;

-- 31. ����� 000�� ������ �̸��� 000�̴�

select concat(concat(concat('�����', empno), concat('�� ������ �̸���', ename)), '�̴�') from emp;

-- 32. �ٹ��Ⱓ�� ���� ����鿡 ���� ������ �����ϱ�� �Ͽ���.
-- �������� ���, �̸�, �Ի���, �ٹ��Ⱓ(���, �����Ϲ���)�� ������ 
-- �ٹ��Ⱓ�� ���� �������� ��ȸ�Ͽ���.
-- �ٹ��Ⱓ = ���糯¥ - �Ի糯¥
-- �ٹ������ 33�� �̻��� ������ ����� ���

select empno, ename, trunc(months_between(sysdate, hiredate)/12) as "�ٹ��Ⱓ"
from emp
where trunc(months_between(sysdate, hiredate)/12) >=33
order by trunc(months_between(sysdate, hiredate)/12) asc;

-- ���糯¥ = sysdate
-- ���� ��¥ ��ȸ
select sysdate
from dual;

SYSDATE
--------
14/09/05
14/09/05

