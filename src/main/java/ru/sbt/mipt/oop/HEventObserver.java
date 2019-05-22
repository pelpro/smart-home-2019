package ru.sbt.mipt.oop;

import java.util.ArrayList;
import java.util.Collection;

public class HEventObserver implements Observer {
    private ArrayList<EventHandler> subscribers = new ArrayList<>();

    @Override
    public void sub(EventHandler handler) {
        subscribers.add(handler);
    }

    @Override
    public void sub(Collection<EventHandler> handlers) {
        subscribers.addAll(handlers);
    }

    @Override
    public void unsub(EventHandler handler) {
        subscribers.remove(handler);
    }

    @Override
    public void notifySub(SmartHome smartHome, SensorEvent event) {
        for (EventHandler subscriber : subscribers) {
            subscriber.handleEvent(smartHome, event);
        }
    }
}
