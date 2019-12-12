package com.wieik.ssitvseries.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationRequest implements Serializable {

    private static final long serialVersionUID = 8759623537089115116L;

    private String mail;
    private String password;

}
