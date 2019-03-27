package ru.sbt.mipt.oop;


public class CloseDoor implements Action{
    private final SmartHome smartHome;

    public CloseDoor(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void launchAction() {
        for (Room room : smartHome.getRooms()) {
            for (Door door : room.getDoors()) {
                if (room.getName().equals("hall")) {
                    door.setOpen(true);
                }
            }
        }
    }
}
