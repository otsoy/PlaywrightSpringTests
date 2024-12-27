package com.otsoi.playtests.pages;

import com.otsoi.playtests.blocks.LeftPanel;
import com.otsoi.playtests.spring.SpringContext;

public interface Logoutable {
    default void logout() {
        SpringContext.getBean(LeftPanel.class).clickLogout();
    }
}
