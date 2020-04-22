package com.yelv.yelv_blog.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * 页面数据
 */
public class Messages {
    //状态码   0-成功  -1失败
    private int code;
    //提示信息
    private String msg;
    //用户要返回给浏览器的数据
    private Map<String, Object> data = new HashMap<String, Object>();

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public static Messages success(){
        Messages result = new Messages();
        result.setCode(0);
        result.setMsg("……^o^处理成功！");
        return result;
    }

    public static Messages fail(){
        Messages result = new Messages();
        result.setCode(-1);
        result.setMsg("O _ O失败了！");
        return result;
    }

    public Messages add(String key, Object value) {
        this.getData().put(key,value);
        return this;
    }
}
