--검색쿼리문(제목 OR 본문) : 글 갯수
SELECT COUNT(*)
FROM BOARD
WHERE GROUPSEQ = 1
AND (TITLE LIKE '%' || '제목' || '%' OR CONTENT LIKE '%' || '본문' || '%' OR JOINEMAIL LIKE '%' || '아이디' || '%')

--검색쿼리문(제목 OR 본문) : 댓글제외, 페이징
SELECT B.*
FROM (
	SELECT A.*, ROW_NUMBER() OVER(ORDER BY BOARDSEQ DESC) AS RNUM
	FROM BOARD A
		WHERE (TITLE LIKE '%' || '제목' || '%' OR CONTENT LIKE '%' || '본문' || '%' OR JOINEMAIL LIKE '%' || '아이디' || '%')
		AND GROUPSEQ = 1
	) B	
WHERE RNUM BETWEEN 1 AND 10
ORDER BY BOARDSEQ DESC

-- 반복 쿼리 처리 : boardList 쿼리문에 include refid 적용해보기

<SQL id="boardListCount">
	SELECT COUNT(*)
	FROM BOARD
	WHERE GROUPSEQ = 1
</SQL>

<select id="searchListCount" resultType="int">
	<include refid="boardListCount" />
	AND (TITLE LIKE '%' || '제목' || '%' OR CONTENT LIKE '%' || '본문' || '%' OR JOINEMAIL LIKE '%' || '아이디' || '%')
</select>

--===========================================================================
--CHART
INSERT INTO SKILL (SKILLSEQ, JOINEMAIL, CATEGORY, CONTEST, REGDATE)
VALUES (SKILL_SEQ.NEXTVAL, 'cv@email.com', '공모전', '카카오 IT 공모전', '202001')

SELECT LANGUAGESCORE, COUNT(CONTEST), COUNT(CATEGORY)
FROM SKILL
WHERE JOINEMAIL = 'cv@email.com'
GROUP BY LANGUAGESCORE

INSERT INTO SCHOOL VALUES 
(SCHOOL_SEQ.NEXTVAL, 'cv@email.com', '대졸', '한국대학교', '201503', '201902', '심리학', '4.0/4.5');

--어학점수(가장 최근 취득한 점수만)
SELECT *
FROM (
	SELECT (LANGUAGESCORE/10), ROW_NUMBER() OVER(ORDER BY REGDATE DESC) AS RNUM
	FROM SKILL
	WHERE JOINEMAIL = 'cv@email.com'
	AND CATEGORY = '어학'
)
WHERE RNUM = 1

--공모전, 자격증
SELECT COUNT(CONTEST) * 10, COUNT(CERTIFICATE) * 10
FROM SKILL
WHERE JOINEMAIL = 'cv@email.com'

--학점
SELECT GRADE
FROM SCHOOL
WHERE JOINEMAIL = 'cv@email.com'

--학력
SELECT *
FROM (
	SELECT CAREER, ROW_NUMBER() OVER(ORDER BY GRADUATE DESC) AS RNUM
	FROM SCHOOL
	WHERE JOINEMAIL = 'cv@email.com'
)
WHERE RNUM = 1










--mybatis 동적쿼리문 작성
SELECT COUNT(*)
FROM BOARD
WHERE GROUPSEQ = 1
	<trim prefix = "WHERE" prefixOverrides = "AND|OR">
		<if test="category == 'title' AND keyword != NULL AND keyword != ''">
			AND TITLE LIKE ('%' || #{keyword} || '%')
		</if>
		<if test="category == 'content' AND keyword != NULL AND keyword != ''">
			AND CONTENT LIKE ('%' || #{keyword} || '%')
		</if>
		<if test="category == 'joinemail' AND keyword != NULL AND keyword != ''">
			AND JOINEMAIL LIKE ('%' || #{keyword} || '%')
		</if>
	</trim>
	
	
--동적쿼리문
SELECT B.*
FROM (
	SELECT A.*, ROW_NUMBER() OVER(ORDER BY BOARDSEQ DESC) AS RNUM
	FROM BOARD A
		WHERE GROUPSEQ = 1
		<trim prefix = "WHERE" prefixOverrides = "AND|OR">
			<if test="category == 'title' AND keyword != NULL AND keyword != ''">
				AND TITLE LIKE ('%' || #{keyword} || '%')
			</if>
			<if test="category == 'content' AND keyword != NULL AND keyword != ''">
				AND CONTENT LIKE ('%' || '본문' || '%')
			</if>
			<if test="category == 'joinemail' AND keyword != NULL AND keyword != ''">
				AND JOINEMAIL LIKE ('%' || '작성자' || '%')
			</if>
		</trim>
	) B	
WHERE RNUM BETWEEN  #{StartIndex} + 1 AND #{CntPerPage}
ORDER BY BOARDSEQ DESC




SELECT *
FROM BOARD


