package com.example;

import org.apache.camel.Consume;
import org.springframework.stereotype.Component;

@Component
public class Cons {

    @Consume(uri = "jms:somepath")
    public String onSayMessage(String name) {
        return "Hello " + name;
    }

}
