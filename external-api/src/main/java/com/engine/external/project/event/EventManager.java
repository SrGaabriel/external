package com.engine.external.project.event;

import com.engine.external.project.event.models.EventHolder;
import reactor.core.publisher.Flux;

import java.util.Collection;

public interface EventManager {

    /**
     * Will call an {@link AbstractEvent} that will notify all {@link EventHolder}
     *
     * @param event The event
     * @since 0.1
     */
    void process(AbstractEvent event);

    /**
     * @since 0.1
     * @param klass Event expectancy's class
     * @return The flux created by the {@link reactor.core.publisher.FluxProcessor}
     */
    <T extends AbstractEvent> Flux<T> on(Class<T> klass);

    /**
     * Registers an {@link EventHolder}
     *
     * @since 0.1
     * @param holder The listener
     */
    void registerListener(EventHolder holder);

    /**
     * Returns all registered {@link EventHolder}
     *
     * @since 0.1
     * @return All registered [EventHolder]
     */
    Collection<EventHolder> getListeners();

    /**
     * Removes a {@link EventHolder} and disposes it
     *
     * @since 0.1
     * @param holder The listener
     */
    void unregisterListener(EventHolder holder);

}
