package ru.sbt.mipt.oop;

import com.coolcompany.smarthome.events.SensorEventsManager;

public class EventManagerAdapter implements EventManager {
    final private Observer observer;
    final private SensorEventsManager sensorEventsManager;

    public EventManagerAdapter(Observer observer) {
        this.observer = observer;
        sensorEventsManager = new SensorEventsManager();
    }

    @Override
    public void runEvents(SmartHome smartHome) {
        sensorEventsManager.registerEventHandler(ccSensorEvent -> {
            SensorEvent event = new SensorEventAdapter(ccSensorEvent);
            observer.notifySub(smartHome, event);
        });
        sensorEventsManager.start();
    }

}
