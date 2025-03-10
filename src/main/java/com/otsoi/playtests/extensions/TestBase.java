package com.otsoi.playtests.extensions;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;

import com.otsoi.playtests.entities.TestUser;
import com.otsoi.playtests.utils.UserPool;

@ExtendWith(AfterEachExtension.class)
public class TestBase {

    @Autowired
    protected UserPool userPool;

    public TestUser currentUser;

    @BeforeEach
    public void setUpUserPool() {
        currentUser = userPool.getUser();
    }

    @AfterEach
    public void returnUserToPool() {

        if (currentUser != null) {
            userPool.returnUser(currentUser);
        }
    }
}