package cyz.boot.test.http.constants;

/**
 */
public final class ResultCode {

  private ResultCode() {}

  public static final String LOGIN = "login"; // login required

  public static final String RESET_PWD = "resetPwd";

  public static final String LOGIN_VIA_UA = "login_via_ua"; // login required

  public static final String SUCCESS = "success"; // successful completion

  public static final String ERROR = "error"; // error during execution

  public static final String VALID = "valid";

  public static final String INVALID = "invalid";

  // result status that means the user doesn't have permission on relative operations,
  // which can be configured in the techops system
  public static final String INSUFFICIENT_PERMISSION = "insufficient_permission";

}
