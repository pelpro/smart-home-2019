package ru.sbt.mipt.oop;

public interface Action<T> {
    String get_room_name();

    String get_type_name();

    void launchAction(T object, String room_name);
}
