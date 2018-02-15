package br.com.spring.Spring.endPoint;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/hello")
public class Hello {
    @RequestMapping(method = RequestMethod.GET)
    public String hello(){
        return "Hello";
    }

}
