package com.engine.external.project.events

import com.engine.external.project.event.EventManager
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

    override fun process(event: AbstractEvent) {
        eventSink.next(event)
    }

    override fun <T : AbstractEvent?> on(klass: Class<T>): Flux<T> {
        return fluxProcessor.publishOn(scheduler)
            .log()
            .ofType(klass)
    }

    override fun registerListener(holder: EventHolder) {
        listeners[holder] = on(AbstractEvent::class.java).subscribe { event: AbstractEvent? ->
            holder.onEvent(event)
        }
    }

    override fun getListeners(): Collection<EventHolder> {
        return listeners.keys
    }

    override fun unregisterListener(holder: EventHolder) {
        listeners.remove(holder)!!.dispose()
    }
}
