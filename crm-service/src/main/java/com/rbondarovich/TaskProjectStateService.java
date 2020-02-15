package com.rbondarovich;

import com.rbondarovich.dao.entities.TaskProjectState;

public interface TaskProjectStateService {

    Iterable<TaskProjectState> getAllTaskProjectStates();

    TaskProjectState getTaskProjectStateById(Integer taskProjectStateId);

    void saveTaskProjectState (TaskProjectState taskProjectState);

    void deleteTaskProjectState (Integer taskProjectStateId);
}
