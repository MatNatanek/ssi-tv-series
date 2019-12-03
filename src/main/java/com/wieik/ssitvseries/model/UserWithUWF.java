package com.wieik.ssitvseries.model;

import com.wieik.ssitvseries.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserWithUWF implements Serializable {

    private Integer idUser;
    private String lastName;
    private String firstName;
    private String login;
    private String password;
    private Role role;

    private Set<UserWithoutFriends> friendsSet = new HashSet<>();

}
