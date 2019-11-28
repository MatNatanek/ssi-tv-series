package com.wieik.ssitvseries.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user", schema = "public")
public class UserEntity implements Serializable {

    private static final long serialVersionUID = 4963989636578192356L;

    @Id
    @GeneratedValue
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
