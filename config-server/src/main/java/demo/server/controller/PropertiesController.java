package demo.server.controller;


import demo.server.dto.PropertiesUpdateRequest;
import demo.server.dto.SuccessResponse;
import demo.server.service.PropertiesService;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.NOT_ACCEPTABLE;

@RestController
@AllArgsConstructor
public class PropertiesController {

    private final PropertiesService service;

    @PostMapping("/properties")
    public SuccessResponse updateProperties(@RequestBody @Valid PropertiesUpdateRequest rq) {
        try {
            service.updateProperties(rq);
            return new SuccessResponse();
        } catch (Exception ex) {
            throw new ResponseStatusException(NOT_ACCEPTABLE, "Properties update failed", ex);
        }
    }

}
