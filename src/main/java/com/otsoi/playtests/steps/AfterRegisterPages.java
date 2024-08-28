package com.otsoi.playtests.steps;

import com.otsoi.playtests.pages.PlaywrightPageElement;
import com.otsoi.playtests.pages.RegisterPage;
import com.otsoi.playtests.pages.RegisterResultPage;
import com.otsoi.playtests.pages.SpringContext;

public enum AfterRegisterPages {
    REGISTER,
    REGISTER_RESULT;

    PlaywrightPageElement toPage() {
        return switch (this) {
            case REGISTER -> SpringContext.getBean(RegisterPage.class);
            case REGISTER_RESULT -> SpringContext.getBean(RegisterResultPage.class);
        };
    }
}
