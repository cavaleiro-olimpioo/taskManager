package com.olimpio.taskmanager.Repositories;

import com.olimpio.taskmanager.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface UserRepository extends JpaRepository<UserModel, UUID> {
    @Query("SELECT u.username FROM UserModel u")
    public List<String> findAllUsernames();
}
