package ru.geekbrains.spring.lesson2.model;

public enum ProductTitle {

    ORANGE("orange"),
    APPLE("apple"),
    GRAPES("grapes"),
    WATERMELON("watermelon"),
    LEMON("lemon");

    private final String title;

    ProductTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
