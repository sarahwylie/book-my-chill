package io.bootify.book_my_chill.model;

public enum AmenityType {
    POOL("POOL"), SAUNA("SAUNA"), GYM("GYM");

    private final String name;

    AmenityType(String value) {
        name = value;
    }

    @Override
    public String toString() {
        return name;
    }
}