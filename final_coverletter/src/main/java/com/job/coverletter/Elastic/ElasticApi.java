package com.job.coverletter.Elastic;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.entity.ContentType;
import org.apache.http.nio.entity.NStringEntity;
import org.apache.http.util.EntityUtils;
import org.elasticsearch.client.Request;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;

import com.google.gson.Gson;

public class ElasticApi {

	private String host = "localhost";
	private int port = 9200;

	/**
	 * 엘라스틱서치에서 제공하는 api를 이용한 전송메소드
	 * 
	 * @param method
	 * @param url
	 * @param obj
	 * @param jsonData
	 * @return
	 */
	public Map<String, Object> callElasticApi(String method, String url, Object obj, String jsonData) {	// 나는 get만 사용할 것임
		Map<String, Object> result = new HashMap<String, Object>();

//        String jsonString;
//        //json형태의 파라미터가 아니라면 gson으로 만들어주자.
//        if (jsonData == null) {
//            Gson gson = new Gson();
//            jsonString = gson.toJson(obj);
//        } else {
//            jsonString = jsonData;
//        }

		// 엘라스틱서치에서 제공하는 restClient를 통해 엘라스틱서치에 접속한다
		try (RestClient restClient = RestClient.builder(new HttpHost(host, port)).build()) {	// 자동으로 닫아준다.
			Map<String, String> params = Collections.singletonMap("pretty", "true");

			// 엘라스틱서치에서 제공하는 response 객체
			Response response = null;
			Request request = new Request(method, url); // method=(GET, POST, HEAD, etc) "get", "/"

			// GET, DELETE 메소드는 HttpEntity가 필요없다
			if (method.equals("GET") || method.equals("DELETE")) {

				request.addParameter("pretty", "true"); // 요청시 옵션 : 응답시 이쁜모양(보기좋게 만든 json구조 말함)으로 응답요청, true??

				response = restClient.performRequest(request); // 응답 = 요청실행

				// POST, PUT는 수정이기 때문에 보낼 값을 json타입으로 설정해야함
			} else {
				// HttpEntity entity = new NStringEntity(jsonString,
				// ContentType.APPLICATION_JSON); // Gson 사용
				HttpEntity entity = new NStringEntity("{\"json\":\"text\"}", ContentType.APPLICATION_JSON);
				// 해당 json값을(내가 설정함) , "application/json" 으로 읽어달라는 요청 설정후 보낸다.
				request.addParameter("pretty", "true"); // 요청시 옵션
				request.setEntity(entity); // 요청시 옵션 >>> entity구조를, application/json로 읽어달라고 지정해서 요청
				// == request.setJsonEntity("{\"json\":\"text\"}");

				response = restClient.performRequest(request); // 응답 = 요청실행

			}

			// 앨라스틱서치에서 리턴되는 응답코드를 받는다
			int statusCode = response.getStatusLine().getStatusCode();
			// 엘라스틱서치에서 리턴되는 응답메시지를 받는다
			String responseBody = EntityUtils.toString(response.getEntity());
			result.put("resultCode", statusCode);
			result.put("resultBody", responseBody);

		} catch (Exception e) {
			result.put("resultCode", -1);
			result.put("resultBody", e.toString());
		}
		return result;
	}

}
