package com.engine.external.project;

import com.engine.external.project.event.EventManager;
import com.engine.external.project.utils.tasks.TaskManager;

public abstract class ExternalServer {

    private EventManager eventManager;
    private TaskManager taskManager;

    public EventManager getEventManager() {
        return eventManager;
    }

    public void setEventManager(EventManager eventManager) {
        this.eventManager = eventManager;
    }

    public TaskManager getTaskManager() {
        return taskManager;
    }

    public void setTaskManager(TaskManager taskManager) {
        this.taskManager = taskManager;
    }

}
