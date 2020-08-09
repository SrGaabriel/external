package com.engine.external.project;

import com.engine.external.project.event.EventManager;
import com.engine.external.project.utils.tasks.TaskManager;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

public abstract class ExternalServer {

    private EventManager eventManager;
    private TaskManager taskManager;

    private final Scheduler scheduler = Schedulers.newSingle("Main Scheduler");

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

    public Scheduler getScheduler() {
        return scheduler;
    }
}
