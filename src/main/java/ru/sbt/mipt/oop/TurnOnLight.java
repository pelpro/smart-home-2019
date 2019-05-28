package ru.sbt.mipt.oop;


public class TurnOnLight implements Action<Light> {
    String light_id;
    String room;

    public TurnOnLight(String light_id) {
        this.light_id = light_id;
        this.room = "";
    }

    @Override
    public String get_room_name() {
        return room;
    }

    @Override
    public String get_type_name() {
        return "light_type";
    }

    @Override
    public void launchAction(Light object, String room_name) {
        if (light_id.equals(object.getId())) {
            room = room_name;
            object.setOn(true);
            System.out.println("Light " + object.getId() + " in room " + room_name + " was turned on.");
        }
    }
}
