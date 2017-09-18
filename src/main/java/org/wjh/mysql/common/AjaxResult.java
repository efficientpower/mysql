package org.wjh.mysql.common;

import java.util.LinkedHashMap;

public class AjaxResult<T> extends LinkedHashMap<String, Object> {

    private static final long serialVersionUID = 1495384984709059416L;

    public AjaxResult() {
        put("code", MobileCode.OK.getCode());
    }

    public AjaxResult(Integer code) {
        put("code", code);
    }

    public AjaxResult(Integer code, String message) {
        put("code", code);
        put("message", message);
    }

    public void setCode(Integer code) {
        put("code", code);
    }

    public void setMesage(String message) {
        put("message", message);
    }

    public void setData(T data) {
        put("data", data);
    }

}