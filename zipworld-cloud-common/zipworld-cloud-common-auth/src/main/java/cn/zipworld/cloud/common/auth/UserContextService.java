package cn.zipworld.cloud.common.auth;


import cn.zipworld.cloud.common.entity.auth.UserContext;
import cn.zipworld.cloud.common.util.redis.RedisHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;
@Service
public class UserContextService {
    @Autowired
    private RedisHelper redisService;


    @Value("${spring.redis.tokenExpireTime}")
    public Long tokenExpireTime;//token过期时间

    private String token_key = "token:";

    /**
     * 保存token
     * @param userContext
     * @return
     */
    public String tokenStorage( UserContext userContext) {
        //生成token
        String token = UUID.randomUUID().toString().replaceAll("-", "");
        userContext.setToken(token);
        LocalDateTime expire = LocalDateTime.now();
        expire = expire.plusSeconds(tokenExpireTime);
        userContext.setExpire(expire);
        //存储redis里
        redisService.set(token_key+token,userContext,tokenExpireTime);
        return token;
    }

    public boolean tokenRefresh(UserContext userContext,String token){
        userContext.setToken(token);
        LocalDateTime expire = LocalDateTime.now();
        expire = expire.plusSeconds(tokenExpireTime);
        userContext.setExpire(expire);
        //如果存在，存储redis里
        redisService.setIfAbsent(token_key+token,userContext,tokenExpireTime);
        return true;
    }

    public UserContext getUserContext(String token){
        //ValueOperations<String, String> ops = redisTemplate.opsForValue();
        //UserContext userContext = JsonUtils.toEntity(redisDao.getValue(token_key+token),UserContext.class);
        UserContext userContext = (UserContext) redisService.get(token_key+token,UserContext.class);
        return userContext;
    }
}
