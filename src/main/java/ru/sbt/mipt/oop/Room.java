package ru.sbt.mipt.oop;

import java.util.Collection;

public class Room implements Actionable {
    private Collection<Light> lights;
    private Collection<Door> doors;
    private String name;

    public Room(Collection<Light> lights, Collection<Door> doors, String name) {
        this.lights = lights;
        this.doors = doors;
        this.name = name;
    }

    public Collection<Light> getLights() {
        return lights;
    }

    public Collection<Door> getDoors() {
        return doors;
    }

    public String getName() {
        return name;
    }

    @Override
    public void execute(Action action) {
        if (action.get_type_name().equals("light_type")) {
            for (Light light : lights) {
                action.launchAction(light, name);
            }
        } else if (action.get_type_name().equals("door_type")) {
            for (Door door : doors) {
                action.launchAction(door, name);
            }
        }
    }
}
