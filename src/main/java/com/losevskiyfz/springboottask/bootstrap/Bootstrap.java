package com.losevskiyfz.springboottask.bootstrap;

import com.losevskiyfz.springboottask.bean.Prototype;
import com.losevskiyfz.springboottask.bean.PrototypeComponent;
import com.losevskiyfz.springboottask.bean.Singleton;
import com.losevskiyfz.springboottask.bean.SingletonComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.event.*;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {

    private final Prototype prototype1;

    private final Prototype prototype2;

    private final PrototypeComponent prototypeComponent;

    private final Singleton singleton;

    // It creates unneeded coupling, but it's study project to just see possibilities of Spring Boot
    // and I decided It's OK. I don't know another way to call events manually
    private final ConfigurableApplicationContext applicationContext;

    @EventListener
    public void handleContextRefreshEvent(ContextStartedEvent contextRefreshedEvent){
        System.out.println("Context Started Event is called");
    }

    @EventListener(classes = { ContextRefreshedEvent.class, ContextClosedEvent.class })
    public void handleMultipleEvents() {
        System.out.println("Context Refreshed or Context Stopped Event is invoked");
    }

    @Autowired
    public Bootstrap(Prototype prototype1, Prototype prototype2, PrototypeComponent prototypeComponent, Singleton singleton, ConfigurableApplicationContext applicationContext) {
        this.prototype1 = prototype1;
        this.prototype2 = prototype2;
        this.prototypeComponent = prototypeComponent;
        this.singleton = singleton;
        this.applicationContext = applicationContext;
    }

    @Override
    public void run(String... args){
        applicationContext.getBean(SingletonComponent.class);
        applicationContext.start();
        applicationContext.stop();
    }

}
