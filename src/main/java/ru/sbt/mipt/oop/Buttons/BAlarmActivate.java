package ru.sbt.mipt.oop.Buttons;

import ru.sbt.mipt.oop.SmartHome;

public class BAlarmActivate implements Buttons{
    final private SmartHome smartHome;

    public BAlarmActivate(SmartHome smartHome) {
        this.smartHome = smartHome;
    }


    @Override
    public void execute() {
        smartHome.getAlarm().alert();
    }
}

}
