package org.hazem.reactive.databaseintegration.service;

import org.hazem.reactive.databaseintegration.dto.request.AddUserDto;
import org.hazem.reactive.databaseintegration.dto.request.UpdateUserDto;
import reactor.core.publisher.Mono;

import java.util.List;

public interface IUserService {
    Mono<UpdateUserDto> addUser(AddUserDto addUserDto);

    Mono<UpdateUserDto> getUserByEmail(String email);

    Mono<UpdateUserDto> getUserById(Integer id);

    Mono<List<UpdateUserDto>> getAllUsers();

    Mono<Void> deleteUserById(Integer id);

    Mono<UpdateUserDto> updateUser(UpdateUserDto addUserDto);
}
