package ru.sbt.mipt.oop.Buttons;

import ru.sbt.mipt.oop.Light;
import ru.sbt.mipt.oop.SmartHome;

public class BLightOn implements Buttons {
    final private SmartHome smartHome;

    public BLightOn(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void execute() {
        smartHome.execute(object -> {
            if (object instanceof Light) {
                ((Light) object).setOn(true);
            }
        });
    }
}

