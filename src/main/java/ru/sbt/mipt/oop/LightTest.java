package ru.sbt.mipt.oop;

import java.io.IOException;
import org.junit.Assert;
import org.junit.Test;

public class LightTest {

    @Test
    public void turnOffBathroomLight() throws IOException {
        HomeReader homereader = new GsonHomeReader("smart-home-1.js");
        SmartHome smarthome = homereader.readSmartHome();
        SensorEvent event = new SensorEvent(SensorEventType.LIGHT_OFF, "3");
        LightHandler handler = new LightHandler();
        handler.handleEvent(smarthome, event);
        for(Room room: smarthome.getRooms()) {
            String test_room = room.getName();
            if(test_room.equals("bathroom")) {
                for(Light light: room.getLights()) {
                    String light_id = light.getId();
                    if(light_id.equals("3")) {
                        Assert.assertFalse(light.isOn());
                    }
                }
            }
        }
    }

    @Test
    public void turnOnKitchenLight() throws IOException {
        HomeReader homereader = new GsonHomeReader("smart-home-1.js");
        SmartHome smarthome = homereader.readSmartHome();
        SensorEvent event = new SensorEvent(SensorEventType.LIGHT_ON, "1");
        LightHandler handler = new LightHandler();
        handler.handleEvent(smarthome, event);
        for(Room room: smarthome.getRooms()) {
            String test_room = room.getName();
            if(test_room.equals("kitchen")) {
                for(Light light: room.getLights()) {
                    String light_id = light.getId();
                    if(light_id.equals("1")) {
                        Assert.assertTrue(light.isOn());
                    }
                }
            }
        }
    }

}