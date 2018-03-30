package cyz.boot.test.runner;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import cyz.boot.test.common.utils.LoggerUtil;



@Component
public class StartRunner implements ApplicationRunner{


    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        LoggerUtil.info("==================启动日志==================");
    }

}
