package ru.sbt.mipt.oop.Buttons;

import ru.sbt.mipt.oop.Door;
import ru.sbt.mipt.oop.Room;
import ru.sbt.mipt.oop.SmartHome;

public class BCloseHallDoor implements Buttons{
    final private SmartHome smartHome;

    BCloseHallDoor(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void execute() {
        for (Room room : smartHome.getRooms()) {
            if (room.getName().equals("hall")) {
                room.execute(objectDoor -> {
                    if (objectDoor instanceof Door) {
                        ((Door) objectDoor).setOpen(false);
                    }
                });
            }
        }
    }
}

