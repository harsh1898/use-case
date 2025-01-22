package com.harshit.backend.controller;

import com.harshit.backend.request.RoleBasedRequest;
import com.harshit.backend.request.UserById;
import com.harshit.backend.response.ResponsePayload;
import com.harshit.backend.serviceimpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    UserServiceImpl userService;


    @GetMapping("/getAllUser")
    private List<ResponsePayload> callAvailableUsers() throws IOException {
            return userService.getAllUsers();
    }

    @PostMapping("/getRoleBasedUsers")
    private List<ResponsePayload> callRoleBasedUsers(@RequestBody RoleBasedRequest role) {
        return userService.getRoleBasedUsers(role);
    }

    @GetMapping("/sortedUsers")
    private List<ResponsePayload> callSortedUsers() {
        return userService.getSortedUsers();
    }

    @PostMapping("/userById")
    private ResponsePayload callUserById(@RequestBody UserById id) {
        return userService.getUserById(id);
    }
}
