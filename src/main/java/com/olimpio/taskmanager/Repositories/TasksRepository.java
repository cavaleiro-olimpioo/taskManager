package com.olimpio.taskmanager.Repositories;

import com.olimpio.taskmanager.models.TaskModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TasksRepository extends JpaRepository<TaskModel, UUID> {
}
