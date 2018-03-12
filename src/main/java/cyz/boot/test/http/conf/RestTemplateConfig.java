package cyz.boot.test.http.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
	
	@Autowired
	private RestConfig restConfig;

	@Bean
	public SimpleClientHttpRequestFactory httpClientFactory() {
	    SimpleClientHttpRequestFactory httpRequestFactory = new SimpleClientHttpRequestFactory();
	    httpRequestFactory.setReadTimeout(restConfig.getConnectionReadTimeout());
	    httpRequestFactory.setConnectTimeout(restConfig.getConnectionTimeout());
	         
	    return httpRequestFactory;
	}
	
	
	@Bean
	public RestTemplate restTemplate(SimpleClientHttpRequestFactory httpClientFactory) {
	     RestTemplate restTemplate = new RestTemplate(httpClientFactory);
         return restTemplate;
	}
	
	@Bean
	public SimpleClientHttpRequestFactory simpleHttpClientFactory() {
	    SimpleClientHttpRequestFactory httpRequestFactory = new SimpleClientHttpRequestFactory();
	    return httpRequestFactory;
	}
	
	
	@Bean
	public RestTemplate restTemplateClient(SimpleClientHttpRequestFactory simpleHttpClientFactory) {
	     RestTemplate restTemplate = new RestTemplate(simpleHttpClientFactory);
         return restTemplate;
	}
}
