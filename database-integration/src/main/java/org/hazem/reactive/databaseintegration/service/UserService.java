package org.hazem.reactive.databaseintegration.service;

import lombok.RequiredArgsConstructor;
import org.hazem.reactive.databaseintegration.dto.AddUserDto;
import org.hazem.reactive.databaseintegration.dto.UpdateUserDto;
import org.hazem.reactive.databaseintegration.mapper.UserMapper;
import org.hazem.reactive.databaseintegration.repository.UserRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    public Mono<AddUserDto> AddUser(AddUserDto addUserDto) {
        return userRepository.findByEmail(addUserDto.getEmail())
                .flatMap((userEntity) -> {
                    if (userEntity != null) {
                        return Mono.error(new RuntimeException("User already exists"));
                    } else {
                        return userRepository.save(UserMapper.toUserEntity(addUserDto))
                                .map(UserMapper::toAddUserDto);
                    }
                });
    }
    public Mono<AddUserDto> getUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .map(UserMapper::toAddUserDto);
    }
    public Mono<AddUserDto> getUserById(Integer id) {
        return userRepository.findById(id)
                .map(UserMapper::toAddUserDto);
    }
    public Mono<List<AddUserDto>> getAllUsers() {
        return userRepository.findAll().collectList()
                .map(users ->
                        users.stream()
                        .map(UserMapper::toAddUserDto).toList());
    }
    public Mono<Void> deleteUserById(Integer id) {
        return userRepository.deleteById(id);
    }
    public Mono<UpdateUserDto> updateUser(UpdateUserDto addUserDto) {
        return userRepository.findByEmail(addUserDto.getEmail())
                .flatMap(userEntity -> {
                    if (userEntity == null) {
                        return Mono.error(new RuntimeException("User not found"));
                    } else {
                        return userRepository.save(UserMapper.toUserEntity(addUserDto))
                                .map(UserMapper::toUpdateUserDto);
                    }
                });
    }


}
