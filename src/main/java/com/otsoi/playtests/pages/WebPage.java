package com.otsoi.playtests.pages;

import java.util.function.Supplier;

import com.microsoft.playwright.Page.NavigateOptions;

public interface WebPage extends PlaywrightPageElement {
    public boolean isOpened();

    default NavigateOptions getCustomNavigateOptions() {
        return new NavigateOptions().setTimeout(10000);
    }

    default boolean waitUntil(Supplier<Boolean> condition, long maxTimeMillis, long intervalMillis) {
        long startTime = System.currentTimeMillis();
        while (System.currentTimeMillis() - startTime < maxTimeMillis) {
            if (condition.get()) {
                return true;
            }
            try {
                Thread.sleep(intervalMillis);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return false;
            }
        }
        return false;
    }

    default boolean waitUntil(Supplier<Boolean> condition) {
        return waitUntil(condition, 10000, 500); // Используем таймаут 10 секунд и интервал 500 мс
    }
}
