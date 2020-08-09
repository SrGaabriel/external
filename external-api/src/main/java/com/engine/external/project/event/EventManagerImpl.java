package com.engine.external.project.event;

import com.engine.external.project.event.events.AbstractEvent;
import com.engine.external.project.event.events.EventHolder;
import reactor.core.Disposable;
import reactor.core.publisher.*;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class EventManagerImpl implements EventManager {

    private final Map<EventHolder, Disposable> listeners = new HashMap<>();

    private final FluxProcessor<AbstractEvent, ? super AbstractEvent> abstractEventFluxProcessor = Processors.multicast();
    private final Scheduler scheduler = Schedulers.newSingle("Event Manager");

    private final Sinks.StandaloneFluxSink<Object> eventSink = Sinks.multicast();
    @Override
    public void process(AbstractEvent event) {
        eventSink.next(event);
    }

    @Override
    public <T extends AbstractEvent> Flux<T> on(Class<T> klass) {
        return abstractEventFluxProcessor.publishOn(scheduler)
                .ofType(klass);
    }

    @Override
    public void registerListener(EventHolder holder) {
        on(AbstractEvent.class).subscribe(holder::onEvent);
    }

    @Override
    public Collection<EventHolder> getListeners() {
        return listeners.keySet();
    }

    @Override
    public void unregisterListener(EventHolder holder) {
        listeners.remove(holder).dispose();
    }

}
