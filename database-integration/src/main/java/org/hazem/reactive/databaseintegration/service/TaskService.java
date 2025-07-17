package org.hazem.reactive.databaseintegration.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hazem.reactive.databaseintegration.dto.reponse.TaskResponse;
import org.hazem.reactive.databaseintegration.dto.request.AddTaskRequest;
import org.hazem.reactive.databaseintegration.dto.request.UpdateTaskRequest;
import org.hazem.reactive.databaseintegration.exeptions.DataAccessException;
import org.hazem.reactive.databaseintegration.exeptions.RessourceNotFoundExeception;
import org.hazem.reactive.databaseintegration.mapper.TaskMapper;
import org.hazem.reactive.databaseintegration.repository.TaskRepository;
import org.hazem.reactive.databaseintegration.repository.UserRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Objects;

@RequiredArgsConstructor
@Service
@Slf4j
public class TaskService implements ITaskService {
    private final UserRepository userRepository;
    private final TaskRepository taskRepository;
    @Override
    public Mono<TaskResponse> addTask(AddTaskRequest addTaskRequest) {
        //verifier si le user exist dans la bd
        return Mono.just(addTaskRequest)
                .filter(task -> task.getUserId() != null)
                .switchIfEmpty(Mono.error(new RuntimeException("User id cannot be null")))
                .flatMap(task -> userRepository.findById(task.getUserId()))
                .switchIfEmpty(Mono.error(new RuntimeException("User not found")))
                .flatMap(user -> taskRepository.save(TaskMapper.toTaskEntity(addTaskRequest)))
                .map(TaskMapper::toTaskResponse)
                .doOnSuccess(result -> log.debug("Task created for user {}", addTaskRequest.getUserId()))
                .doOnError(err -> log.error("Error creating task for user {}", addTaskRequest.getUserId(), err));

    }
    @Override
    public Flux<TaskResponse> getTasksByUserId(Integer userId) {

        return Mono.just(userId).filter(Objects::nonNull)
                .switchIfEmpty(Mono.error(new RuntimeException("User id cannot be null")))
                .flatMap(user -> userRepository.findById(userId))
                .switchIfEmpty(Mono.error(new RuntimeException("User not found")))
                .flatMapMany(user -> taskRepository.findByUserId(user.getId()))
                .map(TaskMapper::toTaskResponse)
                .onErrorMap(err->!(err instanceof RessourceNotFoundExeception),
                        err-> new DataAccessException("Error while getting tasks for user "))
                .doOnComplete(() -> log.debug("Tasks found for user {}", userId)).doOnError
        (err -> log.error("Error getting tasks for user {}", userId, err));
    }


    @Override
    public Mono<TaskResponse> updateTask(UpdateTaskRequest updateTaskRequest) {
        return Mono.just(updateTaskRequest).filter(Objects::nonNull)
                .switchIfEmpty(Mono.error(new RuntimeException("Task dosent need to be null")))
                .filter(task -> task.getId() != null)
                .switchIfEmpty(Mono.error(new RuntimeException("Task id cannot be null")))
                .flatMap(task ->
                    taskRepository.findById(task.getId())
                           .switchIfEmpty(Mono.error(new RuntimeException("Task not found")))
                           .flatMap(taskEntity ->{
                               if(task.getStatus() != null) {
                                   taskEntity.setStatus(task.getStatus());
                               }
                               if(task.getTitle() != null) {
                                   taskEntity.setTitle(task.getTitle());
                               }
                               if(task.getDescription() != null) {
                                   taskEntity.setDescription(task.getDescription());
                               }
                               return taskRepository.save(taskEntity);
                           })
                           .map(TaskMapper::toTaskResponse)
                ).doOnSuccess(result -> log.debug("Task updated for user {}", updateTaskRequest.getUserId()))
                .doOnError(err -> log.error("Error updating task for user {}", updateTaskRequest.getUserId(), err)).onErrorMap(
                        err->!(err instanceof RessourceNotFoundExeception),
                        err-> new DataAccessException("Error while updating task with id ")
                );
    }
    /**
     * Retrieve a task by id.
     *
     * @param taskId the id of the task
     * @return a {@link Mono} containing the task or an error if the task is not found
     */
    @Override
    public Mono<TaskResponse> getTaskById(Integer taskId) {
        return Mono.just(taskId).filter(Objects::nonNull).switchIfEmpty(Mono.error(new RuntimeException("Task id cannot be null")))
                .flatMap( id-> taskRepository.findById(id))
                .switchIfEmpty(Mono.error(new RuntimeException("Task not found")))
                .map(TaskMapper::toTaskResponse)
                .doOnSuccess(result -> log.info("Task found with id {}",taskId))
                .doOnError(err -> log.error("Error getting task with id {}",taskId,err))
                .onErrorMap(err->!(err instanceof RessourceNotFoundExeception),
                        err-> new DataAccessException("Error while getting task with id "));
    }

    @Override
    public Mono<Void> deleteTaskById(Integer taskId) {
         return Mono.just(taskId).filter(Objects::nonNull).switchIfEmpty(Mono.error(new RuntimeException("Task id cannot be null")))
                .flatMap( id-> taskRepository.deleteById(id))
                 .doOnSuccess((t)-> log.info("Task deleted with id {}",taskId))
                 .doOnError(err -> log.error("Error deleting task with id {}",taskId,err))
                 .onErrorMap(err->!(err instanceof RessourceNotFoundExeception),err ->
                         new DataAccessException("Error while deleting task with id "));
    }
}
