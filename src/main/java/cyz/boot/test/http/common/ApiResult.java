package cyz.boot.test.http.common;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import cyz.boot.test.http.constants.ResultCode;

import java.util.List;


/**
 */
public class ApiResult<T> {

  private String result;
  private T content;
  private List<String> errors;
  private List<String> messages;

  public ApiResult() {}

  public ApiResult(String result) {
    this.result = result;
    this.errors = Lists.newArrayList();
    this.messages = Lists.newArrayList();
  }

  public ApiResult(String result, T content) {
    this.result = result;
    this.content = content;
    this.errors = Lists.newArrayList();
    this.messages = Lists.newArrayList();
  }

  public ApiResult(String result, String message) {
    this.result = result;
    this.errors = Lists.newArrayList();
    this.messages = Lists.newArrayList(message);
  }

  public ApiResult(String result, List<String> messages) {
    this.result = result;
    this.errors = Lists.newArrayList();
    this.messages = messages;
  }

  public static ApiResult success() {
    return success(Maps.newHashMap());
  }

  public static ApiResult customize(String resultCode, Object context) {
    return new ApiResult(resultCode, context);
  }

  public static ApiResult success(String str) {
	  return new ApiResult(ResultCode.SUCCESS, str);
  }
  public static ApiResult success(Object context) {
    return new ApiResult(ResultCode.SUCCESS, context);
  }

  public static ApiResult error(String message) {
    return new ApiResult(ResultCode.ERROR, message);
  }

  public static ApiResult errors(List<String> messages) {
    return new ApiResult(ResultCode.ERROR, messages);
  }

  public T getContent() {
    return content;
  }

  public void setContent(T content) {
    this.content = content;
  }

  public String getResult() {
    return result;
  }

  public void setResult(String result) {
    this.result = result;
  }

  public List<String> getErrors() {
    if (null == errors) {
      return Lists.newArrayList();
    }
    return errors;
  }

  public void setErrors(List<String> errors) {
    this.errors = errors;
  }

  public List<String> getMessages() {
    if (null == messages) {
      return Lists.newArrayList();
    }
    return messages;
  }

  public void setMessages(List<String> messages) {
    this.messages = messages;
  }


}
