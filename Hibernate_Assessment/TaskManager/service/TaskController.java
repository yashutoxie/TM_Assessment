package com.springboot.TaskManager.service;

import com.springboot.TaskManager.Task;
import com.springboot.TaskManager.User;
import com.springboot.TaskManager.repository.TaskRepo;
import com.springboot.TaskManager.repository.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskRepo taskRepo;

    @Autowired
    private UserRepo userRepo;

    // ✅ Optimized: Get tasks for current user from DB, not memory
    @GetMapping
    public List<Task> getTasks(Authentication authentication) {
        String username = authentication.getName();
        return taskRepo.findByUser_Username(username);
    }

    @PostMapping
    public Task createTask(@RequestBody Task task, Authentication authentication) {
        String username = authentication.getName();
        User user = userRepo.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        task.setUser(user);
        return taskRepo.save(task);
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task updatedTask, Authentication authentication) {
        Task task = taskRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        if (!task.getUser().getUsername().equals(authentication.getName())) {
            throw new RuntimeException("Unauthorized");
        }

        task.setTitle(updatedTask.getTitle());
        task.setDescription(updatedTask.getDescription());
        task.setStatus(updatedTask.getStatus());
        return taskRepo.save(task);
    }

    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable Long id, Authentication authentication) {
        Task task = taskRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        if (!task.getUser().getUsername().equals(authentication.getName())) {
            throw new RuntimeException("Unauthorized");
        }

        taskRepo.delete(task);
        return "Task deleted successfully.";
    }
}
