package web.spring313v2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import web.spring313v2.dto.UserDto;
import web.spring313v2.dto.UserMapper;
import web.spring313v2.model.User;
import web.spring313v2.service.UserService;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class AdminRESTController {

    private final UserService userService;

    @Autowired
    public AdminRESTController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public ResponseEntity<UserDto> getCurrentUser(Authentication authentication) {
        return ResponseEntity.ok().body(UserMapper.toDto(userService.getUserByLogin(authentication.getName()).get()));
    }

    @GetMapping("/admin")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return ResponseEntity.ok().body(UserMapper.toDto(userService.getAllUsers()));
    }

    @GetMapping("/admin/users/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(UserMapper.toDto(userService.getUserById(id).get()));
    }

    @PostMapping("/admin/create")
    public ResponseEntity<UserDto> createNewUser(@RequestBody UserDto userDto) {
        User user = UserMapper.toModel(userDto);
        user.setPasswordReal(user.getPassword());
        userService.createNewUser(user);
        return ResponseEntity.ok().body(UserMapper.toDto(user));
    }

    @PutMapping("/admin/update")
    public ResponseEntity<UserDto> editUser(@RequestBody UserDto userDto) {
        User user = UserMapper.toModel(userDto);
        userService.editUser(user);
        return ResponseEntity.ok().body(UserMapper.toDto(user));
    }

    @DeleteMapping("/admin/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id) {
        userService.deleteUserById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

