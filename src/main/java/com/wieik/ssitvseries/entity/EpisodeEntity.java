package com.wieik.ssitvseries.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
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




}
