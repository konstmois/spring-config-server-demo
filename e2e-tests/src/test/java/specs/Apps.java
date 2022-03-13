package specs;

import io.github.adven27.env.core.Environment;
import io.github.adven27.env.core.ExternalSystem;
import io.github.adven27.env.jar.application.JarApplication;
import io.github.adven27.env.jar.application.JarWebService;
import java.io.File;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

public class Apps extends Environment {

    public Apps() {
        super(
            Map.of(
                    "CONFIG_SERVER", configServerJar(),
                    "APP_CLIENT", appClientJar()
            )
        );

    }

    @NotNull
    private static JarWebService configServerJar() {
        return new JarWebService(
                new File("../config-server/build/libs/config-server-0.0.1-SNAPSHOT.jar"),
                8888,
                new JarApplication.Config()
                        .addArgs("--spring.profiles.active=redis")

        );
    }

    @NotNull
    private static JarWebService appClientJar() {
        return new JarWebService(
                new File("../app-client/build/libs/app-client-0.0.1-SNAPSHOT.jar"),
                8080,
                new JarApplication.Config().addArgs("--spring.profiles.active=demo")
        );
    }

    public ExternalSystem configServer() {
        return env("CONFIG_SERVER");
    }

    public ExternalSystem appClient() {
        return env("APP_CLIENT");
    }

}
