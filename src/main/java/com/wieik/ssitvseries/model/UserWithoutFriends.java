package com.wieik.ssitvseries.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserWithoutFriends implements Serializable {

    private static final long serialVersionUID = 9041800485378385391L;

    private Integer idUser;

    private String lastName;
}
