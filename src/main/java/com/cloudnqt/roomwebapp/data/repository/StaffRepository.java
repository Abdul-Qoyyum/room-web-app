package com.cloudnqt.roomwebapp.data.repository;

import com.cloudnqt.roomwebapp.data.entity.StaffEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StaffRepository extends JpaRepository<StaffEntity, UUID> {
}
