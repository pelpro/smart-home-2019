package ru.sbt.mipt.oop;

public class HEventManager implements EventManager {
    final private SensorEventGetter sensorEventGetter;
    final private Observer observer;

    public HEventManager(Observer observer, SensorEventGetter sensorEventGetter) {
        this.sensorEventGetter = sensorEventGetter;
        this.observer = observer;
    }

    @Override
    public void runEvents(SmartHome smartHome) {
        SensorEvent event = sensorEventGetter.getNextSensorEvent();
        while (event != null) {
            observer.notifySub(smartHome, event);
            System.out.println("Event: " + event);
            event = sensorEventGetter.getNextSensorEvent();
        }
    }
}
