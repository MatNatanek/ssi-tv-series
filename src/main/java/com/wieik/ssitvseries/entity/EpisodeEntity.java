package com.wieik.ssitvseries.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "episode", schema = "public")
public class EpisodeEntity implements Serializable {

    private static final long serialVersionUID = -1029133493542866090L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_episode")
    private Integer idEpisode;

    @Column(name = "title")
    private String title;

}
