package core.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import core.model.User;

@Controller
public class AuthController {
    
    @PostMapping(path = "/auth/login", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<User> login(@RequestParam(name = "email") String email, @RequestParam(name = "name") String name) {
        User user = new User(email, name);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    
}
