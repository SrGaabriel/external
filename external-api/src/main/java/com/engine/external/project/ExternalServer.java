package com.engine.external.project;

import com.engine.external.project.event.EventManager;

public abstract class ExternalServer {

    private EventManager eventManager;

    public EventManager getEventManager() {
        return eventManager;
    }

    public void setEventManager(EventManager eventManager) {
        this.eventManager = eventManager;
    }

}
