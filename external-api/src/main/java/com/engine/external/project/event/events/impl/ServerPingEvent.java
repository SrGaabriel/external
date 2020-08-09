package com.engine.external.project.event.events.impl;

import com.engine.external.project.event.events.AbstractEvent;

public class ServerPingEvent extends AbstractEvent {

    @Override
    public String getName() {
        return "Server Ping Event";
    }

}
