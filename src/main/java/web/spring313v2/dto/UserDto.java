package web.spring313v2.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import web.spring313v2.model.Role;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {

    private Long id;
    private String name;
    private String lastname;
    private int age;
    private String login;
    private String password;
    private String passwordReal;
    private Set<Role> roles;

}
