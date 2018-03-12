package cyz.boot.test.http.conf;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import cyz.boot.test.http.common.HttpResponseErrorHandler;


@Configuration
@Component
public class HttpResponseConfig {
	@Autowired
  	private RestTemplate restTemplate;
	
	@PostConstruct
	public void setHttpResponseErrorHandler(){
		restTemplate.setErrorHandler(new HttpResponseErrorHandler());
	}
	//封装请求参数
//	HttpHeaders headers = new HttpHeaders();
//	MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
//	headers.setContentType(type);
//	JSONObject postJson = new JSONObject();
//    postJson.put("param", value);
    //HttpEntity<String> formEntity = new HttpEntity<String>(postJson.toString(), headers);
	//String result = restTemplate.postForObject(url, formEntity, String.class);
}
