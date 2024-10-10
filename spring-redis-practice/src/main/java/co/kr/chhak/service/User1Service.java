package co.kr.chhak.service;

import co.kr.chhak.dto.User1;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

@RequiredArgsConstructor
@Service
public class User1Service {

    private static final String KEY = "user1";

    private final RedisTemplate<String, User1> redisTemplate;

    // Create or Update
    public void save(User1 user) {
        redisTemplate.opsForHash().put(KEY, user.getUid(), user);
    }

    // Read
    public User1 findByUid(String uid) {
        return (User1) redisTemplate.opsForHash().get(KEY, uid);
    }

    // Read all
    public Map<Object, Object> findAll() {
        return redisTemplate.opsForHash().entries(KEY);
    }

    // Delete
    public void delete(String id) {
        redisTemplate.opsForHash().delete(KEY, id);
    }

}
