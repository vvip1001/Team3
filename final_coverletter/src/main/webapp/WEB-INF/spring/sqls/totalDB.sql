-- 유저 기본 정보
DROP SEQUENCE JOIN_SEQ;
DROP TABLE JOINUSER;

CREATE SEQUENCE JOIN_SEQ;

CREATE TABLE JOINUSER
(
    JOINSEQ      NUMBER           NOT NULL, 
    JOINEMAIL    VARCHAR2(200)    NOT NULL, 
    JOINNAME     VARCHAR2(200)    NOT NULL, 
    JOINPW       VARCHAR2(200)    NOT NULL, 
    JOINBIRTH    CHAR(8)          NOT NULL, 
    JOINSEX      CHAR(1)          NOT NULL, 
    PHOTO        VARCHAR2(500), 
    MILILTARY    VARCHAR2(100), 
    PHONE        CHAR(13), 
    ADDRESS      VARCHAR2(200), 
    KAKAO        VARCHAR2(200), 				-- 카카오API에 사용
    SINGUP       CHAR(1)          NOT NULL, 	-- 가입유무
    CONSTRAINT USER_PK PRIMARY KEY (JOINEMAIL)
);

SELECT * FROM JOINUSER;

INSERT INTO JOINUSER(JOINSEQ,JOINEMAIL,JOINNAME,JOINPW,JOINBIRTH,JOINSEX, SINGUP )
VALUES(JOIN_SEQ.NEXTVAL, 'abc@naver.com', 'name', 'abc', '19990101', 'F', 'Y');



--======================================================================================================
-- 학력사항
DROP SEQUENCE SCHOOL_SEQ;
DROP TABLE SCHOOL;

CREATE SEQUENCE SCHOOL_SEQ;

CREATE TABLE SCHOOL
(
    SCHOOLSEQ     NUMBER           NOT NULL, 
    JOINEMAIL     VARCHAR2(200)    NOT NULL, 
    CAREER        VARCHAR2(20)     NOT NULL,  -- 학력구분(학위)
    SCHOOLNAME    VARCHAR2(20)     NOT NULL,  -- 학교명
    ADMISSION     VARCHAR2(20)     NOT NULL,  -- 입학년월
    GRADUATE      VARCHAR2(20)     NOT NULL,  -- 졸업년월 (재학중, 중퇴)
    MAJOR         VARCHAR2(100), 			  -- 전공명
    GRADE         CHAR(4), 					  -- 학점
    CONSTRAINT SCHOOL_PK PRIMARY KEY (SCHOOLSEQ)
);

--======================================================================================================
-- 자신있는 언어, 자격증, 어학점수, 공모전
DROP TABLE SKILL;
DROP SEQUENCE SKILL_SEQ;

CREATE SEQUENCE SKILL_SEQ;

CREATE TABLE SKILL
(
    SKILLSEQ         NUMBER           NOT NULL, 
    JOINEMAIL        VARCHAR2(200)    NOT NULL, 
    CATEGORY         VARCHAR2(20), 				-- 구분 : 언어, 자격증, 어학점수, 공모전 >> CHKED로 할까요?
    ITSKILL          VARCHAR2(50), 				-- 프로그램관련 스킬
    ITSCORE          NUMBER, 					-- 스킬 점수 1 ~ 10 
    CERTIFICATE      VARCHAR2(50), 				-- 자격증명
    LANGUAGENAME     VARCHAR2(50), 				-- 어학시험명
    LANGUAGESCORE    NUMBER, 					-- 어학시험 점수
    CONTEST          VARCHAR2(50), 				-- 공모전
    PRIZE            VARCHAR2(20), 				-- 수상 
    ORGANIZATION     VARCHAR2(50), 				-- 발행기관
    REGDATE          VARCHAR2(12), 				-- 취득날짜, 참여날짜
    CONSTRAINT SKILL_PK PRIMARY KEY (SKILLSEQ)
);

--======================================================================================================
--파일 업로드 다운로드 댓글 게시판

DROP SEQUENCE BOARD_SEQ;
DROP TABLE BOARD;

