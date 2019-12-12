package com.wieik.ssitvseries.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "tv_series", schema = "public")
public class TvSeriesEntity implements Serializable {

    private static final long serialVersionUID = -710760856391449438L;

    @Id
    @SequenceGenerator(name = "tv_series_id_tv_series_seq", sequenceName = "tv_series_id_tv_series_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tv_series_id_tv_series_seq")
    @Column(name = "id_tv_series")
    private Integer idTvSeries;

    @Column(name = "title")
    private String title;

    private String description;

    private String genres;

    @Column(name = "number_of_seasons")
    private Integer numberOfSeasons;

    private String imageurl;

    @JsonManagedReference
    @OneToMany(mappedBy = "tvSeriesEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<EpisodeEntity> setOfEpisodes = new HashSet<>();

    public void addEpisode(EpisodeEntity episodeEntity){
        setOfEpisodes.add(episodeEntity);
        episodeEntity.setTvSeriesEntity(this);
    }

    public void removeEpisode(EpisodeEntity episodeEntity){
        setOfEpisodes.remove(episodeEntity);
        episodeEntity.setTvSeriesEntity(null);
    }

}
