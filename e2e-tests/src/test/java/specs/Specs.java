package specs;

import io.github.adven27.concordion.extensions.exam.core.AbstractSpecs;
import io.github.adven27.concordion.extensions.exam.core.ExamExtension;
import io.github.adven27.concordion.extensions.exam.ws.WsPlugin;
import org.jetbrains.annotations.NotNull;

public class Specs extends AbstractSpecs {

    //Spring Config Sources Environment
    private ConfigSources CONFIG_SOURCES;
    //Systems under testing: ConfigServer and AppClient
    private Apps APPS;

    @NotNull
    @Override
    protected ExamExtension init() {
        enableEnvironmentOnStaticPortStartup();
        CONFIG_SOURCES = new ConfigSources();
        CONFIG_SOURCES.up();
        return new ExamExtension(
                new WsPlugin(8080)
        );
    }

    @Override
    protected void afterTearDown() {
        CONFIG_SOURCES.down();
    }

    @Override protected void startSut() {
        APPS = new Apps(CONFIG_SOURCES);
        APPS.up();
    }
    @Override protected void stopSut() {
        APPS.down();
    }

    private void enableEnvironmentOnStaticPortStartup() {
        System.setProperty("SPECS_ENV_FIXED", "true");
    }

}
