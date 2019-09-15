package com.marocrafts.cucumber.demo.user;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {


    public static UserDto mapToUserDto(@NotNull UserEntity userEntity){
        UserDto userDto = new UserDto();
        userDto.setFirstName(userEntity.getFirstName());
        userDto.setLastName(userEntity.getLastName());
        userDto.setEmail(userEntity.getEmail());
        userDto.setAge(userEntity.getAge());
        return userDto;
    }

    public static List<UserDto> mapToUsersDto(List<UserEntity> userEntities){
        return userEntities.stream().map(UserMapper::mapToUserDto).collect(Collectors.toList());
    }

    public static UserEntity mapToUserEntity(@NotNull UserDto userDto){
        UserEntity userEntity = new UserEntity();
        userEntity.setFirstName(userDto.getFirstName());
        userEntity.setLastName(userDto.getLastName());
        userEntity.setEmail(userDto.getEmail());
        userEntity.setAge(userDto.getAge());
        return userEntity;
    }
}
