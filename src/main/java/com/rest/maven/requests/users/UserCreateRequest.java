package com.rest.maven.requests.users;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class UserCreateRequest {
    @Size(min = 4, max = 100, message = "Value must be between 1 and 100 characters")
    @ApiModelProperty(value = "User's password", required = true)
    @NotNull
    private String passwordHash;

    @NotNull
    @ApiModelProperty(value = "User's name")
    private String name;
}
