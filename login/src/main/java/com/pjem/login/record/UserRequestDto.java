package com.pjem.login.record;

import com.pjem.login.identitie.Roles;

public record UserRequestDto(
        int id,
        String email,
        String password,
        Roles role) {
}
