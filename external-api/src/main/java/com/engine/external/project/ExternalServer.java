package com.engine.external.project;

import com.engine.external.project.event.EventManager;
import com.engine.external.project.utils.tasks.TaskManager;

public abstract class ExternalServer {

    public abstract void start();

    public abstract EventManager getEventManager();

    public abstract void setEventManager(EventManager eventManager);

    public abstract TaskManager getTaskManager();

    public abstract void setTaskManager(TaskManager taskManager);

}
