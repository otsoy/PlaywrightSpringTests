package com.otsoi.playtests;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.otsoi.playtests.pages.SpringContext;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.context.support.SimpleThreadScope;

@Configuration
public class AppConfiguration {
    @PostConstruct
    public void init() {
        SimpleThreadScope threadScope = new SimpleThreadScope();
        ConfigurableBeanFactory beanFactory = ((ConfigurableApplicationContext) applicationContext).getBeanFactory();
        beanFactory.registerScope("threadScope", threadScope);
    }

    @Autowired
    private ApplicationContext applicationContext;

    @Bean("Secondary")
    @Scope("threadScope")
    public Page page() {
        Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        var page =  browser.newPage();
        System.out.println("CREATED" + page.toString());
        return page;
    }
}
