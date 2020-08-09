package com.engine.external.project.event;

import com.engine.external.project.event.events.AbstractEvent;
import com.engine.external.project.event.events.EventHolder;
import reactor.core.publisher.Flux;

import java.util.Collection;

public interface EventManager {

    void process(AbstractEvent event);

    <T extends AbstractEvent> Flux<T> on(Class<T> klass);

    void registerListener(EventHolder holder);

    Collection<EventHolder> getListeners();

    void unregisterListener(EventHolder holder);

}
