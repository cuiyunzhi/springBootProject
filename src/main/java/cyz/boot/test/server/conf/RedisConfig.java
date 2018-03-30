package cyz.boot.test.server.conf;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "spring.redis")
public class RedisConfig {

    private String clusterUrl;

	public String getClusterUrl() {
		return clusterUrl;
	}

	public void setClusterUrl(String clusterUrl) {
		this.clusterUrl = clusterUrl;
	}
    
    

}
