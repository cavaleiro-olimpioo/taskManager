package com.olimpio.taskmanager.Dtos;

import com.olimpio.taskmanager.models.TaskModel;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

@Transactional
public interface TasksRepository extends JpaRepository<TaskModel, UUID> {
}
