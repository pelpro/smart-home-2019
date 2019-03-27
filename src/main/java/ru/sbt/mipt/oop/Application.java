package ru.sbt.mipt.oop;

import java.io.IOException;
import java.util.Collection;
import java.util.ArrayList;

public class Application {

    private final EventMathRandomGetter eventMathRandomGetter = new EventMathRandomGetter();

    public static void main(String... args) throws IOException {
        // считываем состояние дома из файла
        GsonHomeReader reader = new GsonHomeReader("smart-home-1.js");
        EventMathRandomGetter eventMathRandomGetter = new EventMathRandomGetter();
        SmartHome smartHome = reader.readSmartHome();
        // начинаем цикл обработки событий
        SensorEvent event = eventMathRandomGetter.getNextSensorEvent();
        Collection<EventHandler> EventsCollection = new ArrayList<>();
        EventsCollection.add(new DoorHandler());
        EventsCollection.add(new LightHandler());
        EventsCollection.add(new HallDoorHandler());
        EventsCollection.add(new AlarmEventHandler());
        while (event != null) {
            System.out.println("Got event: " + event);
            for (EventHandler handler : EventsCollection) {
                handler.handleEvent(smartHome, event);
            }
            event = eventMathRandomGetter.getNextSensorEvent();
        }
    }
}
