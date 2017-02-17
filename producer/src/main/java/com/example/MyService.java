package com.example;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.apache.camel.Produce;
import org.springframework.stereotype.Service;

interface MyListener {
    String sayHello(String name);
}

@Service
public class MyService {

    @Produce(uri = "jms:somepath")
    MyListener myListener;

    @HystrixCommand(fallbackMethod = "sendMessageFallback")
    public String sendMessage(String name) {
        String response = myListener.sayHello(name);
        return response;
    }

    public String sendMessageFallback(String name) {
        return "Hello fallback";
    }

}
