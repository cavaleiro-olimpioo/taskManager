package com.olimpio.taskmanager.Repositories;

import com.olimpio.taskmanager.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<UserModel, UUID> {
    @Query("SELECT u.username FROM UserModel u")
    public List<String> findAllUsernames();

    @Query("SELECT u.password FROM UserModel u WHERE u.username = :name")
    public String findPassword(@Param("name") String name);
}
