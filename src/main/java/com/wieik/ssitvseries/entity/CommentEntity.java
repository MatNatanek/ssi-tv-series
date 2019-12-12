package com.wieik.ssitvseries.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "episode", schema = "public")
public class CommentEntity implements Serializable {

    private static final long serialVersionUID = 881105127420242837L;

    @Id
    @SequenceGenerator(name = "comment_id_comment_seq", sequenceName = "comment_id_comment_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comment_id_comment_seq")
    @Column(name = "id_comment", updatable = false)
    private Integer idComment;

    String description;

    @JsonBackReference
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name="id_user")
    private UserEntity userEntity;


    @JsonBackReference
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name="id_tv_series")
    private TvSeriesEntity tvSeriesEntity;



}
