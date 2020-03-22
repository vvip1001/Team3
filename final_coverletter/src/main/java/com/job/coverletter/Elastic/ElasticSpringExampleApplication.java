package com.job.coverletter.Elastic;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.job.coverletter.model.company.dto.CompanyDto;

public class ElasticSpringExampleApplication {

	//@Autowired
	ElasticApi elasticApi = new ElasticApi();

	private final String ELASTIC_INDEX = "nlpdb-2020.80.20";
	private final String ELASTIC_TYPE = "_doc";

	public void 엘라스틱서치_POST_전송() {
		String url =  ELASTIC_INDEX + "/" + ELASTIC_TYPE;
		CompanyDto weather = new CompanyDto();
		// set를 이용해 insert하는 내용 추가
		
		
		Map<String, Object> result = elasticApi.callElasticApi("POST", url, weather, null);
		System.out.println(result.get("resultCode"));
		System.out.println(result.get("resultBody"));
	}


	public void 엘라스틱서치_PUT_전송() {
		String id = "122345";
		String url = ELASTIC_INDEX + "/" + ELASTIC_TYPE+"/"+id;
		CompanyDto weather = new CompanyDto();
		// set를 이용해 update값 추가

		Map<String, Object> result = elasticApi.callElasticApi("PUT", url, weather, null);
		System.out.println(result.get("resultCode"));
		System.out.println(result.get("resultBody"));
	}


	public void 앨라스틱서치_GET_전송() {
		String id = "30";
		//String url = ELASTIC_INDEX + "/" + ELASTIC_TYPE+"/"+id;
		String url =  "http://localhost:9200/" + ELASTIC_INDEX + "/" + ELASTIC_TYPE+"/_search?q=companyseq:"+id;
		
		Map<String, Object> result = elasticApi.callElasticApi("GET", url, null, null);
		System.out.println(result.get("resultCode"));
		System.out.println(result.get("resultBody"));
	}


	public void 앨라스틱서치_DELETE_전송() {
		String id = "";
		String url = ELASTIC_INDEX + "/" + ELASTIC_TYPE+"/"+id;
		Map<String, Object> result = elasticApi.callElasticApi("DELETE", url, null, null);
		System.out.println(result.get("resultCode"));
		System.out.println(result.get("resultBody"));
	}

public static void main(String[] args) {
	ElasticSpringExampleApplication test = new ElasticSpringExampleApplication();
	test.앨라스틱서치_GET_전송();
	
	
}

}



