package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.*;

public class DoorHandler implements EventHandler {
    public void handleEvent(SmartHome smartHome, SensorEvent sensorevent) {
        if (sensorevent.getType() == DOOR_OPEN) {
            Action<Door> door_opening_action = new OpenDoor(sensorevent.getObjectId());
            smartHome.execute(door_opening_action);
        } else if (sensorevent.getType() == DOOR_CLOSED) {
            Action<Door> door_closing_action = new CloseDoor(sensorevent.getObjectId());
            smartHome.execute(door_closing_action);
        }
    }
}
