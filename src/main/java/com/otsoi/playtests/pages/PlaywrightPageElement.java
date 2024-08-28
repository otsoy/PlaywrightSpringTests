package com.otsoi.playtests.pages;

import com.microsoft.playwright.Page;

public abstract class PlaywrightPageElement{

    //this workaround is needed because of Spring confusing Plawright Page between
    // threads despite threadlocal scope is provided

    protected Page getPage() {
        return SpringContext.getBean(Page.class);
    }

    public <T extends PlaywrightPageElement> T to(Class<T>  clazz) {
        if(clazz.isInstance(this)){
            return clazz.cast(this);
        }
        else throw new RuntimeException("Cannot convert to " + clazz.getSimpleName());
    }
}
