package com.niit.housing.dto.token;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class TokenDto {
    private final String token;
}
