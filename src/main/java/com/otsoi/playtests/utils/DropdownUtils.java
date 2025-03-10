package com.otsoi.playtests.utils;

import java.util.List;
import java.util.stream.Collectors;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;

public class DropdownUtils {

    public static List<String> getAllOptions(Page page, String selector) {
        page.waitForCondition(() -> page.querySelectorAll(selector + "/option").size() != 0);
        List<ElementHandle> options = page.querySelectorAll(selector + "/option");
        return options.stream()
                .map(ElementHandle::textContent)
                .collect(Collectors.toList());
    }

    public static void selectFirstOption(Page page, String selector) {
        List<String> options = getAllOptions(page, selector);
        if (!options.isEmpty()) {
            page.selectOption(selector, options.get(0));
        }
    }
}