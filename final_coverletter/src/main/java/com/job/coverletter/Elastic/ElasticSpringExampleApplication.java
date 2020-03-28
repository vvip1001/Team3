package com.job.coverletter.Elastic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.job.coverletter.model.company.dto.CompanyDto;

public class ElasticSpringExampleApplication {

	@Autowired
	ElasticApi elasticApi = new ElasticApi();

	private final String ELASTIC_INDEX = "nlpdb-2020.80.20.temp";
	private final String ELASTIC_TYPE = "_doc";

	public void 엘라스틱서치_POST_전송() {
		String url = ELASTIC_INDEX + "/" + ELASTIC_TYPE;
		CompanyDto weather = new CompanyDto();
		// set를 이용해 insert하는 내용 추가

		Map<String, Object> result = elasticApi.callElasticApi("POST", url, weather, null);
		System.out.println(result.get("resultCode"));
		System.out.println(result.get("resultBody"));
	}

	public void 엘라스틱서치_PUT_전송() {
		String id = "122345";
		String url = ELASTIC_INDEX + "/" + ELASTIC_TYPE + "/" + id;
		CompanyDto weather = new CompanyDto();
		// set를 이용해 update값 추가

		Map<String, Object> result = elasticApi.callElasticApi("PUT", url, weather, null);
		System.out.println(result.get("resultCode"));
		System.out.println(result.get("resultBody"));
	}

	public void 앨라스틱서치_GET_전송() {
		//String id = "30";
		// String url = ELASTIC_INDEX + "/" + ELASTIC_TYPE+"/"+id;
		//String url = "http://localhost:9200/" + ELASTIC_INDEX + "/" + ELASTIC_TYPE + "/_search?q=companyseq:" + id;
		String url = "http://localhost:9200/" + ELASTIC_INDEX + "/_search";
		String json	= "{\"query\":" +  "{\"match\":{" + "\"languages.nori\":" + "\"java\"}}}";
		Map<String, Object> result = elasticApi.callElasticApi_GET("GET", url, null, json);
		System.out.println(result.get("resultCode"));
		System.out.println(result.get("resultBody"));
		
		
	}
	public void 앨라스틱서치_DELETE_전송() {
		String id = "";
		String url = ELASTIC_INDEX + "/" + ELASTIC_TYPE + "/" + id;
		Map<String, Object> result = elasticApi.callElasticApi("DELETE", url, null, null);
		System.out.println(result.get("resultCode"));
		System.out.println(result.get("resultBody"));
	}

	
	
	/*
	 * 비동기 ajax를 이용해
		veiw의 selectBox의 값을 DTO로 받는다.
		DTO값을 json형태로 만들어 elastic에 전달할 query로 변환한다.
		json형태의 String로 결과를 반환 받는다.
		
		
		
		#veiw에서 js로
		결과 json에 total의 값에 따라 페이징을 한다
		if(결과 < 11){  // 1 ~ 10
			페이지 번호 "1"만 만든다
			String 그대로 view로 보내어 js에서 json으로 파싱하여 뷰를 그린다.
			 
	
		} else if(결과 > 10){
			1. 결과 json에서 total의 개수를 10으로 나누어 페이지를 표시한다.
			2. 그 다음 10개씩 그려주고 페이징에서 다음 번호를 눌렀을떄 해당 키워드 그대로 from+10을 요청하고 다음 10개를 리턴받는다. 
			
		
		

	 */
	
	public String jabSearchRes(CompanyDto searchKeyWord){
		String url = "http://localhost:9200/" + ELASTIC_INDEX + "/_search";
		
		List<CompanyDto> companyList = new ArrayList<CompanyDto>();
		Map<String, String> query = new HashMap<String, String>();  
		
		
		query.put("languages", "java");
		
		/*
# 페이징 
  GET nlpdb-2020.80.20.temp/_search
{
  "from" : 0,	# 시작 페이지 	>> 한페이지에 10개를 보여준다면 +10 하면됨.
  "size" : 10,	# 몇개씩 가져올지 
  "_source": 	# 어떤 필드(칼럼)만 보여줄지 안 쓰면 다가져옴.
    [
    "companyseq", "imgurl", "business", "enddate", "oneintro", "mainfield", "languages", "companyname", "location", "salary", "target"
    ], 
  "sort":		# 정렬 
    [{"companyseq" : "desc"}],	# companyseq를 desc기준으로 정렬해서 가져온다.
  "query": {
    "bool": {
      "must": [		# 검색 조건 
          {"match": {"languages": "java"}},
          {"match": {"business": "개발"}}
      ]
    }
  }
}
		 
		 
		 */
		
		


		//elastic 요청
		Map<String, Object> result = elasticApi.callElasticApi_GET("GET", url, query, null);
		System.out.println(result.get("resultCode"));
		String jsonString = (String) result.get("resultBody");
		//System.out.println(jsonString);
		
		return jsonString;		
	}
	
	
	
	
	
	
	
	public static void main(String[] args) {
		ElasticSpringExampleApplication test = new ElasticSpringExampleApplication();
		test.앨라스틱서치_GET_전송();
		
		
//		Map<String,String> map = new HashMap<String,String>();
//		map.put("id", "asd12sdnwe==");
//		Gson gson = new GsonBuilder().disableHtmlEscaping().create();
//		String json = gson.toJson(map);
//		System.out.println(json);

	}
	
	

}
