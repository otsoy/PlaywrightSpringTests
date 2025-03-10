package com.otsoi.playtests.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.otsoi.playtests.entities.TestUser;
import com.otsoi.playtests.steps.MainPageSteps;
import com.otsoi.playtests.steps.RegisterPageSteps;
import com.otsoi.playtests.testData.TestUserFactory;

import jakarta.annotation.PostConstruct;

@Component
public class UserPool {
    private List<TestUser> users;

    @Autowired
    private MainPageSteps mainPageSteps;

    @Autowired
    private RegisterPageSteps registerPageSteps;

    public UserPool() {
        this.users = new ArrayList<>();
    }

    @PostConstruct
    private void initializeUsers() {
        for (int i = 0; i < 3; i++) { // Create 3 users for example
            TestUser user = TestUserFactory.createRandom();
            mainPageSteps.open();
            mainPageSteps.startRegistration();
            registerPageSteps.register(user);
            registerPageSteps.logout();
            users.add(user);
        }
    }

    public synchronized TestUser getUser() {
        if (!users.isEmpty()) {
            TestUser user = users.remove(0);
            ThreadLocal<TestUser> threadLocalUser = new ThreadLocal<>();
            threadLocalUser.set(user);
            return user;
        }
        throw new RuntimeException("No users left in the pool");
    }

    public synchronized void returnUser(TestUser user) {
        System.out.println(users.size());

        users.add(user);
        System.out.println("AFTER: " + users.size());
    }
}