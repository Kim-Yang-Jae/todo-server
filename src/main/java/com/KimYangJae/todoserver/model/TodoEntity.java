package com.KimYangJae.todoserver.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class TodoEntity {

    private Long id;

    private String title;

    private Long order;

}
