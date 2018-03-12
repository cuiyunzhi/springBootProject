package cyz.boot.test.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cyz.boot.test.common.utils.LoggerUtil;
import cyz.boot.test.handler.AppBankHandler;
import cyz.boot.test.http.common.ApiResult;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Controller
public class HelloWorldController {
	//private final Logger log = LoggerFactory.getLogger(HelloWorldController.class);
	
	@Autowired
	private AppBankHandler appBankHandler;
	

	
	@ApiOperation(value = "helloworld接口", httpMethod = "GET")
	@RequestMapping("/hello/{id}")
    @ResponseBody
    @ApiResponses(value = { 
    		@ApiResponse(code = 200, message = "成功保存"),
    		@ApiResponse(code = 400, message = "系统错误") })
    @ApiImplicitParam(name = "id",
            value = "测试参数ID",
            dataType = "Long",//This can be the class name or a primitive
            required = true,
            paramType = "path")//path, query, body, header or form
    ApiResult<String> home(@PathVariable("id") Long id) {
		LoggerUtil.info("HelloWorldController"+id+" info:"+appBankHandler.getFirstAppBank().getBankName());
        return ApiResult.success("Hello World!");
    }
}
