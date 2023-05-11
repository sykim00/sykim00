-- ★ ★ ★ ★ book.xml ★ ★ ★ ★
-- id = mainList (신간도서순 bookList)
-- public List<Book> mainList(); 
SELECT * FROM BOOK  ORDER BY BRDATE DESC;
-- id = bookList(startRow ~ endRow까지 bookList) 출력순서 : bTITLE 기준
-- public List<Book> bookList(Book book);
SELECT * 
    FROM (SELECT ROWNUM RN, A.* 
        FROM (SELECT * FROM BOOK ORDER BY bTITLE)A)
    WHERE RN BETWEEN 1 AND 6; 
-- id = totCntBook(등록된 책 갯수)
-- public int totCntBook();
SELECT COUNT(*) CNT FROM BOOK;
-- id = getDetailBook(책번호로 dto 가져오기)
-- public Book getDetailBook(int bnum);
SELECT * FROM BOOK WHERE bNUM = 1;
-- id = registerBook(책 등록)
-- public int registerBook(Book book);
INSERT INTO BOOK (bNUM, bTITLE, bWRITER, bRDATE, bIMG2, bINFO)
    VALUES (BOOK_SQ.NEXTVAL, '재롱잔치','재롱이',SYSDATE, 'noImg.png','재롱잔치');
INSERT INTO BOOK VALUES (BOOK_SQ.NEXTVAL, 'HTML','황작가',SYSDATE, 'noImg.png','noImg.png','HTML개념서');
INSERT INTO BOOK (bNUM, bTITLE, bWRITER, bRDATE, bIMG1, bINFO)
    VALUES (BOOK_SQ.NEXTVAL, 'JAVASCRIPT','강작가',SYSDATE, 'noImg.png','JS 개념서');
INSERT INTO BOOK (bNUM, bTITLE, bWRITER, bRDATE, bIMG2, bINFO)
    VALUES (BOOK_SQ.NEXTVAL, '글 작성하는 방법','개작가',SYSDATE, 'noImg.png','글 작성하는 방법을 알려드릴게요.');
INSERT INTO BOOK (bNUM, bTITLE, bWRITER, bRDATE, bINFO)
    VALUES (BOOK_SQ.NEXTVAL, '글 작성하는 방법','개작가',SYSDATE,'글 작성하는 방법을 알려드릴게요.');
-- id = modifyBook(책 수정)
-- public int modifyBook(Book book);
UPDATE BOOK SET
        bTITLE = '재롱이잔치',
        bWRITER = '재롱맘',
        bRDATE = '23/04/13',
        bIMG1 = 'dog.png',
        bIMG2 = 'dog.png',
        bINFO = '재롱재롱'
    WHERE bNUM = 2;

-- ★ ★ ★ ★ member.xml ★ ★ ★ ★
-- id = idConfirm(mid가 id인 데이터 갯수)
-- public int idConfirm(String mid);
SELECT COUNT(*) FROM MEMBER WHERE MID = 'aaa';
-- id = joinMember(회원가입)
-- public int joinMember(Member member);
INSERT INTO MEMBER VALUES ('aaa','1','홍길동','hong@naver.com','12345','서울');
-- id = getDetailMember(mid로 MemberDto dto가져오기)
-- public Member getDetailMember(String mid);
SELECT * FROM MEMBER WHERE mID = 'aaa';
-- id = modifyMember(정보수정)
-- public int modifyMember(Member member);	
UPDATE MEMBER SET 
        mPW = '2',
        mNAME = '이길동',
        mMAIL = 'lee@naver.com',
        mPOST = '678925',
        mADDR = '경기도'
    WHERE mID = 'aaa';
SELECT * FROM MEMBER;
COMMIT;
	