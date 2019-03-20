package ru.sbt.mipt.oop.alarm;

public class AlarmAlert implements AlarmState {
    private AlarmState state;

    @Override
    public void activate(String password) {
        System.out.println("Pik-pik-pik wiu-wiu-wiu");
    }

    @Override
    public void deactivate(String password) {
        if (password == "CorrectPassword"){
            setState(new AlarmDeactivate());
            System.out.println("Deactivated");
        }
    }

    @Override
    public void alert() {
        System.out.println("Pik-pik-pik wiu-wiu-wiu");
    }

    private void setState(AlarmState state) {
        this.state = state;
    }

    public AlarmState getState() {
        return state;
    }
}
