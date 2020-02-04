package cn.zipworld.cloud.common.util.redis;


import cn.zipworld.cloud.common.util.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.concurrent.TimeUnit;

@Service
public class RedisHelper {
    @Autowired
    private StringRedisTemplate template;

    public  void set(String key,String value){
        ValueOperations<String, String> ops = template.opsForValue();
        ops.set(key,value);
    }

    public String get(String key){
        ValueOperations<String, String> ops = this.template.opsForValue();
        return ops.get(key);
    }

    public void set(String key,Object object,long l){
        //ValueOperations<String, Object> ops = this.redisTemplate.opsForValue();
        // this.redisTemplate.opsForValue().set(key,object,l);
        String json = JsonUtils.toJson(object);
        ValueOperations<String, String> ops = template.opsForValue();
        ops.set(key,json,l,TimeUnit.SECONDS );

    }
    public void setIfAbsent(String key,Object object,long l){
        //ValueOperations<String, Object> ops = this.redisTemplate.opsForValue();
        // this.redisTemplate.opsForValue().set(key,object,l);
        String json = JsonUtils.toJson(object);
        ValueOperations<String, String> ops = template.opsForValue();
        ops.setIfAbsent(key,json,l, TimeUnit.SECONDS);
    }

    public<T> T get(String key,Class<T> t){
        //ValueOperations<String, Object> ops = redisTemplate.opsForValue();
        String json = template.opsForValue().get(key);
        if (StringUtils.isEmpty(json) || json.trim().length()==0)
            return null;
        T res = JsonUtils.toEntity(json,t);
        return res;
    }
}