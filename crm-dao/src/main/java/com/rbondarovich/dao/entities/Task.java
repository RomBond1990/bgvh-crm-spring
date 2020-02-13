package com.rbondarovich.dao.entities;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "tasks")
@Data
public class Task implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "pk_task_id")
    private int id;

    @Column(name = "task_name")
    private String taskName;

    @Column(name = "priority")
    private int priority;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_of_creation")
    @CreationTimestamp
    private LocalDateTime dateOfCreation;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_of_end")
    private LocalDateTime dateOfEnd;

    @ManyToOne(optional = false)
    @JoinColumn(name = "fk_project_id")
    private Project project;

    @ManyToOne(optional = false)
    @JoinColumn(name = "fk_profile_id")
    private Profile profile;

    @ManyToOne
    @JoinColumn (name = "fk_parent_task_id")
    private Task taskParent;

    @OneToMany(mappedBy = "taskParent",
               cascade = CascadeType.ALL)
    private List<Task> subTasks;

    @OneToMany(fetch = FetchType.LAZY,
               mappedBy = "task",
               cascade = CascadeType.ALL)
    private Set<TaskDuration> durations;


    public Task() {
    }



}
