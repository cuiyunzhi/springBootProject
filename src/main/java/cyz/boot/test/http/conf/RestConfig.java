package cyz.boot.test.http.conf;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "rest.connection")
public class RestConfig {

    private int connectionRequesTimeout;
    
    private int connectionTimeout;
    
    private int connectionReadTimeout;
    
	public int getConnectionRequesTimeout() {
		return connectionRequesTimeout;
	}
	
	public void setConnectionRequesTimeout(int connectionRequesTimeout) {
		this.connectionRequesTimeout = connectionRequesTimeout;
	}
	
	public int getConnectionTimeout() {
		return connectionTimeout;
	}
	
	public void setConnectionTimeout(int connectionTimeout) {
		this.connectionTimeout = connectionTimeout;
	}
	
	public int getConnectionReadTimeout() {
		return connectionReadTimeout;
	}
	
	public void setConnectionReadTimeout(int connectionReadTimeout) {
		this.connectionReadTimeout = connectionReadTimeout;
	}


}
