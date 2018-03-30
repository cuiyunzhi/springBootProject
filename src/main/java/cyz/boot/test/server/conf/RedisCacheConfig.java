package cyz.boot.test.server.conf;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisNode;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.util.Assert;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;

import cyz.boot.test.common.utils.LoggerUtil;

@Configuration
@EnableCaching
@ConditionalOnProperty(prefix = "spring.redis", name = "enable", matchIfMissing = false)
public class RedisCacheConfig extends CachingConfigurerSupport {
	
	@Autowired
	private RedisConfig redisConfig;

	public List<RedisNode> setRedisNode() {
		List<RedisNode> redisNodeList = null;
		try {
			RestTemplate restTemplate = new RestTemplate();
			String url = redisConfig.getClusterUrl();
			Map<String, String> redisNodeMap = restTemplate.getForObject(url, Map.class);
			String nodes = redisNodeMap.get("shardInfo");
			String[] redisNodes = nodes.split(" ");
			redisNodeList = new ArrayList<>();
			// 增加Redis Cluster 节点
			for (int i = 0; i < redisNodes.length; i++) {
				String[] redisNode = redisNodes[i].split(":");
				redisNodeList.add(new RedisNode(redisNode[0], Integer.parseInt(redisNode[1])));
			}
		} catch (RestClientException e) {
			LoggerUtil.error("Connect to the CacheCloud exception", e);
		} catch (NumberFormatException e) {
			LoggerUtil.error("Digital formatting exception", e);
		}
		return redisNodeList;
	}

	@Bean
	public RedisClusterConfiguration redisClusterConfiguration() {
		Assert.notNull(setRedisNode(), "Redis failed to initialize");
		RedisClusterConfiguration redisClusterConfiguration = new RedisClusterConfiguration();
		redisClusterConfiguration.setClusterNodes(setRedisNode());
		redisClusterConfiguration.setMaxRedirects(5);
		return redisClusterConfiguration;
	}

	@Bean
	public JedisConnectionFactory jedisConnectionFactory() {
		return new JedisConnectionFactory(redisClusterConfiguration());
	}

	@Bean
	public StringRedisTemplate stringRedisTemplate() {
		StringRedisTemplate redisTemplate = new StringRedisTemplate();
		redisTemplate.setConnectionFactory(jedisConnectionFactory());
		LoggerUtil.info("redis initialization is complete");
		return redisTemplate;
	}

	@Bean
	public RedisTemplate<String, String> redisTemplate() {
		RedisTemplate<String, String> redisTemplate = new RedisTemplate<String, String>();
		redisTemplate.setConnectionFactory(jedisConnectionFactory());
		Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
		ObjectMapper om = new ObjectMapper();
		om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
		om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
		jackson2JsonRedisSerializer.setObjectMapper(om);
		redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
		return redisTemplate;
	}

	@Bean
	public CacheManager cacheManager(RedisTemplate redisTemplate) {
		RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);
		cacheManager.setDefaultExpiration(1);
		// cacheManager.setDefaultExpiration(1);
		return cacheManager;
	}
}
