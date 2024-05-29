package com.losevskiyfz.springboottask.bean;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class Prototype {

    public Prototype() {
        System.out.println("Call constructor of Prototype class");
    }

    @PostConstruct
    public void init(){
        System.out.println("Call @PostConstruct method in Prototype class");
    }

    // Should not work because prototype beans aren't managed by ApplicatonContext after their creation.
    @PreDestroy
    public void destroy(){
        System.out.println("Call @PreDestroy method in Prototype class");
    }

}
