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


