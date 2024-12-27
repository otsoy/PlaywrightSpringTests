package com.otsoi.playtests.entities;

public enum RegistrationField {
    FIRST_NAME("First name"),
    LAST_NAME("Last name"),
    ADDRESS("Address"),
    CITY("City"),
    STATE("State"),
    ZIP_CODE("Zip Code"),
    PHONE("Phone"),
    SSN("Social Security Number"),
    USERNAME("Username"),
    PASSWORD("Password"),
    CONFIRM_PASSWORD("Password confirmation");

    private final String text;

    RegistrationField(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
