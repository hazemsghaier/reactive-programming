package org.hazem.reactive.databaseintegration.mapper;

import org.hazem.reactive.databaseintegration.dto.reponse.TaskResponse;
import org.hazem.reactive.databaseintegration.dto.request.AddTaskRequest;
import org.hazem.reactive.databaseintegration.dto.request.UpdateTaskRequest;
import org.hazem.reactive.databaseintegration.entity.TaskEntity;

public class TaskMapper {
    public static TaskEntity toTaskEntity(AddTaskRequest addTaskRequest) {
        TaskEntity taskEntity = new TaskEntity();
        taskEntity.setId(addTaskRequest.getId());
        taskEntity.setTitle(addTaskRequest.getTitle());
        taskEntity.setDescription(addTaskRequest.getDescription());
        taskEntity.setUserId(addTaskRequest.getUserId());
        return taskEntity;
    }
    public static UpdateTaskRequest toUpdateTaskRequest(TaskEntity taskEntity) {
        if (taskEntity == null) {
            return null;
        }
        UpdateTaskRequest updateTaskRequest = new UpdateTaskRequest();
        updateTaskRequest.setId(taskEntity.getId());
        updateTaskRequest.setTitle(taskEntity.getTitle());
        updateTaskRequest.setDescription(taskEntity.getDescription());
        updateTaskRequest.setStatus(taskEntity.getStatus());
        updateTaskRequest.setUserId(taskEntity.getUserId());
        return updateTaskRequest;
    }
    public static TaskEntity toTaskEntity(UpdateTaskRequest updateTaskRequest) {
        if (updateTaskRequest == null) {
            return null;
        }
        TaskEntity taskEntity = new TaskEntity();
        taskEntity.setId(updateTaskRequest.getId());
        taskEntity.setTitle(updateTaskRequest.getTitle());
        taskEntity.setDescription(updateTaskRequest.getDescription());
        taskEntity.setStatus(updateTaskRequest.getStatus());
        taskEntity.setUserId(updateTaskRequest.getUserId());
        return taskEntity;
    }
    public static AddTaskRequest toAddTaskRequest(TaskEntity taskEntity) {
        if (taskEntity == null) {
            return null;
        }
        AddTaskRequest addTaskRequest = new AddTaskRequest();
        addTaskRequest.setId(taskEntity.getId());
        addTaskRequest.setTitle(taskEntity.getTitle());
        addTaskRequest.setDescription(taskEntity.getDescription());
        addTaskRequest.setUserId(taskEntity.getUserId());
        return addTaskRequest;
    }

    public static TaskResponse toTaskResponse(TaskEntity taskEntity) {
        if (taskEntity == null) {
            return null;
        }
        TaskResponse taskResponse = new TaskResponse();
        taskResponse.setId(taskEntity.getId());
        taskResponse.setTitle(taskEntity.getTitle());
        taskResponse.setDescription(taskEntity.getDescription());
        taskResponse.setStatus(taskEntity.getStatus());
        taskResponse.setUserId(taskEntity.getUserId());
        return taskResponse;

    }
}
