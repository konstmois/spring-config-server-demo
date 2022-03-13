package demo.server.dto;

import lombok.Getter;

import static demo.server.dto.Status.SUCCESS;

@Getter
public class SuccessResponse {
    private final Status status = SUCCESS;
}
