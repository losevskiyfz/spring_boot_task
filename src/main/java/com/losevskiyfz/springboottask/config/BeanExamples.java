package com.losevskiyfz.springboottask.config;

import com.losevskiyfz.springboottask.bean.Prototype;
import com.losevskiyfz.springboottask.bean.Singleton;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BeanExamples {

    @Bean
    @Scope("singleton") //Optional
    public Singleton singleton(){
        return new Singleton();
    }

    @Bean
    @Scope("prototype")
    public Prototype prototype(){
        return new Prototype();
    }

}
