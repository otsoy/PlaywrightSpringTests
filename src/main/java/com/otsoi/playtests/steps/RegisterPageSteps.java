package com.otsoi.playtests.steps;

import com.otsoi.playtests.entities.TestUser;
import com.otsoi.playtests.pages.*;
import com.otsoi.playtests.testData.TestUserFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RegisterPageSteps implements Logoutable {
    private final RegisterPage registerPage;
    private final RegisterResultPage registerResultPage;

    public PlaywrightPageElement register(TestUser user) {
        registerPage.selectGender(user.getGender());
        registerPage.enterFirstName(user.getFirstName());
        registerPage.enterLastName(user.getLastName());
        registerPage.enterEmail(user.getEmail());
        registerPage.enterPassword(user.getPassword());
        registerPage.enterConfirmPassword(user.getPassword());
        registerPage.clickRegister();

        if (registerResultPage.isOpened())
            return SpringContext.getBean(RegisterResultPage.class);
        else
            return SpringContext.getBean(RegisterPage.class);
    }

    public PlaywrightPageElement registerRandom() {
        TestUser user = TestUserFactory.createRandom();
        return register(user);
    }
}

