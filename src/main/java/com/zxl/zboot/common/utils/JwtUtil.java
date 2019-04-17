package com.zxl.zboot.common.utils;

import com.zxl.zboot.common.exception.CustomException;
import com.zxl.zboot.common.filter.CustomHttpServletRequest;
import com.zxl.zboot.sys.entity.SysUser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class JwtUtil {
    static final String SECRET = "ThisIsASecret";

    public static String generateToken(String username) {
        HashMap<String, Object> map = new HashMap<>();
        //you can put any data in the map
        map.put("username", username);
        String jwt = Jwts.builder()
                .setClaims(map)
                .setExpiration(new Date(System.currentTimeMillis() + 3600_000_000L))// 1000 hour
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
        return "Bearer " + jwt; //jwt前面一般都会加Bearer
    }

    public static void validateToken(String token) {
        try {
            // parse the token.
            Map<String, Object> body = Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(token.replace("Bearer ", ""))
                    .getBody();
        } catch (Exception e) {
            throw new CustomException(401, "Invalid Token. " + e.getMessage());
        }
    }

    public static HttpServletRequest validateTokenAndAddUserIdToHeader(HttpServletRequest request, SysUser sysUser) {
        Map<String, Object> map = new HashMap<>();
        map.put("userId", sysUser.getId());
        //下面这行代码很关键， 通过CustomHttpServletRequest实现了修改Request
        return new CustomHttpServletRequest(request, map);
    }

    public static String getUsernameFromToken(String token) {
        Map<String, Object> body = Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token.replace("Bearer ", ""))
                .getBody();
        return body.get("username").toString();
    }
}
