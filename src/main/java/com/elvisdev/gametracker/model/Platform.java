package com.elvisdev.gametracker.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "platforms")
public class Platform {
    @Id
    private Integer id;
    @Column(unique = true)
    private String name;
    private String icon_name;
    @ManyToMany(mappedBy = "platforms")
    private Set<Game> games;
}
