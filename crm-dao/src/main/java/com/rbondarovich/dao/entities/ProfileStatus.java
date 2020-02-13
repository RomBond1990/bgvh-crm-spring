package com.rbondarovich.dao.entities;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "profile_statuses")
@Data
public class ProfileStatus implements Serializable {

    @Id
    @Column(name = "pk_status_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(name = "status_name")
    private String statusName;

    public ProfileStatus() {

    }

}