CREATE SEQUENCE BOARD_SEQ START WITH 1 INCREMENT BY 1;
CREATE TABLE BOARD
(
    BOARDSEQ     NUMBER            NOT NULL, 	
    GROUPNO      NUMBER			   NOT NULL, 	-- 그룹 번호
    GROUPSEQ     NUMBER			   NOT NULL, 	-- 같은 그룹내의 순서
    TITLETAB     NUMBER			   		   , 	-- 탭 구분(첫글null, 댓글0, 대댓1)
    JOINEMAIL    VARCHAR2(200)     NOT NULL, 	-- 이메일(ID) 작성자
    TITLE        VARCHAR2(1000)    		   , 	-- 제목(댓글은 제목없음)
    CONTENT      VARCHAR2(4000)    NOT NULL, 	-- 내용
    FILEPATH     VARCHAR2(1000), 				-- 파일 경로
    REGDATE      DATE              NOT NULL, 
    CONSTRAINT BOARD_PK PRIMARY KEY (BOARDSEQ)
);

SELECT * FROM BOARD;

DELETE FROM BOARD WHERE JOINEMAIL = 'mintparc@gmail.com';

--======================================================================================================
-- 자기소개서 + 포트폴리오
DROP SEQUENCE COVERLETTER_SEQ;
DROP TABLE COVERLETTER;

CREATE SEQUENCE COVERLETTER_SEQ;

CREATE TABLE COVERLETTER
(
    COVERLETTERSEQ    NUMBER            NOT NULL, 	
    JOINEMAIL         VARCHAR2(200)     NOT NULL, 	-- 이메일
    CVCATEGORY		  VARCHAR2(30)		NOT NULL,	-- 카테고리
    QUESTION          VARCHAR2(1000)	NOT NULL, 	-- 항목(질문)
    TITLE             VARCHAR2(500)		NOT NULL, 	-- 제목
    SUBTITLE          VARCHAR2(500)		NOT NULL,   -- 소제목(내용의 핵심 키워드)
    CONTENT           VARCHAR2(3000)	NOT NULL,   -- 내용
    REGDATE           DATE				NOT NULL,   -- 작성일
    FILEPATH		  VARCHAR2(1000)	NOT NULL,
    CONSTRAINT COVERLETTER_PK PRIMARY KEY (COVERLETTERSEQ)
);

SELECT * FROM COVERLETTER;
INSERT INTO COVERLETTER VALUES 
(COVERLETTER_SEQ.NEXTVAL, 'cv@email.net', 'PF', '지원자의 성장과정...?', '파이널프로젝트 포트폴리오', '저는 우량아로 태어나..', '대통령은 헌법과 법률이 정하는 바에 의하여 국군을 통수한다. 공공필요에 의한 재산권의 수용·사용 또는 제한 및 그에 대한 보상은 법률로써 하되, 정당한 보상을 지급하여야 한다. 대통령후보자가 1인일 때에는 그 득표수가 선거권자 총수의 3분의 1 이상이 아니면 대통령으로 당선될 수 없다. 법관이 중대한 심신상의 장해로 직무를 수행할 수 없을 때에는 법률이 정하는 바에 의하여 퇴직하게 할 수 있다.', SYSDATE, 'aaa');

--=====================================================================================================================
-- 채용일정 캘린더
DROP SEQUENCE JABCALENDAR_SEQ;
DROP TABLE JABCALENDAR;


CREATE SEQUENCE JABCALENDAR_SEQ;

CREATE TABLE JABCALENDAR
(
    JABCALENDARSEQ    NUMBER           NOT NULL, 	
    JOINEMAIL         VARCHAR2(200)	   NOT NULL, 
    COMPANYNAME       VARCHAR2(20)     NOT NULL, 	-- 회사명
    ENDDATE           VARCHAR2(20)     NOT NULL, 	-- 마감일
    CONSTRAINT JABCALENDAR_PK PRIMARY KEY (JABCALENDARSEQ)
);




--=====================================================================================================================
-- 후원 내역 테이블
DROP SEQUENCE SUPPORTPAY_SEQ;
DROP TABLE SUPPORTPAY_SEQ;


