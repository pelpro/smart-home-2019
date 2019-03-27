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
    public void setState(AlarmState state) {
        this.state.setState(new AlarmAlert());
    }

    @Override
    public void alert() {
        System.out.println("Pik-pik-pik wiu-wiu-wiu");
    }


    public AlarmState getState() {
        return state;
    }
}
