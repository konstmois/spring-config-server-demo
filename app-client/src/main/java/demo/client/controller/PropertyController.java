package demo.client.controller;

import java.util.Map;
import lombok.AllArgsConstructor;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RefreshScope
@AllArgsConstructor
public class PropertyController {

    private final ApplicationContext ctx;

    @GetMapping("/property-value/{key}")
    public Map<String, String> getProperty(@PathVariable String key) {
        return Map.of(key, ctx.getEnvironment().getProperty(key));
    }
}
