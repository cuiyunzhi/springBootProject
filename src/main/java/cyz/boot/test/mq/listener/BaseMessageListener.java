package cyz.boot.test.mq.listener;

import org.springframework.amqp.core.MessageListener;

public interface BaseMessageListener extends MessageListener{
	String getExchange();
	String getQueue();
	String getRoutingKey();
}
