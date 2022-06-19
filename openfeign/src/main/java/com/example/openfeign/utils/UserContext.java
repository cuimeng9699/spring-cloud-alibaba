package com.example.openfeign.utils;

import com.share.foreign.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @ClassName UserContext
 * @Description TODO
 * @Author Mr.Cui
 * @Date 6/19/22 11:20 AM
 */
@Slf4j
public class UserContext {
    private static final ThreadLocal<Map<String, Object>> CTX = new ThreadLocal();
    public static final String USER_CURRENT = "USER_CURRENT";


    public static void setCurrentUser(UserDTO user) {
        Map<String, Object> map = (Map) CTX.get();
        if (map == null) {
            map = new HashMap();
        }

        if (user != null) {
            ((Map) map).put(USER_CURRENT, user);
            CTX.set(map);
        }

        if (log.isDebugEnabled()) {
            log.debug("set user to threadLocal-user:{}", user);
            debugLog((Map) map);
        }

    }

    public static UserDTO getCurrentUser() {
        Map<String, Object> map = (Map) CTX.get();
        return map != null ? (UserDTO) map.get(USER_CURRENT) : null;
    }


    private static void debugLog(Map<String, Object> map) {
        Iterator var1 = map.entrySet().iterator();

        while (var1.hasNext()) {
            Map.Entry<String, Object> entry = (Map.Entry) var1.next();
            log.debug("key:{},value:{}", entry.getKey(), entry.getValue());
        }

    }

    public static void clear() {
        CTX.remove();
    }
}
