package com.zxl.sb.common.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.util.*;

public class CustomHttpServletRequest extends HttpServletRequestWrapper {
    private Map<String, String> claims = new HashMap<>();

    public CustomHttpServletRequest(HttpServletRequest request, Map<String, Object> claims) {
        super(request);
        //把jwt里面的信息都保存下来
        claims.forEach((k, v) -> this.claims.put(k, String.valueOf(v)));
    }

    @Override
    public Enumeration<String> getHeaders(String key) {
        if (claims != null && claims.containsKey(key)) {
            //如果jwt都这个数据, 就直接返回
            return Collections.enumeration(Collections.singletonList(claims.get(key)));
        }
        return super.getHeaders(key);
    }
}
