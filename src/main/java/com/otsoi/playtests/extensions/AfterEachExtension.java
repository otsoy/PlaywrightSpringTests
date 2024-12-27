package com.otsoi.playtests.extensions;

import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.SimpleThreadScope;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.microsoft.playwright.Page;

import io.qameta.allure.Attachment;

public class AfterEachExtension implements AfterEachCallback {

    @Override
    public void afterEach(ExtensionContext context) throws Exception {

        ApplicationContext springContext = SpringExtension.getApplicationContext(context);
        Page page = springContext.getBean(Page.class);
        takeScreenshot(page);

        recreatePageBean(springContext);
    }

    @Attachment
    public byte[] takeScreenshot(Page page) {
        return page.screenshot();
    }

    void recreatePageBean(ApplicationContext applicationContext) {
        System.out.println("Recreating page bean");
        DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) applicationContext
                .getAutowireCapableBeanFactory();
        Page page = applicationContext.getBean(Page.class);
        var context = page.context();
        var browser = context.browser();

        page.close();
        context.close();
        browser.close();

        // Получаем текущий ThreadScope и удаляем bean
        SimpleThreadScope threadScope = (SimpleThreadScope) beanFactory.getRegisteredScope("threadScope");
        threadScope.remove("Secondary");

        // Проверяем создание нового bean'а
        Page newPage = applicationContext.getBean(Page.class);
        System.out.println("New page bean created: " + newPage);

    }
}