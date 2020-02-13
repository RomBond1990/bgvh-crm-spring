package com.rbondarovich.dao;

import com.rbondarovich.dao.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectDao extends JpaRepository<Project, Integer> {
}
