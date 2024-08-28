package com.otsoi.playtests.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
public class TestUser {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Gender gender;
}
