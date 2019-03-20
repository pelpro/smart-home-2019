package ru.sbt.mipt.oop.alarm;

public class AlarmActivate implements AlarmState {
    private AlarmState state;
    private String password;

    @Override
    public void activate(String password) {

    }

    @Override
    public void deactivate(String password) {
        if (this.password == password) {
            System.out.println("Deactivated!");
            setState(new AlarmDeactivate());
        } else {
            System.out.println("Wrong password!");
            setState(new AlarmAlert());
        }
    }

    @Override
    public void alert() {
        setState(new AlarmAlert());
        state.alert();
    }


    private void setState(AlarmState state) {
        this.state = state;
    }

    public AlarmState getState() {
        return state;
    }

}
