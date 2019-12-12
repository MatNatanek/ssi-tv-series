package com.wieik.ssitvseries.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse implements Serializable {
    private static final long serialVersionUID = 6041747576205423926L;

    private String jwt;
    private Integer expirationTime;
    private String mail;

}
