-- SEQUENCE & TABLE DROP/CREATE
DROP TABLE MEMBER CASCADE CONSTRAINTS;
DROP TABLE BOOK CASCADE CONSTRAINTS;
DROP SEQUENCE BOOK_SQ;
CREATE TABLE MEMBER(
    mID VARCHAR2(100) PRIMARY KEY,
    mPW VARCHAR2(100) NOT NULL,
    mNAME VARCHAR2(100) NOT NULL,
    mMAIL VARCHAR2(100) NOT NULL,
    mPOST VARCHAR2(100), -- 우편번호
    mADDR VARCHAR2(100) -- 주소
);

CREATE SEQUENCE BOOK_SQ MAXVALUE 99999999 NOCYCLE NOCACHE;
CREATE TABLE BOOK(
    bNUM NUMBER(8) PRIMARY KEY,                     -- 책번호
    bTITLE VARCHAR2(100) NOT NULL,                  -- 책이름
    bWRITER VARCHAR2(100) NOT NULL,                 -- 저자
    bRDATE  DATE DEFAULT SYSDATE NOT NULL,          -- 출판일
    bIMG1 VARCHAR2(1000) DEFAULT 'noImg.png' NOT NULL, -- 책이미지1
    bIMG2 VARCHAR2(1000) DEFAULT 'noImg.png' NOT NULL, -- 책이미지2
    bINFO VARCHAR2(4000)                            -- 책소개
);
-- DUMMY DATA INSERT
INSERT INTO MEMBER VALUES ('aaa','1','홍길동','hong@naver.com','12345','서울');
INSERT INTO BOOK VALUES (BOOK_SQ.NEXTVAL, 'SPRING','김작가',SYSDATE, 'noImg.png','noImg.png','스프링개념서');
INSERT INTO BOOK (bNUM, bTITLE, bWRITER, bRDATE, bIMG1, bINFO)
    VALUES (BOOK_SQ.NEXTVAL, 'JSP','박제이',SYSDATE, 'noImg.png','jsp 개념서');
INSERT INTO BOOK (bNUM, bTITLE, bWRITER, bRDATE, bIMG2, bINFO)
    VALUES (BOOK_SQ.NEXTVAL, 'ORACLE','홍작가',SYSDATE, 'noImg.png','스프링개념서');
INSERT INTO BOOK (bNUM, bTITLE, bWRITER, bRDATE, bINFO)
    VALUES (BOOK_SQ.NEXTVAL, 'JAVA','이자바',SYSDATE, '스프링개념서');
COMMIT;
SELECT * FROM MEMBER;
SELECT * FROM BOOK;