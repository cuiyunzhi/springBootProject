package cyz.boot.test.handler.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import cyz.boot.test.common.utils.LoggerUtil;
import cyz.boot.test.handler.AppBankHandler;
import cyz.boot.test.model.AppBank;
import cyz.boot.test.service.AppBankService;

@Component
@Scope("prototype")
public class AppBankHandlerImpl implements AppBankHandler{
	@Autowired
	private AppBankService appBankService;
	@Override
	public AppBank getFirstAppBank() {
		List<AppBank> appBankLists = appBankService.getAllAppBank();
		LoggerUtil.info("do getFirstAppBank query...");
		return (appBankLists == null ||appBankLists.size() == 0)?new AppBank():appBankLists.get(0);
	}

}
