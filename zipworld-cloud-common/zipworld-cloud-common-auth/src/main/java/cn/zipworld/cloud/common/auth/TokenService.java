package cn.zipworld.cloud.common.auth;


import cn.zipworld.cloud.common.util.redis.RedisHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;


import java.util.UUID;

public class TokenService {

    @Value("${redis.expireTime}")
    private Long expireTime;//token过期时间

    @Autowired
    private RedisHelper redisService;

    @Autowired
    private StringRedisTemplate redisTemplete;
    public String TokenStorage( String username) {
        //生成token
        String token = UUID.randomUUID().toString().replaceAll("-", "");
        //存储redis里
        redisService.set(token, username, expireTime);
        return token;
    }
}
