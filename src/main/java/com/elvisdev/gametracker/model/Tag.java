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
@Table(name = "tags")
public class Tag {
    @Id
    private Integer id;
    @Column(unique = true)
    private String name;
    @ManyToMany(mappedBy = "tags")
    private Set<Game> games;
}
