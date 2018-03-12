 /**
 * 
 */
package cyz.boot.test.thread.conf;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 *
 */
@Configuration
public class ThreadConfig {
	
//	@Primary
	@Bean(name = "testThreadPool")
	public ThreadPoolTaskExecutor threadPoolTaskExecutor()
	{
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(10);
		executor.setMaxPoolSize(40);
		executor.setQueueCapacity(200);
		executor.setKeepAliveSeconds(2000);
		return executor;
	}
}
