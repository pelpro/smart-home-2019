package ru.sbt.mipt.oop;

public interface Actionable<T> {
    void execute(Action<T> action);
}
