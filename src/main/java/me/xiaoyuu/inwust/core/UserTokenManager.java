package me.xiaoyuu.inwust.core;

import me.xiaoyuu.inwust.dto.UserToken;
import me.xiaoyuu.inwust.utils.CharUtil;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class UserTokenManager {
    private static Map<String, UserToken> tokenMap = new HashMap<>();
    private static Map<Integer, UserToken> idMap = new HashMap<>();

    public static Integer getUserId(String token) {
        UserToken userToken = tokenMap.get(token);
        if (beforeCheck(userToken)) {
            return null;
        }

        return userToken.getUserId();
    }

    private static boolean beforeCheck(UserToken userToken) {
        return userToken == null || (isExpire(userToken));
    }

    private static boolean isExpire(UserToken userToken) {
        if (userToken.getExpireTime().isBefore(LocalDateTime.now())) {
            tokenMap.remove(userToken.getToken());
            idMap.remove(userToken.getUserId());
            return true;
        }
        return false;
    }

    public static UserToken generateToken(Integer id) {

        String token = CharUtil.getRandomString(32);
        while (tokenMap.containsKey(token)) {
            token = CharUtil.getRandomString(32);
        }

        LocalDateTime updateTime = LocalDateTime.now();
        LocalDateTime expireTime = updateTime.plusDays(7);

        UserToken userToken = new UserToken();
        userToken.setToken(token);
        userToken.setUpdateTime(updateTime);
        userToken.setExpireTime(expireTime);
        userToken.setUserId(id);
        tokenMap.put(token, userToken);
        idMap.put(id, userToken);
        return userToken;
    }

    public static String getSessionKey(Integer id) {
        UserToken userToken = idMap.get(id);
        if (beforeCheck(userToken)) {
            return null;
        }

        return userToken.getSessionKey();
    }

    public static void removeToken(Integer id) {
        UserToken userToken = idMap.get(id);
        userToken.setExpireTime(LocalDateTime.now().minusDays(7));
        isExpire(userToken);
    }

}
