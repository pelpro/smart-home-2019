package ru.sbt.mipt.oop.alarm;

public class AlarmDeactivate implements AlarmState {
    private AlarmState state;
    private String password;

    @Override
    public void activate(String password) {
        setState(new AlarmActivate());
        System.out.println("Activated!");

    }

    @Override
    public void deactivate(String password) {
    }

    @Override
    public void setState(AlarmState state) {
        this.state.setState(new AlarmAlert());
    }

    @Override
    public void alert() {
        setState(new AlarmAlert());
        state.alert();
    }


    public AlarmState getState() {
        return state;
    }

}