CREATE SEQUENCE SUPPORTPAY_SEQ;


CREATE TABLE SUPPORTPAY
(
    SUPPORTPAYSEQ    NUMBER           NOT NULL, 
    JOINEMAIL        VARCHAR2(200)    NOT NULL, 	-- 보낸사람 이메일
    MONEY            VARCHAR2(100)    NOT NULL, 	-- 금액
    DEPOSITOR        VARCHAR2(100)    NOT NULL, 	-- 예금주 
    BANK             VARCHAR2(100)    NOT NULL,  	-- 은행
    BANKNUMBER       VARCHAR2(100)    NOT NULL, 	-- 계좌번호
    SUCCESSCORD      VARCHAR2(100)    NOT NULL, 	-- 거래성공 코드
    TRADEDATE        VARCHAR2(20)     NOT NULL, 	-- 거래 일시
    CONSTRAINT SUPPORTPAY_PK PRIMARY KEY (SUPPORTPAYSEQ)
);


--========================================================================================================================
-- a : 채용중인 정보 페이지에서 가져옴
-- a-b : 채용분야에서 url타고 들어가서 '채용상세' 가져왔음
-- 기본정보 : 시퀀스, 그룹번호, 회사명, 이미지url, 한줄 소개, 모집대상(a), 주요업무(a-b), 채용상세(a-b), 연봉(a), 경력(a), 언어특기(a), 마감일(a), 기업소개글
-- 복지해택 : 개인장비, 자기개발, 식사시간, 연차휴가, 근무형태, 보험의료  
-- 기업정보 : 설립일, 구성원, 홈페이지, 사무실위치, 산업분야


DROP SEQUENCE COMPANY_SEQ
DROP TABLE COMPANY

CREATE SEQUENCE COMPANY_SEQ;

CREATE TABLE COMPANY
(
	-- 기본정보 : 시퀀스, 그룹번호, 회사명, 이미지url, 한줄 소개, 모집대상(a), 주요업무(a-b), 채용상세(a-b), 연봉(a), 경력(a), 언어특기(a), 마감일(a), 기업소개글
    COMPANYSEQ       NUMBER            NOT NULL, 
    GROUPNO          NUMBER            NOT NULL, 
    COMPANYNAME      VARCHAR2(200)     NOT NULL, 
    IMGURL           VARCHAR2(1000)    NOT NULL, 
    ONEINTRO         VARCHAR2(1000)    NOT NULL, 
    BUSINESS         VARCHAR2(1000)    NOT NULL, 
    MAINBUSINESS	 VARCHAR2(3000)	   NOT NULL, 
    JOBDETAIL        CLOB			   NOT NULL, 
    SALARY           VARCHAR2(200)     NOT NULL, 
    TARGET           VARCHAR2(20)      NOT NULL, 
    LANGUAGES        VARCHAR2(1000)    NOT NULL, 
    ENDEATE          VARCHAR2(100)     NOT NULL, 
    INTRO            VARCHAR2(3000)    NOT NULL, 
    -- 복지해택 : 개인장비, 자기개발, 식사시간, 연차휴가, 근무형태, 보험의료  
    GIVETOOL         VARCHAR2(1000)    NOT NULL, 
    SELFGROWTH       VARCHAR2(1000)    NOT NULL, 
    MEALTIME         VARCHAR2(1000)    NOT NULL, 
    HOLIDAY          VARCHAR2(1000)    NOT NULL, 
    WORKINGHOUR      VARCHAR2(1000)    NOT NULL, 
    INSURANCE        VARCHAR2(1000)    NOT NULL, 
    -- 기업상세정보 : 설립일, 구성원, 홈페이지, 사무실위치, 산업분야
    INCORPORATION    VARCHAR2(200)     NOT NULL, 
    TOTALMEMBER      VARCHAR2(200)     NOT NULL, 
    HOMEPAGE         VARCHAR2(1000)    NOT NULL, 
    LOCATION         VARCHAR2(1000)    NOT NULL, 
    MAINFIELD        VARCHAR2(1000)    NOT NULL, 
    CONSTRAINT COMPANY_PK PRIMARY KEY (COMPANYSEQ)
)

