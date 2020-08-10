package com.engine.external.project.event.models;

import com.engine.external.project.event.AbstractEvent;

public interface EventHolder {

    void onEvent(AbstractEvent event);

}
