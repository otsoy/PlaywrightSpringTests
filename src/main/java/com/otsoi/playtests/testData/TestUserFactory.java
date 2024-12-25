package com.otsoi.playtests.testData;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;
import com.otsoi.playtests.entities.RegistrationField;
import com.otsoi.playtests.entities.TestUser;
import com.otsoi.playtests.steps.RegisterPageSteps;

@Component
public class TestUserFactory {
    private static final Faker faker = new Faker();
    private static final String PASSWORD = "password";
    @Autowired
    private static RegisterPageSteps registerPageSteps;

    public static TestUser createRandom() {
        return TestUser.builder()
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .username(faker.name().username())
                .address(faker.address().streetAddress())
                .city(faker.address().city())
                .state(faker.address().state())
                .zipCode(faker.address().zipCode())
                .phone(faker.phoneNumber().cellPhone())
                .ssn(faker.number().digits(9))
                .password(PASSWORD)
                .confirmPassword(PASSWORD)
                .build();
    }

    public static TestUser createRandom(List<RegistrationField> excluded) {
        var builder = TestUser.builder();
        if (!excluded.contains(RegistrationField.FIRST_NAME)) {
            builder.firstName(faker.name().firstName());
        }
        if (!excluded.contains(RegistrationField.LAST_NAME)) {
            builder.lastName(faker.name().lastName());
        }
        if (!excluded.contains(RegistrationField.PASSWORD)) {
            builder.password(PASSWORD);
        }
        if (!excluded.contains(RegistrationField.CONFIRM_PASSWORD)) {
            builder.confirmPassword(PASSWORD);
        }
        if (!excluded.contains(RegistrationField.USERNAME)) {
            builder.username(faker.name().username());
        }
        if (!excluded.contains(RegistrationField.ADDRESS)) {
            builder.address(faker.address().streetAddress());
        }
        if (!excluded.contains(RegistrationField.CITY)) {
            builder.city(faker.address().city());
        }
        if (!excluded.contains(RegistrationField.STATE)) {
            builder.state(faker.address().state());
        }
        if (!excluded.contains(RegistrationField.ZIP_CODE)) {
            builder.zipCode(faker.address().zipCode());
        }
        if (!excluded.contains(RegistrationField.PHONE)) {
            builder.phone(faker.phoneNumber().cellPhone());
        }
        if (!excluded.contains(RegistrationField.SSN)) {
            builder.ssn(faker.number().digits(9));
        }
        return builder.build();
    }

    public static TestUser createAndRegisterUser() {
        TestUser user = createRandom();
        registerPageSteps.register(user);
        return user;
    }

    public static TestUser getTestUser() {
        return TestUser.builder().username("john").password("demo").build();
    }
}
