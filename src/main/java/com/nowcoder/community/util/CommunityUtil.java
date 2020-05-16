package com.nowcoder.community.util;


import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.DigestUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class CommunityUtil {

    //生成随机字符串
    public static String generateUUID() {
        //生成随机字符串使用UUID工具默认生成的字符串由字母数字和'-'构成，可替换掉
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    /**
     * md5加密
     * hello -> abc123def456
     * hello + 3e4a8 -> abc123def456abc
     * @param key
     * @return
     * MD5加密(不能解密)，简单密码容易被简单密码库破解，+salt（随机字符串）以提高安全性。
     * 使用Apach.Commons.lang3.StringUtils（之前导包的工具）.isBlank(key)来判断是否为空。
     * DigestUtils（Spring自带工具）.md5DigestAsHex(key)，将传入的结果加密成一个16进制的字符串。
     */
    public static String md5(String key) {
        if (StringUtils.isBlank(key)) {
            return null;
        }
        return DigestUtils.md5DigestAsHex(key.getBytes());
    }

    public static String getJSONString(int code, String msg, Map<String, Object> map) {
        JSONObject json = new JSONObject();
        json.put("code", code);
        json.put("msg", msg);
        if (map != null) {
            for (String key : map.keySet()) {
                json.put(key, map.get(key));
            }
        }
        return json.toJSONString();
    }

    public static String getJSONString(int code, String msg) {
        return getJSONString(code, msg, null);
    }

    public static String getJSONString(int code) {
        return getJSONString(code, null, null);
    }

    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "zhangsan");
        map.put("age", 25);
        System.out.println(getJSONString(0, "ok", map));
    }
}
