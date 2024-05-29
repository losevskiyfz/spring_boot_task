package com.losevskiyfz.springboottask.bean;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Lazy
@Component
@Scope("singleton") //Optional
public class SingletonComponent {

    public SingletonComponent() {
        System.out.println("Call constructor of SingletonComponent class");
    }

    @PostConstruct
    public void init(){
        System.out.println("Call @PostConstruct method in SingletonComponent class");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("Call @PreDestroy method in SingletonComponent class");
    }

}
