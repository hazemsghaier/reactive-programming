package org.hazem.reactive.databaseintegration.service;

import org.hazem.reactive.databaseintegration.dto.reponse.TaskResponse;
import org.hazem.reactive.databaseintegration.dto.request.AddTaskRequest;
import org.hazem.reactive.databaseintegration.dto.request.UpdateTaskRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ITaskService {
    Mono<TaskResponse> addTask(AddTaskRequest addTaskRequest);

    Flux<TaskResponse> getTasksByUserId(Integer userId);

    Mono<TaskResponse> updateTask(UpdateTaskRequest updateTaskRequest);

    Mono<TaskResponse> getTaskById(Integer taskId);

    Mono<Void> deleteTaskById(Integer taskId);
}
