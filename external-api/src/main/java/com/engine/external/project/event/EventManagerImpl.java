package com.engine.external.project.event;

import com.engine.external.project.ExternalServer;
import com.engine.external.project.event.events.AbstractEvent;
import com.engine.external.project.event.events.EventHolder;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxProcessor;
import reactor.core.publisher.Processors;
import reactor.core.publisher.Sinks;
import reactor.core.scheduler.Scheduler;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public final class EventManagerImpl implements EventManager {

    private final Map<EventHolder, Disposable> listeners = new HashMap<>();

    private final Scheduler scheduler;
    private final FluxProcessor<AbstractEvent, ? super AbstractEvent> abstractEventFluxProcessor = Processors.multicast();

    public EventManagerImpl(ExternalServer server) {
        scheduler = server.getScheduler();
    }

    private final Sinks.StandaloneFluxSink<Object> eventSink = Sinks.multicastNoWarmup();
    @Override
    public void process(AbstractEvent event) {
        eventSink.next(event);
    }

    @Override
    public <T extends AbstractEvent> Flux<T> on(Class<T> klass) {
        return abstractEventFluxProcessor.publishOn(scheduler)
                .log()
                .ofType(klass);
    }

    @Override
    public void registerListener(EventHolder holder) {
        listeners.put(holder, on(AbstractEvent.class).subscribe(holder::onEvent));
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
