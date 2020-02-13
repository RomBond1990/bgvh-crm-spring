package com.rbondarovich.dao;

import com.rbondarovich.dao.entities.ProfileStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileStatusDao extends JpaRepository<ProfileStatus, Integer> {
}
