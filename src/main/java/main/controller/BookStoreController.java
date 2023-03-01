package main.controller;

import org.springframework.web.bind.annotation.*;
import main.model.Credentials;

@RestController
public class BookStoreController {


    @PostMapping("/new_user")
    public void newUser(@RequestBody Credentials credentials){
        //TODO implement account creation in backend
        System.out.println(credentials.getUsername());
        System.out.println(credentials.getPassword());
    }

    @PostMapping("/verify_login")
    public void verifyLogin(@RequestBody Credentials credentials){
        //TODO implement account creation in backend
        System.out.println(credentials.getUsername());
        System.out.println(credentials.getPassword());
    }
}
