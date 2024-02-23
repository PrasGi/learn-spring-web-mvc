package core.service;

import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {

    @Override
    public String hello(String name) {
        String result = "hello " + (name == null ? "guest" : name);
        return result;
    }
    
}
