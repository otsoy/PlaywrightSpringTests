package com.otsoi.playtests.testData;

import com.github.javafaker.Faker;
import com.otsoi.playtests.entities.Gender;
import com.otsoi.playtests.entities.RegistrationField;
import com.otsoi.playtests.entities.TestUser;

import java.util.List;

public class TestUserFactory {
    private static final Faker faker = new Faker();
    private static final String PASSWORD = "password";
    public static TestUser createRandom(){
        return TestUser.builder()
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .gender(faker.bool().bool() ? Gender.FEMALE: Gender.MALE)
                .email(faker.internet().emailAddress())
                .password(PASSWORD)
                .build();
    }

    public static TestUser createRandom(List<RegistrationField> excluded){
        var builder =  TestUser.builder();
        if(!excluded.contains(RegistrationField.FIRST_NAME)){
                builder.firstName(faker.name().firstName());
        }
        if(!excluded.contains(RegistrationField.LAST_NAME)){
            builder .lastName(faker.name().lastName());
        }
        if(!excluded.contains(RegistrationField.GENDER)){
            builder.gender(faker.bool().bool() ? Gender.FEMALE: Gender.MALE);
        }
        if(!excluded.contains(RegistrationField.EMAIL)){
            builder.email(faker.internet().emailAddress());
        }
        if(!excluded.contains(RegistrationField.PASSWORD)){
            builder.password(PASSWORD);
        }
        return builder.build();
    }
}
