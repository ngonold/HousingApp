package com.niit.housing.dto.token;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class TokenRequest {
    private final String username;
    private final String password;
}
