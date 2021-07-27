package ru.geekbrains.spring.lesson2.exception;

public class MissingProductException extends Exception {

    private static final String MESSAGE = "Product does not exists!";

    public MissingProductException() {
        super(MESSAGE);
    }
}
