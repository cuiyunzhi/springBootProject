package cyz.boot.test.service.impl;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cyz.boot.test.common.utils.LoggerUtil;
import cyz.boot.test.dao.AppBankMapper;
import cyz.boot.test.handler.impl.AppBankHandlerImpl;
import cyz.boot.test.model.AppBank;
import cyz.boot.test.service.AppBankService;
import cyz.boot.test.service.AppBankTreadService;
import cyz.boot.test.thread.impl.TestThreadCall;

@Service
public class AppBankThreadServiceImpl implements AppBankTreadService {

	@Autowired
	private AppBankMapper appBankMapper;
	@Autowired
	private ThreadPoolTaskExecutor taskExecutor;
	@Override
	@Transactional
	public void printThreadInfo() {
		LoggerUtil.info("=======thread run========");
	}

}
