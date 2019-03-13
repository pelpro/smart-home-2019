package ru.sbt.mipt.oop;

import java.io.IOException;
import org.junit.Assert;
import org.junit.Test;
import static ru.sbt.mipt.oop.SensorEventType.DOOR_CLOSED;
import static ru.sbt.mipt.oop.SensorEventType.DOOR_OPEN;


public class DoorsTest {

    @Test
    public void closeHallDoor() throws IOException {
        HomeReader homereader = new GsonHomeReader("smart-home-1.js");
        SmartHome smarthome = homereader.readSmartHome();
        SensorEvent event = new SensorEvent(DOOR_CLOSED, "4");
        DoorHandler handler = new DoorHandler();
        handler.handleEvent(smarthome, event);
        for(Room room: smarthome.getRooms()) {
            String test_room = room.getName();
            if(test_room.equals("hall")) {
                for(Door door: room.getDoors()) {
                    String door_id = door.getId();
                    if(door_id.equals("4")) {
                        Assert.assertFalse(door.isOpen());
                    }
                }
            }
            for(Light light: room.getLights()) {
                Assert.assertFalse(light.isOn());
            }
        }
    }

    @Test
    public void closeBedroomDoor() throws IOException {
        HomeReader homereader = new GsonHomeReader("smart-home-1.js");
        SmartHome smarthome = homereader.readSmartHome();
        SensorEvent event = new SensorEvent(DOOR_CLOSED, "3");
        DoorHandler handler = new DoorHandler();
        handler.handleEvent(smarthome, event);
        for(Room room: smarthome.getRooms()) {
            String test_room = room.getName();
            if(test_room.equals("bedroom")) {
                for(Door door: room.getDoors()) {
                    String door_id = door.getId();
                    if(door_id.equals("3")) {
                        Assert.assertFalse(door.isOpen());
                    }
                }
            }
        }
    }

    @Test
    public void openKitchenDoor() throws IOException {
        HomeReader homereader = new GsonHomeReader("smart-home-1.js");
        SmartHome smarthome = homereader.readSmartHome();
        SensorEvent event = new SensorEvent(DOOR_OPEN, "1");
        DoorHandler handler = new DoorHandler();
        handler.handleEvent(smarthome, event);
        for(Room room: smarthome.getRooms()) {
            String test_room = room.getName();
            if(test_room.equals("kitchen")) {
                for(Door door: room.getDoors()) {
                    String door_id = door.getId();
                    if(door_id.equals("1")) {
                        Assert.assertTrue(door.isOpen());
                    }
                }
            }
        }
    }

}