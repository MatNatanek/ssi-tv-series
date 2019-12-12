package com.wieik.ssitvseries.model;


import com.wieik.ssitvseries.entity.EpisodeEntity;
import com.wieik.ssitvseries.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse implements Serializable {
    private static final long serialVersionUID = 6041747576205423926L;

    private String jwt;
    private Integer expirationTime;

    private Integer idUser;

    private String firstName;

    private String lastName;

    private String login;

    private String password;

    String role;

    private Set<UserEntity> friendsSet = new HashSet<UserEntity>();

    private Set<EpisodeEntity> watchedEpisodes = new HashSet<>();

}
