package org.hazem.reactive.databaseintegration.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hazem.reactive.databaseintegration.dto.reponse.AddUserDto;
import org.hazem.reactive.databaseintegration.dto.reponse.UpdateUserDto;
import org.hazem.reactive.databaseintegration.entity.UserEntity;
import org.hazem.reactive.databaseintegration.exeptions.ConflictExeception;
import org.hazem.reactive.databaseintegration.exeptions.DataAccessException;
import org.hazem.reactive.databaseintegration.exeptions.RessourceNotFoundExeception;
import org.hazem.reactive.databaseintegration.mapper.UserMapper;
import org.hazem.reactive.databaseintegration.repository.UserRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService implements IUserService {
    private final UserRepository userRepository;
    @Override
    public Mono<UpdateUserDto> addUser(AddUserDto addUserDto) {
        return userRepository.findByEmail(addUserDto.getEmail())
                        .flatMap(userEntity -> Mono.<UserEntity>error(new ConflictExeception("User already exists")))
                    .switchIfEmpty(userRepository.save(UserMapper.toUserEntity(addUserDto)))
                    .map(UserMapper::toUpdateUserDto)
                .onErrorMap(err->!(err instanceof ConflictExeception),
                        err -> new DataAccessException("Error while adding user"))
                .doOnSuccess(result -> log.info("User added with email {}",addUserDto.getEmail()))
                .doOnError(err -> log.error("Error while adding user", err));

    }
    @Override
    public Mono<UpdateUserDto> getUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .switchIfEmpty(Mono.<UserEntity>error(new RessourceNotFoundExeception("User not found")))
                .map(UserMapper::toUpdateUserDto)
                .onErrorMap(err->!(err instanceof RessourceNotFoundExeception),
                        err -> new DataAccessException("Error while getting user with email "+email))
                .doOnSuccess(result -> log.info("User found with email {}",email))
                .doOnError(err -> log.error("Error getting user with email {}",email,err));
    }
    @Override
    public Mono<UpdateUserDto> getUserById(Integer id) {
        return userRepository.findById(id)
                .map(UserMapper::toUpdateUserDto)
                .switchIfEmpty(Mono.<UpdateUserDto>error(new RessourceNotFoundExeception("User not found")))
                .onErrorMap(err->!(err instanceof RessourceNotFoundExeception),
                        err -> new DataAccessException("Error while getting user with id "
                                +id))
                .doOnSuccess(result -> log.info("User found with id {}",id))
                .doOnError(err -> log.error("Error getting user with id {}",id,err));


    }
    @Override
    public Mono<List<UpdateUserDto>> getAllUsers() {
        return userRepository.findAll().collectList()
                .map(users ->
                        users.stream()
                        .map(UserMapper::toUpdateUserDto).toList())
                .onErrorMap(err -> new DataAccessException("Error while getting all users"));
    }
    @Override
    public Mono<Void> deleteUserById(Integer id) {
        return userRepository.findById(id)
                .switchIfEmpty(Mono.<UserEntity>error(new RessourceNotFoundExeception("User not found")))
                .flatMap(user -> userRepository.deleteById(id))
                .doOnSuccess((t)-> log.info("User deleted with id {}",id))
                .doOnError(err -> log.error("Error deleting user with id {}",id,err))
                .onErrorMap(err->!(err instanceof RessourceNotFoundExeception),
                        (err) ->
                                new DataAccessException("Error while deleting user with id "
                                        +id +"\n the error is "
                                        +err.getMessage()));


    }
    @Override
    public Mono<UpdateUserDto> updateUser(UpdateUserDto addUserDto) {
        return userRepository.findByEmail(addUserDto.getEmail())
                .flatMap(userEntity ->
                     userRepository.save(UserMapper.toUserEntity(addUserDto))
                                .map(UserMapper::toUpdateUserDto)
                ).switchIfEmpty(Mono.<UpdateUserDto>error(new RessourceNotFoundExeception("User not found")))
                .doOnSuccess((t)-> log.info("User updated with id {}",addUserDto.getId()))
                .onErrorMap((err)->!(err instanceof RessourceNotFoundExeception),
                        (err) ->
                                new DataAccessException("Error while updating user with id "
                                        +addUserDto.getId()+
                                        "\n the error is "
                                        +err.getMessage()))
                .doOnError(err -> log.error("Error updating user with id {}",addUserDto.getId(),err))
                .doOnSuccess((result)-> log.debug("User updated with id {}",addUserDto.getId()));

    }


}
