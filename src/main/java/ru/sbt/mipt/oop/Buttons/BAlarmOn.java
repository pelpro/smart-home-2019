package ru.sbt.mipt.oop.Buttons;

import ru.sbt.mipt.oop.SmartHome;

public class BAlarmOn implements Buttons {
    final private SmartHome smartHome;
    final private String password;

    BAlarmOn(SmartHome smartHome, String password) {
        this.smartHome = smartHome;
        this.password = password;
    }

    @Override
    public void execute() {
        smartHome.getAlarm().activate(password);
    }
}
}
