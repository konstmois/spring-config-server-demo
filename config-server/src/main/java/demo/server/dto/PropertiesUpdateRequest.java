package demo.server.dto;

import java.util.Map;
import lombok.Data;

@Data
public class PropertiesUpdateRequest {
    private String application;
    private String profile;
    private Map<String, String> properties;
}
