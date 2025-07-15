package org.hazem.reactive.databaseintegration.controller;

import lombok.RequiredArgsConstructor;
import org.hazem.reactive.databaseintegration.dto.AddUserDto;
import org.hazem.reactive.databaseintegration.dto.UpdateUserDto;
import org.hazem.reactive.databaseintegration.service.UserService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @PostMapping
    public Mono<AddUserDto> createUser(@RequestBody AddUserDto addUserDto) {
        return userService.AddUser(addUserDto);
    }
    @GetMapping("/email/{email}")
    public Mono<AddUserDto> getUserByEmail(@PathVariable String email) {
        return userService.getUserByEmail(email);
    }
    @GetMapping("/{id}")
    public Mono<AddUserDto> getUserById(@PathVariable Integer id) {
        return userService.getUserById(id);
    }
    @GetMapping
    public Mono<List<AddUserDto>> getAllUsers() {
        return userService.getAllUsers();
    }
    @DeleteMapping("/{id}")
    public Mono<Void> deleteUserById(@PathVariable Integer id) {
        return userService.deleteUserById(id);
    }
    @PutMapping
    public Mono<UpdateUserDto> updateUser(@RequestBody UpdateUserDto addUserDto) {
        return userService.updateUser(addUserDto);
    }
}
