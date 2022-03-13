package demo.server.service;

import demo.server.dto.PropertiesUpdateRequest;
import lombok.AllArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PropertiesService {

    private final StringRedisTemplate redis;

    public void updateProperties(PropertiesUpdateRequest rq) {
        rq.getProperties().forEach((k, v) ->
                redis.opsForHash().put(rq.getApplication() + "-" + rq.getProfile(), k, v)
        );
    }
}
