package org.hazem.reactive.databaseintegration.mapper;

import org.hazem.reactive.databaseintegration.dto.AddUserDto;
import org.hazem.reactive.databaseintegration.dto.UpdateUserDto;
import org.hazem.reactive.databaseintegration.entity.UserEntity;

public class UserMapper {
    public static AddUserDto toAddUserDto(UserEntity userEntity) {
        AddUserDto addUserDto = new AddUserDto();
        addUserDto.setName(userEntity.getName());
        addUserDto.setEmail(userEntity.getEmail());
        addUserDto.setPassword(userEntity.getPassword());
        addUserDto.setPhone(userEntity.getPhone());
        addUserDto.setAddress(userEntity.getAddress());
        addUserDto.setAge(userEntity.getAge());
        return addUserDto;
    }
    public static UserEntity toUserEntity(AddUserDto addUserDto) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(addUserDto.getName());
        userEntity.setEmail(addUserDto.getEmail());
        userEntity.setPassword(addUserDto.getPassword());
        userEntity.setPhone(addUserDto.getPhone());
        userEntity.setAddress(addUserDto.getAddress());
        userEntity.setAge(addUserDto.getAge());
        return userEntity;
    }
    public static UserEntity toUserEntity(UpdateUserDto updateUserDto) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(updateUserDto.getId());
        userEntity.setName(updateUserDto.getName());
        userEntity.setEmail(updateUserDto.getEmail());
        userEntity.setPassword(updateUserDto.getPassword());
        userEntity.setPhone(updateUserDto.getPhone());
        userEntity.setAddress(updateUserDto.getAddress());
        userEntity.setAge(updateUserDto.getAge());
        return userEntity;
    }
    public static UpdateUserDto toUpdateUserDto(UserEntity userEntity) {
        UpdateUserDto updateUserDto = new UpdateUserDto();
        updateUserDto.setId(userEntity.getId());
        updateUserDto.setName(userEntity.getName());
        updateUserDto.setEmail(userEntity.getEmail());
        updateUserDto.setPassword(userEntity.getPassword());
        updateUserDto.setPhone(userEntity.getPhone());
        updateUserDto.setAddress(userEntity.getAddress());
        updateUserDto.setAge(userEntity.getAge());
        return updateUserDto;
    }
}
