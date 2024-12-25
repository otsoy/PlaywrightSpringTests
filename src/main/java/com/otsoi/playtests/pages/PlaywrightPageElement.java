package com.otsoi.playtests.pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import com.otsoi.playtests.spring.SpringContext;

public interface PlaywrightPageElement {

    // this workaround is needed because of Spring confusing Plawright Page between
    // threads despite threadlocal scope is provided

    default Page getPage() {
        return SpringContext.getBean(Page.class);
    }

    default <T extends PlaywrightPageElement> T to(Class<T> clazz) {
        if (clazz.isInstance(this)) {
            return clazz.cast(this);
        } else
            throw new RuntimeException("Cannot convert to " + clazz.getSimpleName());
    }

    default void waitForPageLoad() {
        getPage().waitForLoadState(LoadState.LOAD); // ждет когда сеть будет неактивна
    }
}
