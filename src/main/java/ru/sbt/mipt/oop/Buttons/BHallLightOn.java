package ru.sbt.mipt.oop.Buttons;

import ru.sbt.mipt.oop.Light;
import ru.sbt.mipt.oop.Room;
import ru.sbt.mipt.oop.SmartHome;

public class BHallLightOn implements Buttons {
    final private SmartHome smartHome;

    public BHallLightOn(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void execute() {
        for (Room room : smartHome.getRooms()) {
            if (room.getName().equals("hall")) {
                room.execute(objectLight -> {
                    if (objectLight instanceof Light) {
                        ((Light) objectLight).setOn(true);
                    }
                });
            }
        }
    }
}
