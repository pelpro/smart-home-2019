package ru.sbt.mipt.oop;


public class OpenDoor implements Action<Door> {
    String door_id;
    String room;

    public OpenDoor(String door_id) {
        this.door_id = door_id;
        this.room = "";
    }

    @Override
    public String get_room_name() {
        return room;
    }

    @Override
    public String get_type_name() {
        return "door_type";
    }

    @Override
    public void launchAction(Door object, String room_name) {
        if (door_id.equals(object.getId())) {
            room = room_name;
            object.setOpen(true);
            System.out.println("Door " + object.getId() + " in room " + room_name + " was opened.");
        }
    }
}
