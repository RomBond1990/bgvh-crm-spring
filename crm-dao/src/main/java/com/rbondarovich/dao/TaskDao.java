package com.rbondarovich.dao;

import com.rbondarovich.dao.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskDao extends JpaRepository<Task, Integer> {
}
