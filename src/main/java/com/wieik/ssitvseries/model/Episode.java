package com.wieik.ssitvseries.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Episode implements Serializable {

    private static final long serialVersionUID = 6859719923629306905L;
    private String title;
}
