package ru.relex.library.rest.model;

public class Value<T> {

    private final T value;

    public Value(final T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}
