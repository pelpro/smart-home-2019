package ru.sbt.mipt.oop;

import com.coolcompany.smarthome.events.CCSensorEvent;
import ru.sbt.mipt.oop.SensorEventType;
import ru.sbt.mipt.oop.event.SensorEvent;

import static ru.sbt.mipt.oop.SensorEventType.*;


public class SensorEventAdapter extends SensorEvent{
    CCSensorEvent ccEvent;
    SensorEventAdapter(CCSensorEvent ccEvent){
        this.ccEvent = ccEvent;
    }

    private getType(String event){
        switch(event){
            case ("LightIsOn"):
                return SensorEventType.LIGHT_ON;
            case ("LightIsOff"):
                return SensorEventType.LIGHT_OFF;
            case("DoorIsOpen"):
                return SensorEventType.DOOR_OPEN;
            case("DoorIsClosed"):
                return SensorEventType.DOOR_CLOSED;
            case("DoorIsLocked"):
                return null;
            case("DoorIsUnlocked"):
                return null;
            default:
                return null;
        }
    }
    public SensorEvent getSensorEvent() {
        SensorEventType sensorEventType = getType(ccEvent.getEventType());
        SensorEvent sensorEvent = new SensorEvent(sensorEventType, ccEvent.getObjectId());
        return sensorEvent;
    }
}
