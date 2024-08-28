package com.otsoi.playtests;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.SimpleThreadScope;

@Configuration
@PropertySource("classpath:test-config.yml")
public class AppConfiguration {
    @Value("${playwright.headless:true}")
    @Autowired
    private boolean headlessMode;
    @Autowired
    private ApplicationContext applicationContext;

    @PostConstruct
    public void init() {
        SimpleThreadScope threadScope = new SimpleThreadScope();
        ConfigurableBeanFactory beanFactory = ((ConfigurableApplicationContext) applicationContext).getBeanFactory();
        beanFactory.registerScope("threadScope", threadScope);
    }

    @Bean("Secondary")
    @Scope("threadScope")
    public Page page() {
        Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(headlessMode));
        var page = browser.newPage();
        System.out.println("CREATED" + page.toString());
        return page;
    }
}
