package com.losevskiyfz.springboottask.bean;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class Singleton {

    public Singleton() {
        System.out.println("Call constructor of Singleton class");
    }

    @PostConstruct
    public void init(){
        System.out.println("Call @PostConstruct method in Singleton class");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("Call @PreDestroy method in Singleton class");
    }

}
