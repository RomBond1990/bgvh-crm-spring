package com.rbondarovich.dao.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "profiles")
@Data
public class Profile implements Serializable {

    @Id
    @Column(name = "pk_group_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;


    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_group_id")
    private Group group;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_position_id")
    private ProfilePosition position;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_status_id")
    private ProfileStatus status;

    @ManyToMany
    @JoinTable(name = "projects_to_profiles",
            joinColumns = @JoinColumn(name = "fk_profile_id"),
            inverseJoinColumns = @JoinColumn(name = "fk_project_id"))
    private Set<Project> projects;

    public Profile() {

    }


}
