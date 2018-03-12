package cyz.boot.test.service.impl;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cyz.boot.test.dao.AppBankMapper;
import cyz.boot.test.model.AppBank;
import cyz.boot.test.service.AppBankService;
import cyz.boot.test.thread.impl.TestThreadCall;

@Service
public class AppBankServiceImpl implements AppBankService {

	@Autowired
	private AppBankMapper appBankMapper;
	@Autowired
	private ThreadPoolTaskExecutor taskExecutor;
	@Override
	@Transactional
	public List<AppBank> getAllAppBank() {
		Callable<Object>  call = new TestThreadCall(AppBankThreadServiceImpl.class);
		Future<Object> future = taskExecutor.submit(call);
		try {
			future.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return appBankMapper.selectAll();
	}

}
