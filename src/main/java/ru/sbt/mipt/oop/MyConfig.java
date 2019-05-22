package ru.sbt.mipt.oop;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;

import java.util.ArrayList;
import java.util.Collection;


@Configuration
public class MyConfig {
    private SmartHome smartHome;
    private EventsManager eventsManager;
    public MyConfig(){
    }

    @Bean
    public EventManager eventManager() {
        Observer observer = configureSimpleObserver();
        return new EventManagerAdapter(observer);
    }

    @Bean
    public HomeReader homeReader(String path){
        return new GsonHomeReader(path);
    }

    private static Observer configureSimpleObserver() {
        Observer observer = new HEventObserver();
        observer.sub(configureEventHandlers());
        return observer;
    }

    private static Collection<EventHandler> configureEventHandlers() {
        Collection<EventHandler> eventProcessors = new ArrayList<>();
        eventProcessors.add(new LightHandler());
        eventProcessors.add(new DoorHandler());
        eventProcessors.add(new HallDoorHandler());
        return eventProcessors;
    }
}