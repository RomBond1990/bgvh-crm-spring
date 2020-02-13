package com.rbondarovich.dao;

import com.rbondarovich.dao.entities.ProfilePosition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfilePositionDao extends JpaRepository<ProfilePosition, Integer> {
}
