package ru.sbt.mipt.oop;

import com.google.gson.Gson;

import java.nio.file.Files;
import java.nio.file.Paths;

public class GsonHomeReader implements HomeReader {
    private String filename;

    public GsonHomeReader(String filename) {
        this.filename = filename;
    }

    @Override
    public SmartHome readSmartHome() {
        Gson gson = new Gson();
        try {
            String json = new String(Files.readAllBytes(Paths.get(filename)));
            return gson.fromJson(json, SmartHome.class);
        } catch (Exception ex) {

        }
        return null;
    }
}