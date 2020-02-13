package com.rbondarovich.dao;

import com.rbondarovich.dao.entities.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileDao extends JpaRepository<Profile, Integer> {
}
