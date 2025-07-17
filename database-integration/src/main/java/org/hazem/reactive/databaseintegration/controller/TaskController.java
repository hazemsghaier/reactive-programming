package org.hazem.reactive.databaseintegration.controller;

import lombok.RequiredArgsConstructor;
import org.hazem.reactive.databaseintegration.dto.reponse.TaskResponse;
import org.hazem.reactive.databaseintegration.dto.request.AddTaskRequest;
import org.hazem.reactive.databaseintegration.dto.request.UpdateTaskRequest;
import org.hazem.reactive.databaseintegration.service.ITaskService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    private final ITaskService taskService;

    @PostMapping
    public Mono<TaskResponse> addTask(@RequestBody AddTaskRequest addTaskRequest) {
        return taskService.addTask(addTaskRequest);
    }

    @GetMapping("/user/{userId}")
    public Flux<TaskResponse> getTasksByUserId(@PathVariable Integer userId) {
        return taskService.getTasksByUserId(userId);
    }

    @GetMapping("/{taskId}")
    public Mono<TaskResponse> getTaskById(@PathVariable Integer taskId) {
        return taskService.getTaskById(taskId);
    }

    @DeleteMapping("/{taskId}")
    public Mono<Void> deleteTaskById(@PathVariable Integer taskId) {
        return taskService.deleteTaskById(taskId);
    }

    @PutMapping
    public Mono<TaskResponse> updateTask(@RequestBody UpdateTaskRequest updateTaskRequest) {
        return taskService.updateTask(updateTaskRequest);
    }
}

