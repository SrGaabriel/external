package com.engine.external.project.server;

import com.engine.external.project.event.EventManager;
import com.engine.external.project.util.tasks.TaskManager;

public interface Server {

    /**
     *
     * @since 0.1
     * @return The server's {@link EventManager}
     */
    public abstract EventManager getEventManager();

    /**
     * Overrides the current server' {@link EventManager}
     *
     * @since 0.1
     * @param eventManager The new event manager
     */
    public abstract void setEventManager(EventManager eventManager);

    /**
     * @since 0.1
     * @return The server's {@link TaskManager}
     */
    public abstract TaskManager getTaskManager();

    /**
     * Overrides the current server's {@link TaskManager}
     *
     * @since 0.1
     * @param taskManager The new task manager
     */
    public abstract void setTaskManager(TaskManager taskManager);


}
