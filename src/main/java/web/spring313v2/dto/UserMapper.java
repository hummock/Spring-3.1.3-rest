package web.spring313v2.dto;

import web.spring313v2.model.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {

    private UserMapper() {}

    public static User toModel(UserDto dto) {
        User user = new User();
        user.setId(dto.getId());
        user.setName(dto.getName());
        user.setLastname(dto.getLastname());
        user.setAge(dto.getAge());
        user.setLogin(dto.getLogin());
        user.setPassword(dto.getPassword());
        user.setPasswordReal(dto.getPasswordReal());
        user.setRoles(dto.getRoles());
        return user;
    }

    public static List<UserDto> toDto(List<User> userList) {
        return userList.stream().map(UserMapper::toDto).collect(Collectors.toList());
    }

    public static UserDto toDto(User user) {
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setLastname(user.getLastname());
        dto.setAge(user.getAge());
        dto.setLogin(user.getLogin());
        dto.setPassword(user.getPassword());
        dto.setPasswordReal(user.getPasswordReal());
        dto.setRoles(user.getRoles());
        return dto;
    }
}
