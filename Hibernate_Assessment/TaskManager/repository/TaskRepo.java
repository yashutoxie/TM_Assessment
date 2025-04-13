package com.springboot.TaskManager.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.springboot.TaskManager.Task;

@Repository
public interface TaskRepo extends JpaRepository<Task, Long> {
    List<Task> findByUser_Username(String username);
}