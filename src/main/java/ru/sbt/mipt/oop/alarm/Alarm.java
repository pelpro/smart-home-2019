package ru.sbt.mipt.oop.alarm;
public class Alarm {
    private AlarmState state;
    private String password;

    public void alert(){
        state.alert();
        setState(state.getState());
    }

    public void activate(String password){
        state.activate(password);
        setState(state.getState());
    }
    public void deactivate(String password){
        state.deactivate(password);
        setState(state.getState());
    }

    void setState(AlarmState state){
        this.state = state;
    }

    public AlarmState getState() {
        return state;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

