package com.rbondarovich.dao;

import com.rbondarovich.dao.entities.TaskProjectState;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskProjectStateDao extends JpaRepository <TaskProjectState, Integer> {
}
