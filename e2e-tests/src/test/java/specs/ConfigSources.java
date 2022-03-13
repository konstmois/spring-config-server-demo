package specs;

import io.github.adven27.env.core.Environment;
import io.github.adven27.env.core.ExternalSystem;
import io.github.adven27.env.jar.application.JarApplication;
import io.github.adven27.env.jar.application.JarWebService;
import io.github.adven27.env.mq.redis.RedisContainerSystem;
import java.io.File;
import java.util.Map;

import static io.github.adven27.env.mq.redis.RedisContainerSystem.*;

public class ConfigSources extends Environment {

    public ConfigSources() {
        super(
            Map.of(
                    "REDIS", new RedisContainerSystem(DEFAULT_IMAGE, 6379, new RedisContainerSystem.Config("localhost", 6379))
            )
        );
    }

    public RedisContainerSystem redis() {
        return env("REDIS");
    }

}
