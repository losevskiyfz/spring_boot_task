package com.losevskiyfz.springboottask.bean;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Lazy // Should not work because prototype beans are lazy be default
@Scope("prototype")
public class PrototypeComponent {

    public PrototypeComponent() {
        System.out.println("Call constructor of PrototypeComponent class");
    }

    @PostConstruct
    public void init(){
        System.out.println("Call @PostConstruct method in PrototypeComponent class");
    }

    // Should not work because prototype beans aren't managed by ApplicatonContext after their creation.
    @PreDestroy
    public void destroy(){
        System.out.println("Call @PreDestroy method in PrototypeComponent class");
    }

}
