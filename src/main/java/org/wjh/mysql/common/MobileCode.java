package org.wjh.mysql.common;

public enum MobileCode {
    /** 成功 200 */
    OK("处理完成", 200),
    /** 处理失败,包括所有的失败情况 1 */
    FAIL("失败", 1),
    /** 参数异常400 */
    PARAM_EXCEPTION("参数异常", 400),
    /** 未登录，登录失败 401 */
    UNAUTHORIZED("未授权", 401),
    /** 访问对象不存在（或者对于用户不可见） 404 */
    NOT_FOUND("您访问的对象不存在", 404),
    /** 服务器异常：500 */
    SERVER_ERROR("服务器异常", 500),
    /** 服务不可用 503 */
    SERVICE_UNAVAILABLE("服务不可用", 503),;

    private final int code;
    private final String msg;

    MobileCode(String msg, int code) {
        this.msg = msg;
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return msg;
    }
}