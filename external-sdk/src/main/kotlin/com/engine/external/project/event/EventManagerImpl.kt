package com.engine.external.project.event

import com.engine.external.project.event.models.AbstractEvent
import com.engine.external.project.event.models.EventHolder
import reactor.core.Disposable
import reactor.core.publisher.Flux
import reactor.core.publisher.FluxProcessor
import reactor.core.publisher.Processors
import reactor.core.publisher.Sinks
import reactor.core.scheduler.Schedulers

class EventManagerImpl : EventManager {

    private val listeners: MutableMap<EventHolder, Disposable> = HashMap()
    private val scheduler = Schedulers.newSingle("Event Scheduler")
    private val fluxProcessor: FluxProcessor<AbstractEvent, in AbstractEvent> = Processors.multicast()
    private val eventSink = Sinks.multicastNoWarmup<Any>()

    /**
     * Will call an [AbstractEvent] that will notify all [EventHolder]
     *
     * @param event The event
     * @since 0.1
     */
    override fun process(event: AbstractEvent) {
        eventSink.next(event)
    }

    /**
     * Will return the flux
     *
     * @since 0.1
     * @param klass Event expectancy's class
     * @return The flux created by the [FluxProcessor]
     */
    override fun <T : AbstractEvent?> on(klass: Class<T>): Flux<T> {
        return fluxProcessor.publishOn(scheduler)
            .log()
            .ofType(klass)
    }

    /**
     * Registers an [EventHolder]
     *
     * @since 0.1
     * @param holder The listener
     */
    override fun registerListener(holder: EventHolder) {
        listeners[holder] = on(AbstractEvent::class.java).subscribe(holder::onEvent)
    }

    /**
     * Returns all registered [EventHolder]
     *
     * @since 0.1
     * @return All registered [EventHolder]
     */
    override fun getListeners(): Collection<EventHolder> {
        return listeners.keys
    }

    /**
     * Removes a [EventHolder] and disposes it
     *
     * @since 0.1
     * @param holder The listener
     */
    override fun unregisterListener(holder: EventHolder) {
        listeners.remove(holder)!!.dispose()
    }
}
