package com.wieik.ssitvseries.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@ToString
@Entity
@Table(name = "episode", schema = "public")
public class EpisodeEntity implements Serializable {

    private static final long serialVersionUID = -1029133493542866090L;

    @Id
    @SequenceGenerator(name = "episode_id_episode_seq", sequenceName = "episode_id_episode_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "episode_id_episode_seq")
    @Column(name = "id_episode", updatable = false)
    private Integer idEpisode;

    @Column(name = "title")
    private String title;

    private Integer season;

    @Column(name = "episode_number")
    private Integer episodeNumber;

    @JsonBackReference
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name="id_tv_series")
    private TvSeriesEntity tvSeriesEntity;

    @JsonBackReference
    @ManyToMany(fetch=FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(name = "watched_episode", joinColumns = @JoinColumn(name = "fk_id_episode"), inverseJoinColumns = @JoinColumn(name = "fk_id_user"))
    private Set<UserEntity> setOfUsersThatWatched = new HashSet<>();



    public void addUserThatWatched(UserEntity userEntity){
        if(userEntity!= null){
            setOfUsersThatWatched.add(userEntity);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EpisodeEntity that = (EpisodeEntity) o;
        return idEpisode.equals(that.idEpisode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEpisode);
    }
}
