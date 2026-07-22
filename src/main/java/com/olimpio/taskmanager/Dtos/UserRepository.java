package com.olimpio.taskmanager.Dtos;

import com.olimpio.taskmanager.models.UserModel;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

@Transactional
public interface UserRepository extends JpaRepository<UserModel, UUID> {

}
