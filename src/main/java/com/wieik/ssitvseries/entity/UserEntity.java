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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Integer idUser;

    @Column(name = "last_name")
    private String lastName;

    //Relationship owner
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "friendship",
            joinColumns = {@JoinColumn(name = "fk_id_user")},
            inverseJoinColumns = {@JoinColumn(name = "fk_id_friend")})
    private Set<UserEntity> usersSet = new HashSet<UserEntity>();

    @ManyToMany(mappedBy = "usersSet")
    private Set<UserEntity> friendsSet = new HashSet<UserEntity>();


}