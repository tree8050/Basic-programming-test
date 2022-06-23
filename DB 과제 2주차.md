
1. erwin 생성

![image](https://user-images.githubusercontent.com/87375644/175297253-240028fd-f877-44cb-9223-d07f12a060c8.png)







2. 스키마 생성

CREATE TABLE A1
(
    a1                   CHAR(18) NOT NULL ,
    name                 CHAR(18) NULL 
);

CREATE UNIQUE INDEX XPKA1 ON A1
(a1   ASC);

CREATE TABLE A2
(
    a2                   CHAR(18) NOT NULL ,
    name                 CHAR(18) NULL 
);

CREATE UNIQUE INDEX XPKA2 ON A2
(a2   ASC);

CREATE TABLE A3
(
    a3                   CHAR(18) NOT NULL ,
    name                 CHAR(18) NULL 
);

CREATE UNIQUE INDEX XPKA3 ON A3
(a3   ASC);

CREATE TABLE B1
(
    b1                   CHAR(18) NOT NULL ,
    a1                   CHAR(18) NOT NULL ,
    name                 CHAR(18) NULL 
);

CREATE UNIQUE INDEX XPKB1 ON B1
(b1   ASC,a1   ASC);

CREATE TABLE B2
(
    b2                   CHAR(18) NOT NULL ,
    a2                   CHAR(18) NULL ,
    name                 CHAR(18) NULL 
);

CREATE UNIQUE INDEX XPKB2 ON B2
(b2   ASC);

CREATE TABLE B3
(
    b3                   CHAR(18) NOT NULL ,
    name                 CHAR(18) NULL 
);

CREATE UNIQUE INDEX XPKB3 ON B3
(b3   ASC);

CREATE TABLE C1
(
    c1                   CHAR(18) NOT NULL ,
    b1                   CHAR(18) NOT NULL ,
    a1                   CHAR(18) NOT NULL ,
    name                 CHAR(18) NULL 
);

CREATE UNIQUE INDEX XPKC1 ON C1
(c1   ASC,b1   ASC,a1   ASC);

CREATE TABLE C2
(
    c2                   CHAR(18) NOT NULL ,
    b2                   CHAR(18) NULL ,
    name                 CHAR(18) NULL 
);

CREATE UNIQUE INDEX XPKC2 ON C2
(c2   ASC);

CREATE TABLE C3
(
    c3                   CHAR(18) NOT NULL ,
    name                 CHAR(18) NULL 
);

CREATE UNIQUE INDEX XPKC3 ON C3
(c3   ASC);

-- 식별자 --

select *
from A1, B1, C1 
where A1.a1 = C1.a1 and B1.b1=C1.B1;

--------------------------------

-- 비식별자 --

select *
from A2, B2, C2 
where A2.a2=B2.a2;

--------------------------------

-- 관계X --

select *
from A3, B3, C3 ;

--------------------------------




3. 식별자 조회

![image](https://user-images.githubusercontent.com/87375644/175297513-a8711827-21df-4e83-8353-fe208ab26f15.png)

4. 비식별자 조회

![image](https://user-images.githubusercontent.com/87375644/175297544-3bcc3ea9-3172-4d42-b673-a74801c77fa3.png)

5. 관계 X 조회

![image](https://user-images.githubusercontent.com/87375644/175297580-a30356c1-da8e-4040-b5ee-2dcb03c667b8.png)
