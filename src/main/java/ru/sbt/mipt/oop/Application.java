package ru.sbt.mipt.oop;

import java.io.IOException;
import java.util.Collection;
import java.util.ArrayList;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class Application {

    private final EventMathRandomGetter eventMathRandomGetter = new EventMathRandomGetter();

    public static void main(String... args) throws IOException {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(MyConfiguration.class);
        EventManager eventsManager = context.getBean(EventManager.class);
        HomeReader homeReader = context.getBean(HomeReader.class);
        eventsManager.start();
    }
}
