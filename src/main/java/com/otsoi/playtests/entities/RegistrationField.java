package com.otsoi.playtests.entities;

public enum RegistrationField {
    FIRST_NAME("First name"),
    LAST_NAME("Last name"),
    EMAIL("Email"),
    PASSWORD("Password"),
    GENDER("Gender");

    private final String text;
    RegistrationField(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
