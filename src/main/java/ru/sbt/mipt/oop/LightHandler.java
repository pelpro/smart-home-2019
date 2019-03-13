package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.*;

public class LightHandler implements EventHandler {
    public void handleEvent(SmartHome smartHome, SensorEvent sensorevent) {
        if (sensorevent.getType() == LIGHT_ON) {
            Action<Light> light_turning_on_action = new TurnOnLight(sensorevent.getObjectId());
            smartHome.execute(light_turning_on_action);
        } else if (sensorevent.getType() == LIGHT_OFF) {
            Action<Light> light_turning_off_action = new TurnOffLight(sensorevent.getObjectId());
            smartHome.execute(light_turning_off_action);
        }
    }
}