
package cyz.boot.test.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import cyz.boot.test.interceptor.WebInterceptor;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		//swagger2.0UI
//		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
//		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
		//升级到swagger3.0UI
		registry.addResourceHandler("index.html").addResourceLocations("classpath:/static/");
		registry.addResourceHandler("*.js").addResourceLocations("classpath:/static/");
		registry.addResourceHandler("*.css").addResourceLocations("classpath:/static/");
	};

	@Override
	public void configurePathMatch(PathMatchConfigurer configurer) {
		AntPathMatcher matcher = new AntPathMatcher();
		matcher.setCaseSensitive(false);
		configurer.setPathMatcher(matcher);
	};

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {

		converters.add(mappingJackson2HttpMessageConverter());
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// 多个拦截器组成一个拦截器链
		// addPathPatterns 用于添加拦截规则
		// excludePathPatterns 用户排除拦截
		registry.addInterceptor(new WebInterceptor()).addPathPatterns("/**").excludePathPatterns("/*.html").excludePathPatterns("/*.js").excludePathPatterns("/*.css");
//		registry.addInterceptor(new ConsoleSessionInterceptor()).addPathPatterns("/qyjApi/bk/**").excludePathPatterns("/qyjApi/bk/home/login").excludePathPatterns("/qyjApi/bk/selectBaseData/**");
//		registry.addInterceptor(new ConsolePermissionInterceptor()).addPathPatterns("/qyjApi/bk/**");
		super.addInterceptors(registry);
	};

	@Bean
	public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
		MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		// objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);
		jsonConverter.setObjectMapper(objectMapper);
		return jsonConverter;
	}

}
