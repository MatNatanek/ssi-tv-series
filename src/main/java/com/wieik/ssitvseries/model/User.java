package com.wieik.ssitvseries.model;

import com.wieik.ssitvseries.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String lastName;
    private String firstName;
    private String login;
    private String password;
    private String role;
}
