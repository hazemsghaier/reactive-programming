package org.hazem.reactive.databaseintegration.controller;

import lombok.RequiredArgsConstructor;
import org.hazem.reactive.databaseintegration.dto.request.AddUserDto;
import org.hazem.reactive.databaseintegration.dto.request.UpdateUserDto;
import org.hazem.reactive.databaseintegration.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @PostMapping
    public Mono<ResponseEntity<UpdateUserDto>> createUser(@RequestBody AddUserDto addUserDto) {
        return userService.addUser(addUserDto).map(
                user -> ResponseEntity.status(HttpStatus.CREATED).body(user)
        );
    }
    @GetMapping("/email/{email}")
    public Mono<ResponseEntity<UpdateUserDto>> getUserByEmail(@PathVariable String email) {
        return userService.getUserByEmail(email).map(
                user -> ResponseEntity.ok().body(user) // return user
        );
    }
    @GetMapping("/{id}")
    public Mono<ResponseEntity<UpdateUserDto>> getUserById(@PathVariable Integer id) {
        return userService.getUserById(id).map(
                user -> ResponseEntity.ok().body(user)
        );
    }
    @GetMapping
    public Mono<ResponseEntity<List<UpdateUserDto>>> getAllUsers() {
        return userService.getAllUsers().map(
                users -> ResponseEntity.ok().body(users)
        );
    }
    @DeleteMapping("/{id}")
    public Mono<Void> deleteUserById(@PathVariable Integer id) {
        return userService.deleteUserById(id);
    }
    @PutMapping
    public Mono<ResponseEntity<UpdateUserDto>> updateUser(@RequestBody UpdateUserDto addUserDto) {
        return userService.updateUser(addUserDto).map(
                user -> ResponseEntity.ok().body(user)
        );
    }
}
