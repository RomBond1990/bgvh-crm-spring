package com.rbondarovich.dao.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name="task_project_states")
@Data
public class TaskProjectState implements Serializable {

    @Id
    @Column(name="pk_status_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "status_name")
    private String stateName;

    public TaskProjectState() {
    }


}
