package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class Rest {

    @Autowired
    MyService myService;

    @RequestMapping("/{name}")
    public String index(@PathVariable String name) {
        return myService.sendMessage(name);
    }

}
