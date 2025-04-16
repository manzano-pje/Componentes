package com.pjem.login.record;

import com.pjem.login.identitie.Roles;

public record UserRespenseDto(
        String email,
        Roles role
) {
}
