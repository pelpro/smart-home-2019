package ru.sbt.mipt.oop;

import java.util.Collection;

public interface Observer {
    void sub(EventHandler handler);
    void sub(Collection<EventHandler> handlers);
    void unsub(EventHandler handler);
    void notifySub(SmartHome smartHome, SensorEvent event);
}
