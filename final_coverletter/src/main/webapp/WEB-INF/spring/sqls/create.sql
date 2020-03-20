--검색쿼리문(제목 OR 본문) : 댓글제외, 페이징
SELECT B.*
FROM (
	SELECT A.*, ROW_NUMBER() OVER(ORDER BY BOARDSEQ DESC) AS RNUM
	FROM BOARD A
		WHERE (TITLE LIKE '%' || '글' || '%' OR CONTENT LIKE '%' || '글' || '%')
		AND GROUPSEQ = 1
	) B	
WHERE RNUM BETWEEN 1 AND 10
ORDER BY BOARDSEQ DESC

-- 반복 쿼리 처리 : boardList 쿼리문에 include refid 적용해보기
