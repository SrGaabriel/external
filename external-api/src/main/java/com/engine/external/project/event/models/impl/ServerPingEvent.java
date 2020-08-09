package com.engine.external.project.event.models.impl;

import com.engine.external.project.event.models.AbstractEvent;

public class ServerPingEvent extends AbstractEvent {

    @Override
    public String getName() {
        return "Server Ping Event";
    }

}
