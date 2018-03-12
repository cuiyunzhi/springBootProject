package cyz.boot.test.mq.listener.impl;

import org.springframework.amqp.core.Message;
import org.springframework.stereotype.Component;

import cyz.boot.test.common.utils.LoggerUtil;
import cyz.boot.test.mq.listener.BaseMessageListener;

@Component
public class TestMessageListener implements BaseMessageListener{

	@Override
	public void onMessage(Message message) {
		LoggerUtil.info("testMessage listener received message:{}",message.toString());
	}

	@Override
	public String getExchange() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getQueue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getRoutingKey() {
		// TODO Auto-generated method stub
		return null;
	}

}
