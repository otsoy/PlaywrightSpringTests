package com.otsoi.playtests.pages;

import com.otsoi.playtests.blocks.HeaderBlock;

public interface Logoutable {
    default void logout(){
        SpringContext.getBean(HeaderBlock.class).clickLogout();
    }
}
