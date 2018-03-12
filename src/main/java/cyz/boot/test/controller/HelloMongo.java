package cyz.boot.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cyz.boot.test.http.common.ApiResult;
import cyz.boot.test.mongo.handler.UserHandler;
import io.swagger.annotations.ApiOperation;

@Controller
public class HelloMongo {
	@Autowired
	private UserHandler userHandler;
	@ApiOperation(value = "testSaveUser接口", httpMethod = "GET")
	@RequestMapping("/mongo/testSaveUser")
	@ResponseBody
	ApiResult<String> testSaveUser() throws Exception {
		userHandler.testSaveUser();
        return ApiResult.success("Hello World!");
    }
	@ApiOperation(value = "findUserByUserName接口", httpMethod = "GET")
	@RequestMapping("/mongo/findUserByUserName")
	@ResponseBody
	ApiResult<String> findUserByUserName() throws Exception {
		userHandler.findUserByUserName();;
		return ApiResult.success("Hello World!");
	}
	@ApiOperation(value = "updateUser接口", httpMethod = "GET")
	@RequestMapping("/mongo/updateUser")
	@ResponseBody
	ApiResult<String> updateUser() throws Exception {
		userHandler.updateUser();
		return ApiResult.success("Hello World!");
	}
	@ApiOperation(value = "deleteUserById接口", httpMethod = "GET")
	@RequestMapping("/mongo/deleteUserById")
	@ResponseBody
	ApiResult<String> deleteUserById() throws Exception {
		userHandler.deleteUserById();
		return ApiResult.success("Hello World!");
	}
	@ApiOperation(value = "savePrimary接口", httpMethod = "GET")
	@RequestMapping("/mongo/savePrimary")
	@ResponseBody
	ApiResult<String> savePrimary() throws Exception {
		userHandler.savePrimaryUser();
		return ApiResult.success("Hello World!");
	}
	@ApiOperation(value = "queryPrimary接口", httpMethod = "GET")
	@RequestMapping("/mongo/queryPrimary")
	@ResponseBody
	ApiResult<String> queryPrimary() throws Exception {
		userHandler.queryPrimaryUser();
		return ApiResult.success("Hello World!");
	}
}
