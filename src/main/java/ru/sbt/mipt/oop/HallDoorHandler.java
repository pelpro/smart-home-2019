package ru.sbt.mipt.oop;

public class HallDoorHandler implements EventHandler {
    @Override
    public void handleEvent(SmartHome smarthome, SensorEvent sensorevent) {
        if (sensorevent.getType() == SensorEventType.DOOR_CLOSED) {
            Action<Door> doorClosingAction = new CloseDoor(sensorevent.getObjectId());
            smarthome.execute(doorClosingAction);
            if (doorClosingAction.get_room_name().equals("hall"))   {
                Action<Light> hallDoorClosingAction = new TurnOffLight("hadllclose");
                smarthome.execute(hallDoorClosingAction);
            }
        }
    }
}
