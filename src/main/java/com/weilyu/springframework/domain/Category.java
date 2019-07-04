package com.weilyu.springframework.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Set;


@Data // includes args-constructor getters setter equal hashCode toString
@EqualsAndHashCode(exclude = {"recipes"})
// a circular reference is created because of the bi-directional relationship
// and this will make lombok unhappy, we need to exclude the recipes from the automatically generated equal and hashcode function
@Entity
public class Category { //opt + enter to create test

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;

    @ManyToMany(mappedBy = "categories")
    private Set<Recipe> recipes;

}
