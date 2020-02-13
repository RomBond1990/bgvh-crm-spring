package com.rbondarovich.dao.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "profile_positions")
@Data
public class ProfilePosition implements Serializable {

    @Id
    @Column(name = "pk_position_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(name = "position_name")
    private String positionName;

    public ProfilePosition() {
    }

}
