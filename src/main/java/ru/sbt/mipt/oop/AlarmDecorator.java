package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.alarm.Alarm;
import ru.sbt.mipt.oop.alarm.AlarmActivate;
import ru.sbt.mipt.oop.alarm.AlarmAlert;

public class AlarmDecorator implements EventHandler {
    private EventHandler eventHandler;
    private Alarm alarm;

    public AlarmDecorator(EventHandler eventHandler, Alarm alarm) {
        this.eventHandler = eventHandler;
        this.alarm = alarm;
    }

    @Override
    public void handleEvent(SmartHome smarthome, SensorEvent sensorevent) {
        if (smarthome.getAlarm().getState() instanceof AlarmActivate) {
            System.out.println("sms");
            return;
        }
        if (smarthome.getAlarm().getState() instanceof AlarmAlert) {
            System.out.println("sms");
            return;
        }
        eventHandler.handleEvent(smarthome,sensorevent);
    }
    }
}
