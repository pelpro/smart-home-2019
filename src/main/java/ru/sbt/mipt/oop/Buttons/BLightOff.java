package ru.sbt.mipt.oop.Buttons;

import ru.sbt.mipt.oop.Light;
import ru.sbt.mipt.oop.SmartHome;

public class BLightOff implements Buttons {
    final private SmartHome smartHome;

    public BLightOff(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void execute() {
        smartHome.execute(object -> {
            if (object instanceof Light) {
                ((Light) object).setOn(false);
            }
        });
    }
}

