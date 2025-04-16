package com.pjem.login.record;

import com.pjem.login.identitie.Roles;

public record UserReturnDto(
        String email,
        Roles role
) {
}
