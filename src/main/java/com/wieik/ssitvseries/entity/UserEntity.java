package com.wieik.ssitvseries.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.wieik.ssitvseries.enums.Role;
import com.wieik.ssitvseries.model.Episode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users", schema = "public")
public class UserEntity implements Serializable {

    private static final long serialVersionUID = 4963989636578192356L;

    @Id
    @SequenceGenerator(name = "users_id_user_seq", sequenceName = "users_id_user_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_id_user_seq")
    @Column(name = "id_user")
    private Integer idUser;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column
    String login;

    @Column
    String password;

    @Column
    String role;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JsonIgnore
    @JoinTable(name = "friendship",
            joinColumns = {@JoinColumn(name = "id_user")},
            inverseJoinColumns = {@JoinColumn(name = "id_friend")})
    private Set<UserEntity> friendsSet = new HashSet<UserEntity>();

    @ManyToMany(mappedBy = "friendsSet")
    @JsonIgnore
    private Set<UserEntity> usersSet = new HashSet<UserEntity>();

    @ManyToMany(fetch=FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(name = "watched_episode", joinColumns = @JoinColumn(name = "fk_id_user"), inverseJoinColumns = @JoinColumn(name = "fk_id_episode"))
    @JsonManagedReference
    private Set<EpisodeEntity> watchedEpisodes = new HashSet<>();

    @JsonManagedReference
    @OneToMany(mappedBy = "userEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<CommentEntity> setOfComments = new HashSet<>();


    public void addFriend(UserEntity userEntity) {
        friendsSet.add(userEntity);
    }

    public void removeFriend(UserEntity userEntity) {
        friendsSet.remove(userEntity);
    }

    public void addWatchedEpisode(EpisodeEntity episodeEntity){
        watchedEpisodes.add(episodeEntity);
    }

    public void removeWatchedEpisode(EpisodeEntity episodeEntity){
        watchedEpisodes.remove(episodeEntity);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return idUser.equals(that.idUser) &&
                lastName.equals(that.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUser, lastName);
    }
}
