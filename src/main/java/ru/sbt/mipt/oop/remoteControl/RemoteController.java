package ru.sbt.mipt.oop.remoteControl;

import ru.sbt.mipt.oop.Buttons.Buttons;

import java.util.HashMap;

public class RemoteController implements RemoteControl {
    final private String rcID;
    final private HashMap<String, Buttons> buttons = new HashMap<>();

    public RemoteController(String rcID) {
        this.rcID = rcID;
    }

    public void pushMap(String buttonCode, Buttons button) {
        char buttonCharCode = buttonCode.charAt(0);
        buttons.put(buttonCode, button);
    }

    @Override
    public void onButtonPressed(String buttonCode) {
        Buttons button = buttons.get(buttonCode);
        if (button != null) {
            button.execute();
        }
    }
}
