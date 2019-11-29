package com.wieik.ssitvseries.entity;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "users", schema = "public")
public class UserEntity implements Serializable {

    private static final long serialVersionUID = 4963989636578192356L;

    @Id
    @SequenceGenerator(name = "users_id_user_seq", sequenceName = "users_id_user_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_id_user_seq")
    @Column(name = "id_user")
    private Integer idUser;

    @Column(name = "last_name")
    private String lastName;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "friendship",
            joinColumns = {@JoinColumn(name = "id_user")},
            inverseJoinColumns = {@JoinColumn(name = "id_friend")})
    private Set<UserEntity> usersSet = new HashSet<UserEntity>();

    @ManyToMany(mappedBy = "usersSet")
    private Set<UserEntity> friendsSet = new HashSet<UserEntity>();


}
