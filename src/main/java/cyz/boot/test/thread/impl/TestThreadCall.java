package cyz.boot.test.thread.impl;

import java.util.concurrent.Callable;

import org.springframework.context.support.ApplicationObjectSupport;

import cyz.boot.test.handler.AppBankHandler;
import cyz.boot.test.service.AppBankTreadService;
import cyz.boot.test.thread.conf.SpringUtils;

public class TestThreadCall extends ApplicationObjectSupport implements Callable<Object> {
//	private static ApplicationContext applicationContext;
	
	private Class<?> clazz;
	
	@Override
	public Object call() throws Exception {
		Object task = SpringUtils.getBeanFromClazz(clazz);
		if (task instanceof AppBankTreadService)
		{
			((AppBankTreadService) task).printThreadInfo();
		}
		return null;
	}

	public TestThreadCall( Class<?> clazz) {
		super();
		this.clazz = clazz;
	}
	
	 
}
