package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.alarm.Alarm;
import ru.sbt.mipt.oop.alarm.AlarmTypeState;

public class AlarmEventHandler implements EventHandler {
    @Override
    public void handleEvent(SmartHome smarthome, SensorEvent sensorevent) {
        Alarm alarm = smarthome.getAlarm();
        if (sensorevent.getType() == SensorEventType.ALARM_ACTIVATE){
            alarm.activate(sensorevent.getObjectId());
        }
        if (sensorevent.getType() == SensorEventType.ALARM_DEACTIVATE){
            alarm.deactivate(sensorevent.getObjectId());

        }


    }
}
