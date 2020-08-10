package com.engine.external.project.server;

import com.engine.external.project.event.EventManager;
import com.engine.external.project.schedulers.SchedulerManager;

public interface Server {

    /**
     *
     * @since 0.1
     * @return The server's {@link EventManager}
     */
    EventManager getEventManager();

    /**
     * Overrides the current server' {@link EventManager}
     *
     * @since 0.1
     * @param eventManager The new event manager
     */
    void setEventManager(EventManager eventManager);

    /**
     * @since 0.1
     * @return The server's {@link SchedulerManager}
     */
    SchedulerManager getSchedulerManager();

    /**
     * Overrides the current server's {@link SchedulerManager}
     *
     * @since 0.1
     * @param taskManager The new task manager
     */
    void setSchedulerManager(SchedulerManager taskManager);


}
