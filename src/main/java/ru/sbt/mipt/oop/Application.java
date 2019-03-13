package ru.sbt.mipt.oop;

import java.io.IOException;
import java.util.Collection;
import java.util.ArrayList;

public class Application {

    public static void main(String... args) throws IOException {
        // считываем состояние дома из файла
        GsonHomeReader reader = new GsonHomeReader("smart-home-1.js");
        SmartHome smartHome = reader.readSmartHome();
        // начинаем цикл обработки событий
        SensorEvent event = getNextSensorEvent();
        Collection<EventHandler> EventsCollection = new ArrayList<>();
        EventsCollection.add(new DoorHandler());
        EventsCollection.add(new LightHandler());
        EventsCollection.add(new HallDoorHandler());
        while (event != null) {
            System.out.println("Got event: " + event);
            for (EventHandler handler : EventsCollection) {
                handler.handleEvent(smartHome, event);
            }
            event = getNextSensorEvent();
        }
    }

    private static SensorEvent getNextSensorEvent() {
        // pretend like we're getting the events from physical world, but here we're going to just generate some random events
        if (Math.random() < 0.05) return null; // null means end of event stream
        SensorEventType sensorEventType = SensorEventType.values()[(int) (4 * Math.random())];
        String objectId = "" + ((int) (10 * Math.random()));
        return new SensorEvent(sensorEventType, objectId);
    }
}
