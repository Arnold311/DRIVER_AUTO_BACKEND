package com.DriveAuto.adminservice.feign;

import com.DriveAuto.adminservice.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "user-service")
public interface UserServiceClient {

    @PostMapping("/api/s1/users/register")
    User registerUser(@RequestBody User user);

    @GetMapping("/api/s1/users")
    List<User> getAllUsers();

    @GetMapping("/api/s1/users/{id}")
    User getUserById(@PathVariable Long id);

    @DeleteMapping("/api/s1/users/{id}")
    void deleteUser(@PathVariable Long id);
}